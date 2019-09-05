package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;

public class BitBbsServiceImpl implements bit.com.a.service.BitBbsService {
	
	@Autowired	// DI : springframework에 의존하는 것
	private BitBbsDao bitBbsDao;
	// == BitMemberDao bitMemberDao = new BitMemberDaoImpl();
	// 생성을 하려면 new를 붙여야 하지만 @Autowired를 붙이면 자동적으로 생성해준다. springframework이 알아서 넣어줌

	@Override
	public List<BbsDto> bbslist() throws Exception {
		return bitBbsDao.bbslist();
	}
	


}
