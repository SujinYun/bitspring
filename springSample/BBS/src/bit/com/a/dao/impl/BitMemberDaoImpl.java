package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitMemberDao;
import bit.com.a.model.MemberDto;

@Repository		// db와 대화하는 곳
public class BitMemberDaoImpl implements BitMemberDao {

	@Autowired
	SqlSession sqlSession;
	
	String namespace = "Member.";	// member를 통해서 db에 접근하기위한 작업?

	@Override
	public boolean addmember(MemberDto mem) throws Exception {
		int n = sqlSession.insert(namespace + "addmember", mem);
		return n>0?true:false;
	}

	@Override
	public int idcheck(String id) throws Exception {
		int n = sqlSession.selectOne(namespace + "idcheck", id);
		return n;
	}

	@Override
	public int logincheck(MemberDto mem) throws Exception {
		int n = sqlSession.selectOne(namespace + "logincheck", mem);
		return n;
	}



	
	
	
	
	
}
