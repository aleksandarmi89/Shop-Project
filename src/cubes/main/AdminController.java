package cubes.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cubes.main.dao.CategoryDAO;
import cubes.main.dao.LocationDAO;
import cubes.main.dao.MessageDAO;
import cubes.main.dao.ProductDAO;
import cubes.main.dao.SliderDAO;
import cubes.main.dao.StaticPagesDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.dao.UserDAO;
import cubes.main.entity.Category;
import cubes.main.entity.ChangePassword;
import cubes.main.entity.Location;
import cubes.main.entity.Message;
import cubes.main.entity.Product;
import cubes.main.entity.Role;
import cubes.main.entity.Slider;
import cubes.main.entity.StaticPage;
import cubes.main.entity.Sticker;
import cubes.main.entity.User;
import cubes.main.service.CategoryService;
@RequestMapping(value = "/admin")
@Controller
public class AdminController {
	
	//------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/")
	public String getDashBoardPage( Model model) {
		long unreadMessagesCount =messageDAO.getUnreadMessagesCount();
		model.addAttribute("unreadMessagesCount", unreadMessagesCount);
	//	model.addAttribute("user", userDAO.getUser(username));
		return "dashboard";
	}
	
	
	
	
	//------------------------------------------------------------------------------------------------------
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private StickerDAO stickerDAO;
	@Autowired
	private CategoryService categoryService;
	@Autowired
    private MessageDAO messageDAO;
	@Autowired
	private LocationDAO locationDAO;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private StaticPagesDAO staticPagesDAO;
	@Autowired
	private UserDAO userDAO;
	
	@ModelAttribute("loginUser")
	public User getLoginUser(Principal p) {
		User user=userDAO.getUser(p.getName());
				return user;
	}
	@RequestMapping(value = "/category-list")
	public String getCategoryList(Model model) {
		
		List<Category> list=categoryService.getCategoryList();
		model.addAttribute("categories", list);
		
		System.out.println(list.toString());
		
		// int broj = categoryService.getCount(5);
		// System.out.println("ima pr: " + broj);
		return "category-list";
	}
	@RequestMapping(value = "/category-form")
public String getCategoryForm(Model model) {
	model.addAttribute("category", new Category());
	return "category-form";
}
	
	@RequestMapping(value = "/category-save")
	public String getCategorySave(@ModelAttribute Category category) {
	categoryService.saveCategory(category);
	return "redirect:category-list";
}

@RequestMapping( value = "/category-update")
public String getCategoryUpdate(@RequestParam int id,Model model) {
	Category category=categoryService.getByCategoryId(id);
	model.addAttribute("category", category);
	
	return "category-form";
}
@RequestMapping(value = "/category-delete")
public String getCategoryDelete(@RequestParam int id,Model model) {
	Category category =categoryService.getByCategoryId(id);
	categoryService.deleteCategory(id);

	
model.addAttribute("category", category);
	return"redirect:category-list";
}

//-----------------------------------Sticker------------------------------------------
@RequestMapping(value = "/sticker-list")
public String getStickerList(Model model) {
	List<Sticker> list=stickerDAO.getStickerList();
	model.addAttribute("stickers", list);
	System.out.println(list.toString());
	return "sticker-list";
}
@RequestMapping(value = "/sticker-form")
public String getStickerForm(Model model) {
	model.addAttribute("sticker", new Sticker());
	
	return "sticker-form";
}
@RequestMapping(value = "/sticker-save")
public String getStickerSave(@ModelAttribute Sticker sticker){
	stickerDAO.saveSticker(sticker);
	return "redirect:sticker-list";
}
@RequestMapping(value = "/sticker-update")
public String getStickerUpdate(@RequestParam int id,Model model) {
	Sticker sticker =stickerDAO.getStickerbyId(id);
	model.addAttribute("sticker", sticker);
	return"sticker-form";
}

@RequestMapping(value = "/sticker-delete")
public String getStickerDelete(@RequestParam int id,Model model) {
	Sticker sticker =stickerDAO.getStickerbyId(id);
	stickerDAO.deleteStickerById(id);

	
model.addAttribute("sticker", sticker);
	return"redirect:sticker-list";
}
//-------------------------------------------------------------------------------------------


@RequestMapping(value = "/product-list")
public String getProductList(Model model) {
	List<Product> list=productDAO.getProductList();
	Product p=new Product();
	model.addAttribute("products", list);
	model.addAttribute("product", p);
	
	System.out.println(list.toString());
	return "product-list";
}
@RequestMapping(value = "/product-form")
public String getProductForm(Model model) {
	List<Sticker> stickers=stickerDAO.getStickerList();
List<Category>categories=categoryService.getCategoryList();
	model.addAttribute("product", new Product());
	model.addAttribute("stickers", stickers);
	model.addAttribute("categories", categories);
	return "product-form";
}
@RequestMapping(value = "/product-save")
public String getProductSave(@ModelAttribute Product product){
	Category category=categoryService.getByCategoryId(product.getCategory().getId());
	List<Sticker>stickers=new ArrayList<Sticker>();
	for(Sticker sticker:product.getStickers()) {
		Sticker tempSticker=stickerDAO.getStickerbyId(sticker.getId());
		stickers.add(tempSticker);
	}
	product.setStickers(stickers);
	product.setCategory(category);
	productDAO.saveProduct(product);
	
	return "redirect:product-list";
}
@RequestMapping(value = "/product-update")
public String getProductUpdate(@RequestParam int id,Model model) {
	List<Category> categories=categoryService.getCategoryList();
	List<Sticker> stickers=stickerDAO.getStickerList();
	Product product =productDAO.getByProductId(id);
	
	
	model.addAttribute("product", product);
	model.addAttribute("stickers", stickers);
	model.addAttribute("categories", categories);
	return"product-form";
}

@RequestMapping(value = "/product-delete")
public String getProductDelete(@RequestParam int id,Model model) {
	Product product =productDAO.getByProductId(id);
	productDAO.deleteProduct(id);

	
model.addAttribute("product", product);
	return"redirect:product-list";
}
@RequestMapping(value = "/product-detail")
public String getProductDetail(@RequestParam int id, Model model) {
	Product p=productDAO.getByProductId(id);
	
	
	model.addAttribute("product", p);
	
	return "product-detail";
}
//--------------------------------------------------------------------------
@RequestMapping(value = "/message-list")
public String getMessageList( Model model) {
	
	List<Message> list=messageDAO.getAllMessage();
	model.addAttribute("messages", list);
	
	return "message-list";
}
@RequestMapping(value = "/message-seen")
public String getMessageSeenPage(@RequestParam int id) {
	Message message=messageDAO.getMessageById(id);
	message.setIsSeen(true);
	messageDAO.saveMessage(message);
	return "redirect:message-list";
}



//--------------------------location -----------------
@RequestMapping(value = "/location-list")
public String getLocationList( Model model) {
	
	List<Location> list=locationDAO.getLocationList();
	model.addAttribute("locations", list);
	
	return "location-list";

}

@RequestMapping(value = "/location-form")
public String getLocationForm(Model model) {
	model.addAttribute("location", new Location());
	return "location-form";}



@RequestMapping(value = "/location-save")
public String getLocationForm( @ModelAttribute Location location) {
	locationDAO.saveLocation(location);
	return "redirect:location-list";}

@RequestMapping(value = "/location-update")
public String getLocationUpdate( @RequestParam int id,Model model) {
	
	Location l=locationDAO.getByLocationId(id);
	
	model.addAttribute("location", l);
	return "location-form";}
@RequestMapping(value = "/location-delete")
public String getLocationDelete( @RequestParam int id) {
	
     locationDAO.deleteLocation(id);
	
	
	return "redirect:location-list";}



//----------------------Slider--------------------------


@RequestMapping(value = "/slider-list")
public String getSliderList( Model model) {
	
	List<Slider> list=sliderDAO.getSliderList();
	model.addAttribute("sliders", list);
	
	return "slider-list";}

@RequestMapping(value = "/slider-form")
public String getSliderForm( Model model) {
	
	
	model.addAttribute("slider", new Slider());
	
	return "slider-form";}


@RequestMapping(value = "/slider-save")
public String getSliderSave( @ModelAttribute Slider slider) {
	
	
	sliderDAO.saveSlider(slider);
	
	return "redirect:slider-list";}


@RequestMapping(value = "/slider-update")
public String getSliderUpdate( @RequestParam int id,Model model) {
	
	Slider s=sliderDAO.getSliderbyId(id);
	
	model.addAttribute("slider", s);
	return "slider-form";}

@RequestMapping(value = "/slider-delete")
public String getSliderDelete( @RequestParam int id) {
	
	sliderDAO.deleteSliderById(id);
	

	return "redirect:slider-list";}
//-----------------------------STaticPAGES------------------------------------------------
    @RequestMapping(value = "/static-page-form")
   public String getStaticPage(@RequestParam String page,Model model) {
    	
    	if(page.equalsIgnoreCase("about")) {
    		model.addAttribute("staticPage", staticPagesDAO.getStaticPage(1));
    	}
    	else if(page.equalsIgnoreCase("location")) {
    		model.addAttribute("staticPage", staticPagesDAO.getStaticPage(2));
    	}
    	return "static-page-form";
    }
  @RequestMapping(value = "/static-page-save")
    public String getStaticPageSave(@ModelAttribute StaticPage staticPage) {
	  
	  staticPagesDAO.saveStaticPage(staticPage);
	  return "static-page-form";
  }
  
  //-------------------------------------users pages----------------------------------------------
  
  @RequestMapping(value = "/user-list")
  public String getUserListPage(Principal principal,Model model) {
	  
	  model.addAttribute("users", userDAO.getAllUsers());
	  
	  
	  return "user-list";
  }
  
  
  @RequestMapping(value = "/user-enabled")
  public String getUserEnabled(@RequestParam String username) {
	  User user=userDAO.getUser(username);
	user.setEnabled(!user.getEnabled());
	userDAO.saveUser(user);
	  return "redirect:user-list";
  }
  
  
  @RequestMapping(value = "/user-delete")
  public String getUserDelete(@RequestParam String username) {
	
	  userDAO.deleteUser(username);
	
	
	  return "redirect:user-list";
  }
  
  @RequestMapping(value = "/user-form")
  public String getUserForm(Model model ) {
	
	 model.addAttribute("user", new User());
	model.addAttribute("userRoles", userDAO.getUserRoles());
	
	  return "user-form";
  }
  
  
  @RequestMapping(value = "/user-save")
  public String getUserSave(@ModelAttribute User user,Principal principal,Model model ) 
  
  {
	User tempUser=userDAO.getUser(principal.getName());
   user.setEnabled(true);
	 user.generateBCPassword();
	 userDAO.saveUser(user);
	 if(tempUser.getRoles().get(0).getAuthority().contains("admin"))
	
	 { 
		 return "redirect:user-list";}
	 
  return getDashBoardPage(model);
  }
 
  
  @RequestMapping(value = "/user-update")
  public String getUserUpdate( @RequestParam String username,Principal principal,Model model) {
  	User u=userDAO.getUser(username);
  	User l=userDAO.getUser(principal.getName());
  	model.addAttribute("user1", l);
  	model.addAttribute("user", u);
  	model.addAttribute("userRoles", userDAO.getUserRoles());
  	model.addAttribute("isAdmin", true);
  	return "user-form-update";}
  
  @RequestMapping(value = "/user-myupdate")
  public String getUserMyUpdate(Principal principal,Model model) {
		User u =userDAO.getUser(principal.getName());
		User l=userDAO.getUser(principal.getName());
	
  	model.addAttribute("user", u);
  	model.addAttribute("user1", l);
  	return "user-form-update";
 	
 
		
		
 	
  	}
  
 
  
  
  
  
  @RequestMapping(value = "/user-change-password")
  public String getChangePassword(Principal principal,Model model) {
  	model.addAttribute("changePassword", new ChangePassword());
	model.addAttribute("user", userDAO.getUser(principal.getName()));
	
  	return "user-form-change-password";}
  
  @RequestMapping(value = "/user-save-change-password")
  public String getChangePasswordSave(@ModelAttribute ChangePassword changePassword,Principal principal,Model model) {
	  User user=userDAO.getUser(principal.getName());
	  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	  if(!changePassword.getNewPassword().equalsIgnoreCase(changePassword.getConfirmPassword())) {
		  //ako password nije isti
		  model.addAttribute("message", "Nova lozinka i potvrda nove lozinke se ne poklapaju.");
		  model.addAttribute("changePassword", changePassword);
	
	  }
	  else if(!encoder.matches(changePassword.getOldPassword(), user.getEncodedPassword())) {
		  //ako stari password ne odgovara korisniku
		  model.addAttribute("message", "Stara lozinka nije odgovarajuca.");
		  model.addAttribute("changePassword", changePassword);
		 
	  }
	  
	  else {
		  user.setPassword(changePassword.getNewPassword());
		  user.generateBCPassword();
		  userDAO.saveUser(user);
		  model.addAttribute("message", "Uspesno ste promenili password.");
		  model.addAttribute("changePassword", new ChangePassword());
		  model.addAttribute("alert", true);
	  }
	  
	  return "user-form-change-password";
  }
  
  
}







