package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitMemberDao;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BitMemberService;

@Service
public class BitMemberServiceImpl implements BitMemberService {
	
	@Autowired	// DI : springframework에 의존하는 것
	private BitMemberDao bitMemberDao;
	// == BitMemberDao bitMemberDao = new BitMemberDaoImpl();
	// 생성을 하려면 new를 붙여야 하지만 @Autowired를 붙이면 자동적으로 생성해준다. springframework이 알아서 넣어줌
	
	@Override
	public boolean addmember(MemberDto mem) throws Exception {
		return bitMemberDao.addmember(mem);
	}
	

}
