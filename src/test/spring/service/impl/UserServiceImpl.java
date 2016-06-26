package test.spring.service.impl;

import javax.annotation.Resource;

import test.spring.bean.User;
import test.spring.bean.UserInfo;
import test.spring.dao.UserDao;
import test.spring.service.UserService;

public class UserServiceImpl implements UserService{
	//通过@Resource注解注入数据访问组件
	@Resource UserDao dao;
	//处理新增用户业务逻辑
	@Override
	public void addUser(String userName, String userPwd,String email,String phone,String address) {
		User user=new User();
		//封装账号信息
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		//封装用户个人资料
		UserInfo userInfo=new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPhone(phone);
		userInfo.setAddress(address);
		user.setUserInfo(userInfo);
		dao.addUser(user);
		
	}
	//处理装载用户业务逻辑
	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return dao.loadUser(id);
	}
	//处理修改用户业务逻辑
	@Override
	public void modiUser (int id, String userName, String userPwd,String email,String phone,String address) {
		User user=dao.loadUser(id);
		if(user!=null){
			user.setUserName(userName);
			user.setUserPwd(userPwd);
			//鞥新用户个人资料
			UserInfo userInfo=user.getUserInfo();
			if (userInfo!=null) {
				userInfo.setEmail(email);
				userInfo.setPhone(phone);
				userInfo.setAddress(address);
			}
			user.setUserInfo(userInfo);
			dao.modiUser(user);
		}
		
		dao.modiUser(user);
	}
	//处理删除用户业务逻辑
	@Override
	public void delUser(int id) {
		dao.delUser(id);
		
	}

	
}
