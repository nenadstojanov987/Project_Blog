package blog.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class ErrorController {

	@RequestMapping(value="/errors")
	public String getErrorPage(Model model, HttpServletRequest request) 
	{
		int errorCode = getErrorCode(request); 
		switch(errorCode) 
		{
			case 400: model.addAttribute("errorNumber", 400);
					  model.addAttribute("error_message", "Bad request");
			break;
			
			case 401: model.addAttribute("errorNumber", 401);
			  model.addAttribute("error_message", "Unauthorized");
			break;
			
			case 403: model.addAttribute("errorNumber", 403);
			  model.addAttribute("error_message", "Forbidden");
			break;
			
			case 404: model.addAttribute("errorNumber", 404);
			  model.addAttribute("error_message", "Page not found");
			break;
			
			case 500: model.addAttribute("errorNumber", 500);
			  model.addAttribute("error_message", "Internal Server Error");
			break;
			case 501: model.addAttribute("errorNumber", 501);
			  model.addAttribute("error_message", "Not Implemented");
			break;
			case 502: model.addAttribute("errorNumber", 502);
			  model.addAttribute("error_message", "Bad Gateway");
			break;
			case 503: model.addAttribute("errorNumber", 503);
			  model.addAttribute("error_message", "Service Unavailable");
			break;
			
			
		
		}
		
		return "error-page";
		
	}
	
	
	private int getErrorCode(HttpServletRequest httpRequest) 
	{
		int errorNumber = (Integer)httpRequest.getAttribute("javax.servlet.error.status_code");
		return errorNumber;
		
	}
}
