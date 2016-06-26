package test.spring.action;

import javax.annotation.Resource;

import test.spring.bean.User;
import test.spring.service.UserService;

/**
 * 用户管理业务控制器
 * @author Administrator
 *
 */
public class UserAction {
	//仅仅声明业务逻辑引用的组件
	@Resource UserService userService;
	//处理新增用户请求
	public void addUser(){
		String userName="liubin";
		String userPwd="123456";
		String email = "abc@aa.com";
		String phone = "13800138000";
		String address = "广州天河软件园";
		userService.addUser(userName, userPwd, email, phone, address);
		//throw new RuntimeException("这是特意抛出的异常信息！！！");
	}
	//处理删除用户请求
	public void delUser(){
		userService.delUser(1);
		
	}
	//处理装载用户请求
	public void loadUser(){
		User user=userService.loadUser(1);
		if (user!=null) {
			System.out.println("用户名="+user.getUserName());
			System.out.println("联系电话="+user.getUserInfo().getPhone());
		}else{
			System.out.println("ID为1的用户不存在!");
		}
		
		
	}
	//处理修改用户请求
	public void modiUser(){
		int id = 1;
		String userName="liujunyu";
		String userPwd="123456";
		String email = "abc@qq.com";
		String phone = "13800138000";
		String address = "广州天河软件园";		
		userService.modiUser(id, userName, userPwd, email, phone, address);
	}
	
	
}
