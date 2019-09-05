package bit.com.a.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BbsParam implements Serializable{
	
	// search
	private String s_category;
	private String s_keyword;
	
	// paging
	private int pageNumber = 0 ;		// 현재 페이지
	private int recordCountPerPage = 10;	// 페이지당 글 수 
	
	// [1] -> 1~10 (db에서불러오는 번호와느 ㄴ다름 +1)
	// DB용 변수
	private int start = 1;
	private int end = 10;
	
	public BbsParam() {}

	public BbsParam(String s_category, String s_keyword, int pageNumber, int recordCountPerPage, int start, int end) {
		super();
		this.s_category = s_category;
		this.s_keyword = s_keyword;
		this.pageNumber = pageNumber;
		this.recordCountPerPage = recordCountPerPage;
		this.start = start;
		this.end = end;
	}
	
	

}
