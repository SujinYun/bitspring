package bit.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping
	public ModelAndView bitcamp() {
		
		System.out.println("HomeController bitcamp()");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/home");	// == home.jsp
		
		return view;
		
	}

}
