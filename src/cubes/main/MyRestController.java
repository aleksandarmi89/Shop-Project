package cubes.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cubes.main.dao.ProductDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.entity.Category;
import cubes.main.entity.Product;
import cubes.main.entity.Sticker;
import cubes.main.rest.CategoryException;
import cubes.main.rest.MessageResponse;
import cubes.main.rest.request_body.ProductFilter;
import cubes.main.rest.response.BasicProductResponse;
import cubes.main.rest.response.SettingsResponse;
import cubes.main.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class MyRestController {
	@Autowired
	private CategoryService categoryService;
@Autowired
	private StickerDAO stickerDAO;
@Autowired
private ProductDAO poduductDAO;
//-----------------------------------CATEGORY------------------------------------------
	@GetMapping(value = "/categories")
	public List<Category> getCategories(){
		List<Category> list=categoryService.getCategoryList();
		return list;
	}
	
	@GetMapping(value = "/categories/{id}")
	public Category getCategoryById(@PathVariable int id){
		
			Category category=categoryService.getByCategoryId(id);
		if(category==null) {
			throw new CategoryException("Kategorija sa id: "+id+" ne postoji u bazi podataka...");
			}
		return category;
	}
	@PostMapping(value = "/categories")
	public MessageResponse postCategory(@RequestBody Category category) {
		category.setId(0);
		categoryService.saveCategory(category);
		
		return new MessageResponse(HttpStatus.OK.value(),"Uspesno je sacuvana kategorija :"+category,System.currentTimeMillis());
	}
	
	
	@PutMapping(value = "/categories")
	public MessageResponse putCategory(@RequestBody Category category) {
		
		categoryService.saveCategory(category);
		
		 return new MessageResponse(HttpStatus.OK.value(),"Uspesno je izmenjena  kategorija :"+category,System.currentTimeMillis());
	}
	@DeleteMapping(value = "/categories/{id}")
	public MessageResponse deleteCategory(@PathVariable int id) {
		Category cat=categoryService.getByCategoryId(id);
				
		categoryService.deleteCategory(id);
		
		 return new MessageResponse(HttpStatus.OK.value(),"Uspesno je izbrisana  kategorija :"+cat,System.currentTimeMillis());
	}
	//----------------------------------------------------Sticker---------------------------------------------------------------

@GetMapping(value = "/stickers")
public List<Sticker> getStickers(){
	List<Sticker> list=stickerDAO.getStickerList();
	return list;
}
@GetMapping(value = "/stickers/{id}")
public Sticker getStickerById(@PathVariable int id){
	
		Sticker sticker=stickerDAO.getStickerbyId(id);
	if(sticker==null) {
		throw new CategoryException("Sticker sa id: "+id+" ne postoji u bazi podataka...");
		}
	return sticker;
}
@PostMapping(value = "/stickers")
public MessageResponse postSticker(@RequestBody Sticker sticker) {
	sticker.setId(0);
	stickerDAO.saveSticker(sticker);
	
	return new MessageResponse(HttpStatus.OK.value(),"Uspesno je sacuvan sticker :"+sticker,System.currentTimeMillis());
}

@PutMapping(value = "/stickers")
public MessageResponse putCategory(@RequestBody Sticker sticker) {
	
	stickerDAO.saveSticker(sticker);
	
	 return new MessageResponse(HttpStatus.OK.value(),"Uspesno je izmenjen  sticker :"+sticker,System.currentTimeMillis());
}

@DeleteMapping(value = "/stickers/{id}")
public MessageResponse deleteSticker(@PathVariable int id) {
	Sticker sti=stickerDAO.getStickerbyId(id);
			
	stickerDAO.deleteStickerById(id);
	
	 return new MessageResponse(HttpStatus.OK.value(),"Uspesno je izbrisan  sticker :"+sti,System.currentTimeMillis());
}
//--------------------------------------settings----------------------------------------------
@RequestMapping(value = "/settings")
public SettingsResponse getSettings() {
	
	SettingsResponse setings=new SettingsResponse();
	setings.setCategories(categoryService.getCategoryList());
	setings.setStickers(stickerDAO.getStickerList());
	
	return setings;
}

//---------------------------------PRODUCTS-----------------------------------------------------
@GetMapping(value = "/products")
public List<Product> getProducts(){
	
	List<Product> products=poduductDAO.getProductList();
	return products;
}


@GetMapping(value = "/basicproducts")
public List<BasicProductResponse> getBasicProducts(){
	
	List<BasicProductResponse> list=new ArrayList<>();
	List<Product> products=poduductDAO.getProductList();
	for(Product p:products) {
		list.add(new BasicProductResponse(p));
	}
	return list;
}
@PostMapping(value = "/products")
public MessageResponse saveProduct(@RequestBody Product product) {
	
	product.setId(0);
	poduductDAO.saveProduct(product);
	return new MessageResponse(HttpStatus.OK.value(),"Uspesno ste sacuvali product "+product,System.currentTimeMillis());
}
@PutMapping(value = "/products")
public MessageResponse updateProduct(@RequestBody Product product) {
	
	
	poduductDAO.saveProduct(product);
	return new MessageResponse(HttpStatus.OK.value(),"Uspesno ste izmenili product "+product,System.currentTimeMillis());
}
@DeleteMapping(value = "/product/{id}")
public MessageResponse updateProduct(@PathVariable int id) {
	Product p=poduductDAO.getByProductId(id);
	poduductDAO.deleteProduct(id);

	return new MessageResponse(HttpStatus.OK.value(),"Uspesno ste obrisali product "+p,System.currentTimeMillis());
}

@GetMapping(value = "/filter-products")
public List<Product> getProductListFilter(@RequestBody ProductFilter filter){
	List<Product> list=poduductDAO.getProductList(filter.getCategory(),filter.getPrice(),filter.getStickers());
	return list;
	
	
}
}