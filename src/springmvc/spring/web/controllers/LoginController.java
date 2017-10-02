package springmvc.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.spring.web.dao.User;
import springmvc.spring.web.service.UsersService;

@Controller
public class LoginController {
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	private UsersService usersService;
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}

	@RequestMapping("/newaccount")
	public String showNewAccout(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}
	@RequestMapping("/admin")
	public String showAdminPanel(Model model) {
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}


	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String doCreate(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount";
		}
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "This user already exists!");
			return "newaccount";
		}
		try {
		usersService.create(user);
		} catch (DuplicateKeyException e) {
			usersService.create(user);	
			result.rejectValue("username", "DuplicateKey.user.username", "This user already exists");
			return "newaccount";
		}
	
		return "accountcreated";
	}

}
