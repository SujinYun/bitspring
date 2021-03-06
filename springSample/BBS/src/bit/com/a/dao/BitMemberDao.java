package bit.com.a.dao;

import bit.com.a.model.MemberDto;

public interface BitMemberDao {

	// 회원가입
	public boolean addmember(bit.com.a.model.MemberDto mem)throws Exception;
	
	// 회원가입 id 중복체크
	public int idcheck(String id)throws Exception;
	
	// 로그인 id,pwd확인
	public int logincheck(bit.com.a.model.MemberDto mem)throws Exception;
}
