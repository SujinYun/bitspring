package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) {

		String res = "mybatis/config.xml";
		// mybatis패키지 안에있는 config.xml
		
		try {
			// mybatis 설정 파일을 읽음
			InputStream is = Resources.getResourceAsStream(res);
			
			// SqlSessionfactory 객체를 취득
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			// SqlSession 객체를 취득
			SqlSession session = factory.openSession();
			// 패키지 mybatis안에 config.xml파일의 설정을 읽고 SqlSessionfactory객체를 취득 후 sqlSession객체를 취득한다.
			
			/*
			// insert						id		pwd		email
//			MemberDto dto = new MemberDto("aaa", "111", "aaa111");
//			MemberDto dto = new MemberDto("bbb", "222", "bbbsss");
//			MemberDto dto = new MemberDto("ccc", "333", "ccc333");
			
			//						id   parameterType
			int n = session.insert("add", dto);
			if(n > 0) {
				session.commit();
				System.out.println("추가 성공");
			}else {
				session.rollback();
				System.out.println("추가 실패");
			}
			*/
			
			/*
			// remove			 
			String findId = "aaa";
			int n = session.delete("remove", findId);
			if(n > 0) {
				session.commit();
				System.out.println("삭제 성공");
			}else {
				session.rollback();
				System.out.println("삭제 실패");
			}
			*/
			
			// Object로 넘겨주는 방법
			
			/*
			// removeobj
			MemberDto dto = new MemberDto("ccc", null , "");
			int n = session.delete("removeobj", dto);
			if(n > 0) {
				session.commit();
				System.out.println("삭제 성공");
			}else {
				session.rollback();
				System.out.println("삭제 실패");
			}
			*/
			
			/*
			// update
			MemberDto dto = new MemberDto("good", "222", "");
			int n = session.update("update", dto);
			if(n > 0) {
				session.commit();
				System.out.println("업데이트 성공");
			}else {
				session.rollback();
				System.out.println("업데이트 실패");
			}
			*/
			
			/*
			//select
			String fId = "good";
			
			MemberDto dto = session.selectOne("find", fId);
			System.out.println(dto.toString());
			
			// select list
			List<MemberDto> list = session.selectList("alllist");
			
			for (MemberDto mem : list) {
				System.out.println(mem.toString());
			}
			*/
			// search
			BbsParam bp = new dto.BbsParam("1", "", "title");
			//											id		parameterType
			List<BbsDto> bbslist = session.selectList("search", bp);
			for (BbsDto bbs : bbslist) {
				System.out.println(bbs.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
