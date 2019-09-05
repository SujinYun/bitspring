package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	@RequestMapping("/login")
	public ModelAndView home() {
		
//		System.out.println("HomeController home()");
		logger.info("HomeController home " + new Date());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/login");	// home.jsp
		
		return view;
	}
	*/
	
	/*
	 * @RequestMapping(value="login.do", method=RequestMethod.GET) public String
	 * hello(Model model) { // 파라미터와 이름이 달라도 되지만 되도록 맞추도록 한다. // model : 데이터를 보내주기
	 * 위해서(짐싸기 위해서) 하나만 있으면 됨 logger.info("HomeController hello " + new Date());
	 * 
	 * model.addAttribute("name", "둘리"); // == request.setAttribute
	 * 
	 * return "login"; // hello.jsp
	 * 
	 * }
	 * 
	 */
}
