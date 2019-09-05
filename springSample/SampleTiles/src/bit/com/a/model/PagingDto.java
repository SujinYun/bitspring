package bit.com.a.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingDto implements Serializable {

	// 검색 
	private String choice;
	private String text;
	
	// 페이징
	private int start;
	private int end;
	private int page;
	
	
	public PagingDto() {}
	
	

	public PagingDto(String choice, String text, int start, int end, int page) {
		super();
		this.choice = choice;
		this.text = text;
		this.start = start;
		this.end = end;
		this.page = page;
	}
	
	
	
	
	
	
}
