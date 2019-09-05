package bit.com.a;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.BbsDto;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BitBbsService;
import bit.com.a.service.BitMemberService;
import bit.com.a.service.impl.BitMemberServiceImpl;


@Controller
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired	// 서비스가 생성, 서비스에선 다오가 생성. 서로 연결해주는것
	private BitBbsService bitBbsService;

	@RequestMapping(value="bbslist.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String bbslist(MemberDto dto, Model model, HttpServletRequest req) throws Exception {
		logger.info("BbsController bbslist()"+new Date());
		
		List<BbsDto> bbslist = bitBbsService.bbslist();
		
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist";
		
	}
}
