package bit.com.a.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class Lombok {
	
	private int seq;
	private String name;
	private String id;
	private String pwd;
	
	public Lombok() {
	}

	@Builder
	public Lombok(int seq, String name, String id, String pwd) {
		super();
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}
	
	

}
