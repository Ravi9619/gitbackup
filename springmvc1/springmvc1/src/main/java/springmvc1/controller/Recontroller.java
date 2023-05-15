package springmvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Recontroller {
	
	@RequestMapping("/one")
	public RedirectView one() {
		
		System.out.println("this is one handler");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("two");
		return redirectView;
	}
	
	
	@RequestMapping("/two")
	public String two() {
		
		System.out.println("this is second handler");
		return "contact";
	}
}
