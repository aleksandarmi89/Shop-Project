package cubes.main.entity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;





	@Entity
	@Table(name = "products")
	public class Product {
		
		@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinTable(name = "products_stickers",joinColumns =@JoinColumn(name="product_id"),inverseJoinColumns = @JoinColumn(name="sticker_id"))
	private List<Sticker> stickers;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "manual_id")
	private Manual manual;
	


	public Manual getManual() {
		return manual;
	}

	public void setManual(Manual manual) {
		this.manual = manual;
	}

	public List<Sticker> getStickers() {
			return stickers;
	}

	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
		}

		public void setId(int id) {
			this.id = id;
		}

		
	//	 public Sticker getSticker() { return sticker; }
		 
	//	 public void setSticker(Sticker sticker) { this.sticker = sticker; }
		 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int id;
		@Column
		private String title;
		@Column
		private String description;
		@Column
		private String image;
		@Column
		private double price;
		@Column
		private int quantity;
		//@Column(name = "category_id")
		//private int categoryId;
		//@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		//@JoinColumn(name = "manual_id")
		//private Manual manual;
		@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
		@JoinColumn(name="category_id")
		private Category category;
		@Column
		private boolean homepage;
		
		
		
		public Product () {}

		public Product(String title, String description, String image, double price, int quantity) {
			super();
			this.title = title;
			this.description = description;
			this.image = image;
			this.price = price;
			this.quantity = quantity;
			
		}

		

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		//public Manual getManual() {
		//	return manual;
	//	}

		//public void setManual(Manual manual) {
		//	this.manual = manual;
		//}

		public int getId() {
			return id;
		}

		
		
		public boolean getHomepage() {
			return homepage;
		}

		public void setHomepage(boolean homepage) {
			this.homepage = homepage;
		}
		public Sticker getRandomSticker() {
			if(stickers==null||stickers.size()==0) {
			return null;}
			Random random=new Random();
			
			return stickers.get(random.nextInt(stickers.size()));
		}
		public String getFormatedPrice() {
		
			
			
			return String.format("%,.2f", price);
		}
		
		public String getCeoTitle() {
			return title.replace("[^a-zA-Z0-9]", "-").toLowerCase();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return title +" - "+id;}

}
