package cubes.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "categories")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
	private int id;
@Column
private String name;
@Column
private String image;
@Column
private boolean homepage;

@OneToMany (cascade= { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "category", fetch = FetchType.EAGER)
private List<Product>products;
public Category() {}

public Category(String id) {
	 this.id=Integer.valueOf(id);
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public boolean getHomepage() {
	return homepage;
}

public void setHomepage(boolean homepage) {
	this.homepage = homepage;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
	public String toString() {
		
		return name+" - "+id;
	}
}
