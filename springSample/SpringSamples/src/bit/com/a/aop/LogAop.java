package bit.com.a.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.model.MemberDto;

@Aspect
public class LogAop {
	// 웹소켓과 aop과 충돌 동작을 하지않는다. 같이 집어넣으면 안됨.
	@Around("within(bit.com.a.controller.*)")	// 계속 or를 붙여주면 됨.
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// request 취득
		// 세션 기한이 다 되었을 때 로그인 화면으로 이동시키기(자동 로그아웃)
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		if(request != null) {	// request접근 가능
			
			HttpSession session = request.getSession();
			
			MemberDto dto = (MemberDto)session.getAttribute("login");
			
			if(dto == null){	// 세션 기한이 다 되었을 때
				return "redirect:/login.do"; /*이동시켜줘야함*/
			}
			
		}else {
			System.out.println("request == null");
		}
		
		
		Object obj = joinpoint.proceed();
		stopWatch.stop();
		
		System.out.println("loggerAOP:" + signatureStr + "메소드가 실행되었습니다." + stopWatch.getTotalTimeMillis());
																		// 			메소드가 실행된 시간 출력
		
		return obj;
		
		
	}

}
