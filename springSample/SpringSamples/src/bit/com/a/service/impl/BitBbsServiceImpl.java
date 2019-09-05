package bit.com.a.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.service.BitBbsService;

@Service
public class BitBbsServiceImpl implements BitBbsService {

	@Autowired
	BitBbsDao bbsDao;

	// 모든 게시판 리스트
	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		return bbsDao.getBbsList(param);
	}

	// totalCount
	@Override
	public int getBbsCount(BbsParam param) {
		return bbsDao.getBbsCount(param);
	}

	// 디테일
	@Override
	public BbsDto getBbsDetail(int seq) {
		return bbsDao.getBbsDetail(seq);
	}

	// 조회수
	@Override
	public boolean getCount(int seq) {
		return bbsDao.getCount(seq);
	}

	// 답글
	@Override
	public boolean getBbsanswerInt(int seq) {
		return bbsDao.getBbsanswerInt(seq);
	}

	@Override
	public boolean getBbsanswerDto(BbsDto bbs) {
		return bbsDao.getBbsanswerDto(bbs);
	}
	// 글쓰기
	@Override
	public boolean getBbsWrite(BbsDto bbs) {
		return bbsDao.getBbsWrite(bbs);
	}


	// 삭제
	@Override
	public boolean getBbsdelete(int seq) {
		return bbsDao.getBbsdelete(seq);
	}
	
	@Override
	public boolean getBbsupdateAf(BbsDto bbs) {
		// TODO Auto-generated method stub
		return bbsDao.getBbsupdateAf(bbs);
	}
	
	
	


	
	
	
	
	
	
	
}
