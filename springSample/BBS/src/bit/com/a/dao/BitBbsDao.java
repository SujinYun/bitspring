package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.BbsDto;

public interface BitBbsDao {
	
	public List<BbsDto> bbslist() throws Exception;

}