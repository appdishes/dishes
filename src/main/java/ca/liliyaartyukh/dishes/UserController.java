package ca.liliyaartyukh.dishes;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8090", "https://appdishes.github.io/", "https://appdishes.herokuapp.com/"}, maxAge = 3600)
//@RestController
public class UserController {

	
	
	  @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	  
	  @RequestMapping("/register")
	  public Principal register(Principal user) {
	    return user;
	  }
	  
	  @RequestMapping("/login")
	  public Principal login(Principal user) {
	    return user;
	  }
	  
}
