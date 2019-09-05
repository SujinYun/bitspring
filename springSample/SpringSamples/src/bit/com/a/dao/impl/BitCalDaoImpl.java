package bit.com.a.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitCalDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.CalendarDto;
import bit.com.a.model.MemberDto;

@Repository
public class BitCalDaoImpl implements BitCalDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String cal = "Cal.";

	@Override
	public List<CalendarDto> getCal(MemberDto mem) {
		return sqlSession.selectList(cal+"getCal", mem);
	}

	// 글쓰기
	@Override
	public boolean getwriteAf(CalendarDto caldto) {
		int n = sqlSession.insert(cal+"getwriteAf", caldto);
		return n>0?true:false;
	}

	// 디테일
	@Override
	public CalendarDto getdetail(int seq) {
		return sqlSession.selectOne(cal+"getdetail", seq);
	}

	// 수정
	@Override
	public boolean getupdateAf(CalendarDto calDto) {
		int n = sqlSession.update(cal+"getupdateAf", calDto);
		return n>0?true:false;
	}

	// 삭제
	@Override
	public boolean getdelete(int seq) {
		int n = sqlSession.delete(cal+"getdelete", seq);
		return n>0?true:false;
	}
	
	



}
