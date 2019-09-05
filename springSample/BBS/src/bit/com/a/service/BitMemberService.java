package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.model.MemberDto;

public interface BitMemberService {

	// 회원가입
	public boolean addmember(MemberDto mem) throws Exception;
	
	// 회원가입 id 중복체크
	public int idcheck(String id) throws Exception;
	
	// 로그인 id,pwd확인
	public int logincheck(MemberDto mem) throws Exception;


}
