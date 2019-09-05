package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.service.BitMemberService;

//@Component 생성(동작)만 하고 싶을 때 springframework이 자동적으로 생성해줌?

@Controller
public class BitMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);

	@Autowired // 서비스가 생성, 서비스에선 다오가 생성. 서로 연결해주는것
	private BitMemberService bitMemberService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {	// 파라미터와 이름이 달라도 되지만 되도록 맞추도록 한다.		
										// model : 데이터를 보내주기 위해서(짐싸기 위해서) 하나만 있으면 됨
		logger.info("BitMemberService login " + new Date());
		
//		model.addAttribute("name", "둘리");	// == request.setAttribute
		
		return "login";	// hello.jsp
		
	}
	
	@RequestMapping(value = "account.do", method = RequestMethod.GET)
	public String account() {
		
		logger.info("회원가입으로 이동");
		
		return "account";	//.jsp
		
	}
	
	@RequestMapping(value = "accountAf.do", method = RequestMethod.POST)
	public String accountAf(MemberDto dto, Model model, HttpServletRequest req)throws Exception { // model:짐싸는 용도 / req:세션에 접근하는 용도
		logger.info("BitMemberService accountAf " + new Date());
		logger.info(dto.toString());
		
		boolean b = bitMemberService.addmember(dto);
		if(b) {
			logger.info("회원가입성공" + new Date());
			return"login";
		}else {
			
			return "account";
		}
		
		
	}
	
}
