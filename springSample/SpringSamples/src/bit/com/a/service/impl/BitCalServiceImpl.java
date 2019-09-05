package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitCalDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.CalendarDto;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BitCalService;

@Service
public class BitCalServiceImpl implements BitCalService {
	
	@Autowired
	private BitCalDao CalDao;

	@Override
	public List<CalendarDto> getCal(MemberDto mem) {
		return CalDao.getCal(mem);
	}
	// 일정쓰기
	@Override
	public boolean getwriteAf(CalendarDto cal) {
		return CalDao.getwriteAf(cal);
	}

	// detail
	@Override
	public CalendarDto getdetail(int seq) {
		return CalDao.getdetail(seq);
	}
	
	// 수정
	@Override
	public boolean getupdateAf(CalendarDto calDto) {
		return CalDao.getupdateAf(calDto);
	}
	
	// 삭제
	@Override
	public boolean getdelete(int seq) {
		return CalDao.getdelete(seq);
	}
	
	

}
