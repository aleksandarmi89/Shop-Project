package cubes.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cubes.main.dao.LocationDAO;
import cubes.main.dao.MessageDAO;
import cubes.main.dao.ProductDAO;
import cubes.main.dao.SliderDAO;
import cubes.main.dao.StaticPagesDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.entity.Category;
import cubes.main.entity.Location;
import cubes.main.entity.Message;
import cubes.main.entity.Product;
import cubes.main.entity.Slider;
import cubes.main.entity.Sticker;
import cubes.main.service.CategoryService;


@Controller
public class FrontController {
	@Autowired
private	MessageDAO messageDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private LocationDAO locationDAO;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private StaticPagesDAO staticPagesDAO;
	@Autowired
	private StickerDAO stickerDAO;
	
	
	

	
	
	
	@RequestMapping(value = "/shop-detail/{title}/{id}")
	public String getProductDetail(@PathVariable int id,@PathVariable String title, Model model) {
		Product p=productDAO.getByProductId(id);
		List<Product> products=productDAO.getProductList(p.getCategory().getId(), null, null);
		List<Location> location=locationDAO.getLocationList();
		model.addAttribute("locations", location);
		model.addAttribute("product", p);
		model.addAttribute("products", products);
		return "shop-detail";
	}
	
	
	
	//-----------ABAUT AS-----------------------
	@RequestMapping(value = "/about-us")
	public String  getAboutUsPage (Model model) {
		List<Location> location=locationDAO.getLocationList();
		model.addAttribute("locations", location);
		model.addAttribute("content", staticPagesDAO.getAboutUsPageContent());
		
		
		return "about-us";
	}

	
	//---------HOMEPAGE---------------------------
	@RequestMapping(value = {"/homepage","/"})
	public String  getHomePage (Model model) {
		List<Product> list=productDAO.getProductHomePage();
		List<Category> categories=categoryService.getCategoryHomepageList();
		List<Location> location=locationDAO.getLocationList();
		List<Slider> sliders=sliderDAO.getSlidersHomepageList();
		model.addAttribute("products", list);
		model.addAttribute("categories", categories);
		model.addAttribute("sliders", sliders);
		model.addAttribute("locations", location);
		return "homepage";
	}
	
	
	
	
	//----------CONTACT------------------------
	@RequestMapping(value = "/contact-form")
	public String  getContactPage (Model model) {
		List<Location> location=locationDAO.getLocationList();
		model.addAttribute("message", new Message());
		model.addAttribute("locations", location);
		return "contact-form";
	}
	@RequestMapping(value = "/contact-save")
	public String  getContactSavePage (@ModelAttribute Message message) {
		messageDAO.saveMessage(message);
		return "redirect:contact-form";
	}
	
	//-------SHOP LOCATION------------
	
	@RequestMapping(value = "/location")
  public String getLocationPage(Model model) {
		List<Location> list=locationDAO.getLocationList();
		model.addAttribute("locations", list);
	  
	  return "location";
  }//-------------------------------shop1---
	
	
	@RequestMapping(value = "/shop-list")
	public String  getShoplistPage1 (@RequestParam (required = false) Integer category,@RequestParam (required = false)Integer price,Model model
			,
			@RequestParam (required = false,value = "sticker")Integer[] stickerArray )
	{
		
		
		
		List<Category> categories=categoryService.getCategoryList();
		List<Location> location=locationDAO.getLocationList();
		List<Product> list=productDAO.getProductList(category, price,stickerArray);
		Category cat=categoryService.getByCategoryId(category);
		List<Sticker> stickers=stickerDAO.getStickerList();
		
		
		model.addAttribute("products", list);
		model.addAttribute("categories", categories);
	   
		model.addAttribute("locations", location);
		model.addAttribute("stickers", stickers);
		if(price!=null) {
		model.addAttribute("priceSelected", price);}
		if(cat!=null) {
		model.addAttribute("categorySelected",cat);}
	
	if(stickerArray!=null) {
			model.addAttribute("Array", Arrays.asList(stickerArray));
		}

		return "shop-list";
	}
	
@RequestMapping(value = "/shop-search")
public String getShopSearchPage(@RequestParam String text,Model model) {
	
	List<Product> products=productDAO.getProductList(text);
	List<Location> location=locationDAO.getLocationList();
	model.addAttribute("products", products);
	model.addAttribute("locations", location);
	System.out.println(text);
	return "shop-search";
}

@RequestMapping(value = "/shop-search-test")
public ModelAndView getShopSearchPageTest(@RequestParam String text) {
	ModelAndView mv=new ModelAndView();
	List<Product> products=productDAO.getProductList(text);
	
	mv.setViewName("shop-search");
	mv.addObject("products",products);
	return mv;

}
@RequestMapping(value = "/shop-search-text")
@ResponseBody
public String getShopSearchPageText(@RequestParam String text) {
	List<Product> products=productDAO.getProductList(text);
	return text;
}
}
