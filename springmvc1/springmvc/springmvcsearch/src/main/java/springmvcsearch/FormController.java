package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@RequestMapping("/form")
	public String showForm()
	{
		return "formhandling";
	}
	
	@RequestMapping("/home1")
	public String showHome1()
	{
		return "home1";
	}
	
	@RequestMapping(path = "/welcome")
	public String welcome(@RequestParam("name")String name,Model m) {
		
		System.out.println(name);
		m.addAttribute("name", name);
		return "welcome";
	}
	
	@RequestMapping(path = "/handleform", method= RequestMethod.POST)
	public String formHandler(@ModelAttribute("student")Student student,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "formhandling";
		}
		System.out.println(student);
		System.out.println(student.getAddress());
		return "success";
	}
	
}
