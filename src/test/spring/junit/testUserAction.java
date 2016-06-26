package test.spring.junit;



import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.action.UserAction;
import test.spring.aop.LogAspectJ;

/**
 * �û�����ҵ��������Ĳ�������
 * @author Administrator
 *
 */
public class testUserAction {
	private static ApplicationContext cxt;
	private static UserAction userAction;
	//��ʼ��ApplicationContext����
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		//ʹ��ClassPathXmlApplicationContext��ʽ��ʼ��ApplicationContext����
		cxt=new ClassPathXmlApplicationContext("beans.xml");
		//��bean���������л�ȡ��Ϊ��userAction����UserAction
		userAction=(UserAction)cxt.getBean("userAction");
		
	
	}

	//����UserAction��AddUser
	@Test
	public void testAddUser(){
		userAction.addUser();
		
	}
	//����UserAction��DelUser
		@Test
		public void testDelUser(){
			userAction.delUser();
			
		}
		//����UserAction��LoadUser
		@Test
		public void testLoadUser(){
			userAction.loadUser();
			
		}
		//����UserAction��MOdiUser
		@Test
		public void testMOdiUser(){
			userAction.modiUser();
			
		}
}
