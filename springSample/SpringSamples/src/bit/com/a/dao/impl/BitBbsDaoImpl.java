package bit.com.a.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Repository
public class BitBbsDaoImpl implements BitBbsDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		return sqlSession.selectList(ns+"getBbsList", param);
	}

	// totalCount
	@Override
	public int getBbsCount(BbsParam param) {
		return sqlSession.selectOne(ns+"getBbsCount", param);
	}

	@Override
	public BbsDto getBbsDetail(int seq) {
		return sqlSession.selectOne(ns+"getBbsDetail", seq);
	}
	// 조회수
	@Override
	public boolean getCount(int seq) {
		int n = sqlSession.update(ns+"getCount", seq);
		return n>0?true:false;
	}


	@Override
	public boolean getBbsanswerInt(int seq) {
		int n = sqlSession.update(ns+"getBbsanswerInt", seq);
		return n>0?true:false;
	}

	@Override
	public boolean getBbsanswerDto(BbsDto bbs) {
		int n = sqlSession.insert(ns+"getBbsanswerDto", bbs);
		return n>0?true:false;
	}

	@Override
	public boolean getBbsWrite(BbsDto bbs) {
		int n = sqlSession.insert(ns+"getBbsWrite", bbs);
		return n>0?true:false;
	}

	// 삭제
	@Override
	public boolean getBbsdelete(int seq) {
		int n = sqlSession.update(ns+"getBbsdelete", seq);
		return n>0?true:false;
	}

	// 수정
	@Override
	public boolean getBbsupdateAf(BbsDto bbs) {
		int n = sqlSession.update(ns+"getBbsupdateAf", bbs);
		return n>0?true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
