package com.aopex;

import org.aspectj.lang.ProceedingJoinPoint;

// 감시자
public class logAOP {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		// 포인터 안에 값이 변하면 잡아낸다.
		// cat이라는 클래스 안에 어떤 함수가 호출이 되면 loggerAop가 잡아내서 처리한다.
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		System.out.println(signatureStr + "시작"); // 특정 함수가 호출이 되기 전
		
		try {
			Object obj = joinpoint.proceed();	// 특정 함수가 실행(기능실행)
			return obj;
		}finally {
			System.out.println("실행 후:" + System.currentTimeMillis());			
			
			System.out.println(signatureStr + "종료");	// 호출 후
		}
	}

}
