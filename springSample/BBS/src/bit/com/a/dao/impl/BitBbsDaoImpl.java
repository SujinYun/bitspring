package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.dao.BitBbsDao;
import bit.com.a.model.BbsDto;

public class BitBbsDaoImpl implements BitBbsDao {
	
	@Autowired
	SqlSession sqlSession;

	String namespace = "Bbs.";

	@Override
	public List<BbsDto> bbslist() throws Exception {
		List<BbsDto> bbslist = sqlSession.selectList(namespace + "bbslist");
		return bbslist;
	}
	
	
	
}
