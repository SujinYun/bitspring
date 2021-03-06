package bit.com.a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MyClass;
import bit.com.a.model.MyData;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="hello.do", method=RequestMethod.GET)
	public String hello(Model model) {	// session에 접근할 때 request를 쓴다.
		logger.info("HelloController hello()");
		
		MyClass cls = new MyClass();
		cls.setNumber(1001);
		cls.setName("뽀로로");
		
		model.addAttribute("mycls", cls);

		return "hello";	// .jsp
	}
	
	/* 2 */										// get, post 둘다 받아들임
	@RequestMapping(value = "inputData.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String inputData(Model model, MyClass mycls) {	// model : 데이터를 가지고 가는 용도(날려주는), MyClass형태로 받는다.
		logger.info("HelloController inputData()" + new Date());
		
		logger.info(mycls.toString());
		
		model.addAttribute("mycls", mycls);
		
		return "hello";
	}
	
	/* 3 */
	@RequestMapping(value = "move.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String move() {
		logger.info("HelloController move()" + new Date());
		
		//return "redirect:/hello.do";	// controller에서 controller로 이동
		return "forward:/hello.do";	// 짐을 싸고 이동할 떈.(값을 가지고 감) 대부분 redirect를 많이 씀
	}
	
	/* 4 */
	@ResponseBody	// ajax사용 할 땐 꼭 있어야함?
	@RequestMapping(value = "idcheck.do", 
					produces="application/String; charset=utf-8",	// encoding방식을 맞춰줌(String일 경우에만) 한글이 깨지지 않음
					method= {RequestMethod.GET, RequestMethod.POST})
	public String idcheck(String id) {
		logger.info("HelloController idcheck()" + new Date());
		logger.info("id" + id);
		
		String str = "오케이";
		
		return str;
		//  ajax는 데이터를 가지고오는 용도이기 때문에 String형을 return값으로 넣어준다.
	}
	
	/* 5 */
	@ResponseBody
	@RequestMapping(value = "account.do", method= {RequestMethod.POST})
	public Map<String, Object> account(MyData my) {
		logger.info("HelloController account()" + new Date());
		logger.info(my.toString());	
		////////////////////////// 넘어온 데이터 확인
		
		// DB접근
		
		// 넘길 데이터 준비
		Map<String, Object> rmap  = new HashMap<String, Object>();
		rmap.put("msg", "메시지 입니다.");
		rmap.put("data", "뽀로로");
		return rmap; 	// jsp가 아닌 넘겨줄 데이터임
		
	}
	
	/* 6 */
	@ResponseBody
	@RequestMapping(value = "updateUser.do", method= {RequestMethod.POST})
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> map) {	// map으로 받을 땐 requestBody를 해줘야함?
		logger.info("HelloController updateUser()" + new Date());
		
		logger.info(map.get("name") + "");
		logger.info(map.get("tel") + "");
		logger.info(map.get("email") + "");
		logger.info(map.get("birth") + "");
		
		Map<String, Object> rmap  = new HashMap<String, Object>();
		rmap.put("msg", "데이터 입니다.");
		rmap.put("data", "크롱");
		
		return rmap;

	}	
}
















