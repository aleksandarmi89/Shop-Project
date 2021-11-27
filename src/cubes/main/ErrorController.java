package cubes.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	
	
	
	@RequestMapping(value = "/errors")
	public String getErrorPage(HttpServletRequest request,Model model) {
		int statusCode=getErrorCode(request);
		model.addAttribute("statusCode", statusCode);
		switch (statusCode) {
		case 400:
			model.addAttribute("errorMessage", "Uneli ste pogresnu adresu");
			break;
		case 404:
			model.addAttribute("errorMessage", "Uneli ste pogresnu adresu");
			break;
		case 500:
			model.addAttribute("errorMessage", "Uneli ste pogresnu adresu");
			break;
		}
		return "error-page";
	}
	private int getErrorCode(HttpServletRequest httprequest) {
		return(Integer) httprequest.getAttribute("javax.servlet.error.status_code");
	}
}
