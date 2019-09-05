package bit.com.a.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
DROP TABLE BBS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_BBS;

CREATE TABLE BBS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(50) NOT NULL,
	
	REF NUMBER(8) NOT NULL,
	STEP NUMBER(8) NOT NULL,
	DEPTH NUMBER(8) NOT NULL,
	
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WDATE DATE NOT NULL,
	PARENT NUMBER(8) NOT NULL,
	
	DEL NUMBER(1) NOT NULL,
	READCOUNT NUMBER(8) NOT NULL
);

CREATE SEQUENCE SEQ_BBS
START WITH 1
INCREMENT BY 1;

ALTER TABLE BBS
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
*/
@Getter
@Setter
@ToString
public class BbsDto implements Serializable {

	private int seq;
	private String id;	// 작성자
	
	private int ref;	// 그룹번호
	private int step;	// 행(row)번호
	private int depth;	// 깊이
	
	private String title;
	private String content;
	private String wdate;
	private int parent;	// 부모글 번호	// 지우기
	
	private int del;
	private int readcount;
	
	public BbsDto() {}

	public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate,
			int parent, int del, int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.parent = parent;
		this.del = del;
		this.readcount = readcount;
	}

	
	
	
	
}




