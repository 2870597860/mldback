package test.spring.service;

import test.spring.bean.User;

	public interface UserService {
	//处理新增用户业务逻辑
	public void addUser(String userName,String userPwd,String email,String phone,String address);
	//处理装载用户业务逻辑
	public User loadUser(int id);
	//处理修改用户业务逻辑
	public void modiUser(int id,String userName,String userPwd,String email,String phone,String address);
	//处理删除用户业务逻辑
	public void delUser(int id);
}
