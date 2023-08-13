package blog.main;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

 

@Controller
public class AuthenticateController {

	
	@RequestMapping(value="/login")
	public String getLoginPage(Model model) 
	{
		 
		return "login";
	}
}
