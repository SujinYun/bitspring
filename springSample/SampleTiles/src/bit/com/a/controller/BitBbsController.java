package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.BbsDto;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BitBbsService;

@Controller
public class BitBbsController {

	private static final Logger logger = LoggerFactory.getLogger(BitBbsController.class);
	
	@Autowired
	BitBbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(BbsDto bbsdto, Model model) {		
		logger.info("BitBbsController bbslist " + new Date());
		
		// 모든 bbslist
		List<BbsDto> bbs = bbsService.getBbsList();
		// 전체 리스트의 갯수
		int listsize = bbs.size();
        
        // 리스트 뿌리기
        List<BbsDto> bbslist = bbsService.getBbsPagingList(bbsdto);
        model.addAttribute("bbslist", bbslist);
        model.addAttribute("listsize", listsize);

		return "bbslist.tiles";
		
	}
	
	// 글쓰기
	@RequestMapping(value = "bbswrite.do", method=RequestMethod.GET)
	public String bbswrite(MemberDto mem, Model model) {		
		logger.info("BitBbsController bbswrite " + new Date());

		return "bbswrite.tiles";
	}

	@RequestMapping(value = "bbswriteAf.do", method=RequestMethod.GET)
	public String bbswrite(BbsDto dto, Model model) {		
		logger.info("BitBbsController bbswriteAf " + new Date());
		logger.info(dto.toString());
		/// 넘어온 데이터 확인 ///
		
		boolean b = bbsService.getBbsWrite(dto);
		if(b) {
			logger.info("글쓰기 성공");
			logger.info(dto.toString());
			return "redirect:/bbslist.do";			
		}
		else {
			logger.info("글쓰기 실패");
			logger.info(dto.toString());
			return "redirect:/bbswrite.do";	
		}
	}
	
	// detail
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsdetail! "+ new Date());
		
		bbsService.getCount(seq);
		BbsDto bbs=bbsService.getBbsDetail(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsdetail.tiles";
	}
	
	// update
	@RequestMapping(value = "bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsupdate! "+ new Date());
		
		BbsDto bbs=bbsService.getBbsDetail(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsupdate.tiles";
	}
	
	
	// 수정
	@RequestMapping(value = "bbsupdateAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdateAf(BbsDto bbs, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsupdateAf! "+ new Date());
		logger.info("seq: " + bbs.getSeq());
		logger.info("title: " + bbs.getTitle());
		logger.info("content: " + bbs.getContent());
		
		boolean b = bbsService.getBbsupdateAf(bbs);
		
		if(b) {
			logger.info("수정완료");
			model.addAttribute("seq", bbs.getSeq());
			return "redirect:/bbsdetail.do";
		}
		else {
			logger.info("수정실패");
			return "redirect:/bbslist.do";
		}
	}
	
	// 삭제
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdateAf(int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsdelete! "+ new Date());
		logger.info("seq: " + seq);
		
		boolean b = bbsService.getBbsdelete(seq);
		
		if(b) {
			logger.info("삭제완료");
			return "redirect:/bbslist.do";
		}
		else {
			logger.info("삭제실패");
			model.addAttribute("seq", seq);
			return "redirect:/bbsdetail.do";
		}
	}
	
	// 댓글
	@RequestMapping(value = "bbsanswer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsanswer(int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsanswer! "+ new Date());
		logger.info("seq: " + seq);
		
		model.addAttribute("seq", seq);
		
		return "bbsanswer.tiles";

	}
	
	// 댓글
	@RequestMapping(value = "bbsanswerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsanswerAf(BbsDto bbs, int seq, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsanswerAf! "+ new Date());
		logger.info("seq: " + seq);
		
		boolean b1 = bbsService.getBbsanswerInt(seq);	// step, depth 변경
		boolean b2 = bbsService.getBbsanswerDto(bbs);	// 게시글 등록
		
		logger.info("등록완료");
		
		return "redirect:/bbslist.do";
		
	}
	
	/*
	// 검색
	@RequestMapping(value = "bbsearch.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsearch(BbsDto bbs, Model model) throws Exception {
		logger.info("Welcome BitBbsController bbsearch! "+ new Date());
		
		List<BbsDto> bbslist = bbsService.getBbsSearch(bbs);
		
		model.addAttribute("bbslist", bbslist);
		return "bbslist";
	}
	*/

}












