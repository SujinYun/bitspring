package bit.com.a.dao;

import java.util.List;
import java.util.Map;

import bit.com.a.model.BbsDto;

public interface BitBbsDao {
	
	// 모든 리스트
	public List<BbsDto> getBbsList(); 
	
	// 게시판 리스트 +페이징+검색
	public List<BbsDto> getBbsPagingList(BbsDto bbs); 
	
	// 글쓰기
	public boolean getBbsWrite(BbsDto bbs);
	
	// detail
	public BbsDto getBbsDetail(int seq);
	// 조회수
	public boolean getCount(int seq);
	
	// update
	public boolean getBbsupdateAf(BbsDto bbs);
	
	// 삭제
	public boolean getBbsdelete(int seq);
	
	// 검색
	public List<BbsDto> getBbsSearch(BbsDto bbs);
	
	// 답글
	public boolean getBbsanswerInt(int seq);
	public boolean getBbsanswerDto(BbsDto bbs);
	
	
}
