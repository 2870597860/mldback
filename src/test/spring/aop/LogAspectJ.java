package test.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



/**
 * ��־����
 * @author Administrator
 *
 */
public class LogAspectJ {
	//ȡ����־��¼��Logger
	public Logger logger=Logger.getLogger(LogAspectJ.class);
	//�˷���������ǰ��֪ͨ
	public void doBefore(JoinPoint jp){
		String classAndMethod="������"+jp.getTarget().getClass().getName()
							+"��������"+jp.getSignature().getName();
		
		logger.info("ǰ��֪ͨ��"+classAndMethod+"���� ��ʼִ��");
	}
	//�˷�������������֪ͨ
	public void doAfter(JoinPoint jp){
		String classAndMethod="������"+jp.getTarget().getClass().getName()
							+"��������"+jp.getSignature().getName();
		
		logger.info("����֪ͨ��"+classAndMethod+"���� ִ�н�����");
	}
	
	//�˷�������������֪ͨ
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����֪ͨǰ������������");
		Object result=pjp.proceed();
		System.out.println("����֪ͨ�󣺣���������");
		String classAndMethod="������"+pjp.getTarget().getClass().getName()
								+"��������"+pjp.getSignature().getName();
			
		logger.info("����֪ͨ��"+classAndMethod+"���� ִ�н�����");
		return result;
	}	
	//�˷�������������֪ͨ
		public void  doAfterReturn(JoinPoint jp){		
			logger.info("����֪ͨ��");
		}
	//�˷����������쳣֪ͨ
	public void doAfterThrowing(JoinPoint jp,Exception ec){
		String classAndMethod="������"+jp.getTarget().getClass().getName()
								+"��������"+jp.getSignature().getName();
			
		logger.info("�쳣֪ͨ��"+classAndMethod+"���� �׳��쳣��"+ec.getMessage());
	}

	
}
