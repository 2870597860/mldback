package test.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



/**
 * 日志切面
 * @author Administrator
 *
 */
public class LogAspectJ {
	//取得日志记录器Logger
	public Logger logger=Logger.getLogger(LogAspectJ.class);
	//此方法将用作前置通知
	public void doBefore(JoinPoint jp){
		String classAndMethod="类名："+jp.getTarget().getClass().getName()
							+"方法名："+jp.getSignature().getName();
		
		logger.info("前置通知："+classAndMethod+"方法 开始执行");
	}
	//此方法将用作后置通知
	public void doAfter(JoinPoint jp){
		String classAndMethod="类名："+jp.getTarget().getClass().getName()
							+"方法名："+jp.getSignature().getName();
		
		logger.info("后置通知："+classAndMethod+"方法 执行结束！");
	}
	
	//此方法将用作环绕通知
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕通知前：：：：：：");
		Object result=pjp.proceed();
		System.out.println("环绕通知后：：：：：：");
		String classAndMethod="类名："+pjp.getTarget().getClass().getName()
								+"方法名："+pjp.getSignature().getName();
			
		logger.info("环绕通知："+classAndMethod+"方法 执行结束！");
		return result;
	}	
	//此方法将用作返回通知
		public void  doAfterReturn(JoinPoint jp){		
			logger.info("返回通知：");
		}
	//此方法将用作异常通知
	public void doAfterThrowing(JoinPoint jp,Exception ec){
		String classAndMethod="类名："+jp.getTarget().getClass().getName()
								+"方法名："+jp.getSignature().getName();
			
		logger.info("异常通知："+classAndMethod+"方法 抛出异常！"+ec.getMessage());
	}

	
}
