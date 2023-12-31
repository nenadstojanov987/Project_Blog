package blog.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletRequest response, HttpSession session) {
         
        session.invalidate();
 
        return "redirect:/login";
    }
}
