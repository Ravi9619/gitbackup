package springmvc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc1.model.User;
import springmvc1.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model model) {
		model.addAttribute("Header", "Learn with Ravi");
		model.addAttribute("Desc", "Pro at Learning");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model model) {
		
		return "contact";
	}
	
	@RequestMapping(path = "/processform",method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user,Model model) {
		
		System.out.println(user);
		if(user.getUserName().isBlank()) {
			return "redirect:/contact";
		}
		int createdUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with id "+createdUser);
		return "success";
	}
	
	
	
//	@RequestMapping(path = "/processform",method = RequestMethod.POST)
//	public String handleForm(@RequestParam("userEmail")String email,
//							@RequestParam("userName")String name,
//							@RequestParam("userPassword")String password,Model model) {
//		
//		User user = new User();
//		user.setUserName(name);
//		user.setUserEmail(email);
//		user.setUserPassword(password);
//		
//		model.addAttribute(user);
////		model.addAttribute("email", email);
////		model.addAttribute("name", name);
////		model.addAttribute("password", password);
//		
//		return "success";
//	}
}
