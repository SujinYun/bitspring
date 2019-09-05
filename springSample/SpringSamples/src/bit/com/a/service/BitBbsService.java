package bit.com.a.service;

import java.util.List;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

public interface BitBbsService {
	
	// 모든 리스트
	public List<BbsDto> getBbsList(BbsParam param); 
	
	// totalCount
	public int getBbsCount(BbsParam param);
	
	// 디테일
	public BbsDto getBbsDetail(int seq);
	// 조회수
	public boolean getCount(int seq);
	
	
	// 답글
	public boolean getBbsanswerInt(int seq);
	public boolean getBbsanswerDto(BbsDto bbs);

	// 글쓰기
	public boolean getBbsWrite(BbsDto bbs);
	
	// 삭제 
	public boolean getBbsdelete(int seq);
	
	// 수정 Af
	public boolean getBbsupdateAf(BbsDto bbs);
	
}
