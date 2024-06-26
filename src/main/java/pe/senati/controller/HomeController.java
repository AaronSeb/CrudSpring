package pe.senati.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
	}
	
	@GetMapping({"/","/home"})
	public String home_GET() {
		return "home";
	}
	//dirección url: http://localhost:8090/senati/home

	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) 
	{	
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null)
			new SecurityContextLogoutHandler().logout(request,response,auth);
		return "redirect:login?logout";
	}
	
	@GetMapping("/access_denied")
	public String access_denied_GET() {
		
		return "error";
	}
	
	@GetMapping("/login")
	public String login_GET() {
		return "login";
	}
	
	
	
	
}
