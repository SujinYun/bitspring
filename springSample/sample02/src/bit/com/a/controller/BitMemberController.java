package bit.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import bit.com.a.service.BitMemberService;

//@Component 생성(동작)만 하고 싶을 때 springframework이 자동적으로 생성해줌?

@Controller
public class BitMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);

	@Autowired // 서비스가 생성, 서비스에선 다오가 생성. 서로 연결해주는것
	private BitMemberService bitMemberService;
}
