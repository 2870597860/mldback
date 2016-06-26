package test.spring.junit;



import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.action.UserAction;
import test.spring.aop.LogAspectJ;

/**
 * 用户管理业务控制器的测试用例
 * @author Administrator
 *
 */
public class testUserAction {
	private static ApplicationContext cxt;
	private static UserAction userAction;
	//初始化ApplicationContext容器
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		//使用ClassPathXmlApplicationContext方式初始化ApplicationContext容器
		cxt=new ClassPathXmlApplicationContext("beans.xml");
		//从bean工厂容器中获取名为“userAction”的UserAction
		userAction=(UserAction)cxt.getBean("userAction");
		
	
	}

	//测试UserAction的AddUser
	@Test
	public void testAddUser(){
		userAction.addUser();
		
	}
	//测试UserAction的DelUser
		@Test
		public void testDelUser(){
			userAction.delUser();
			
		}
		//测试UserAction的LoadUser
		@Test
		public void testLoadUser(){
			userAction.loadUser();
			
		}
		//测试UserAction的MOdiUser
		@Test
		public void testMOdiUser(){
			userAction.modiUser();
			
		}
}
