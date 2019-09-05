package bit.com.a.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;

@Repository
public class BitBbsDaoImpl implements BitBbsDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "Bbs.";
	
	
	// 모든 게시판 리스트
	@Override
	public List<BbsDto> getBbsList(){
		return sqlSession.selectList(ns + "getBbsList");
	}
	
	// 게시판 리스트 +페이징+검색
	@Override
	public List<BbsDto> getBbsPagingList(BbsDto bbs) {
		return sqlSession.selectList(ns + "getBbsPagingList");
	}

	
	// 글쓰기
	@Override
	public boolean getBbsWrite(BbsDto bbs) {
		int n = sqlSession.insert(ns+"getBbsWrite", bbs);
		return n>0?true:false;
	}

	// 디테일보기
	@Override
	public BbsDto getBbsDetail(int seq) {
		return sqlSession.selectOne(ns+"getBbsDetail", seq);
	}
	// 조회수
	@Override
	public boolean getCount(int seq) {
		int n = sqlSession.insert(ns+"getCount", seq);
		return n>0?true:false;
	}
	

	// 수정
	@Override
	public boolean getBbsupdateAf(BbsDto bbs) {
		int n = sqlSession.update(ns+"getBbsupdateAf", bbs);
		return n>0?true:false;
	}


	// 삭제
	@Override
	public boolean getBbsdelete(int seq) {
		int n = sqlSession.update(ns+"getBbsdelete", seq);
		return n>0?true:false;
	}

	// 검색
	@Override
	public List<BbsDto> getBbsSearch(BbsDto bbs) {
		return sqlSession.selectList(ns+"getBbsSearch", bbs);
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
	
	
	
	
	
	

	
}
