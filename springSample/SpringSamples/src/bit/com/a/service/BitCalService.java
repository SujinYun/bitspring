package bit.com.a.service;

import java.util.List;

import bit.com.a.model.CalendarDto;
import bit.com.a.model.MemberDto;

public interface BitCalService {
	
	// calendar
	public List<CalendarDto> getCal(MemberDto mem);
	
	// 글쓰기Af
	public boolean getwriteAf(CalendarDto cal);
	
	// detail
	public CalendarDto getdetail(int seq);
	
	// 수정
	public boolean getupdateAf(CalendarDto calDto);
	
	// 삭제
	public boolean getdelete(int seq);
	
}
