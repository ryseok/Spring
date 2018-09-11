package com.encore.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

	//MsgServiceImpl클래스의 메소드 호출전 실행할 코드
	/*@Before("execution(* com.encore.service.MsgService*.*(..))")
	public void startLog(JoinPoint jp) {
       System.out.println("----------------------------------");
       System.out.println(Arrays.toString(jp.getArgs()));
	}*/
	
	@Around ("execution(* com.encore.service.MsgService*.*(..))") //실행할 메소드 매핑
	public Object timeLog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("---------------<전처리>-------------------");
		long start = System.currentTimeMillis();

		Object result = jp.proceed(); //실제 메소드 호출
		
		System.out.println("---------------<후처리>-------------------");
		long end = System.currentTimeMillis();
		System.out.println(jp.getSignature().getName() 
				+"메소드 실행시간: "+(end-start));
	   return result;
	}
	
}