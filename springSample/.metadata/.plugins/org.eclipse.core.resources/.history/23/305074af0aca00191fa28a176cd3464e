package bit.com.a.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.service.BitBbsService;

@Service
public class BitBbsServiceImpl implements BitBbsService {

	@Autowired
	BitBbsDao bbsDao;
	
	
	@Override
	public List<BbsDto> getBbsList() {		
		return bbsDao.getBbsList();
	}

	@Override
	public List<BbsDto> getBbsPagingList(BbsDto bbs) {		
		return bbsDao.getBbsPagingList(bbs);
	}

	@Override
	public boolean getBbsWrite(BbsDto bbs) {
		return bbsDao.getBbsWrite(bbs);
	}

	@Override
	public BbsDto getBbsDetail(int seq) {
		return bbsDao.getBbsDetail(seq);
	}
	// 조회수
	@Override
	public boolean getCount(int seq) {
		return bbsDao.getCount(seq);
	}
	

	//수정
	@Override
	public boolean getBbsupdateAf(BbsDto bbs) {
		return bbsDao.getBbsupdateAf(bbs);
	}


	// 삭제
	@Override
	public boolean getBbsdelete(int seq) {
		return bbsDao.getBbsdelete(seq);
	}

	@Override
	public List<BbsDto> getBbsSearch(BbsDto bbs) {
		return bbsDao.getBbsSearch(bbs);
	}

	@Override
	public boolean getBbsanswerInt(int seq) {
		return bbsDao.getBbsanswerInt(seq);
	}

	@Override
	public boolean getBbsanswerDto(BbsDto bbs) {
		return bbsDao.getBbsanswerDto(bbs);
	}
	
	
	
	
	
	
	
}
