package test.spring.dao;

import test.spring.bean.User;
/**
 * 用户管理底层数据访问接口
 * @author Administrator
 *
 */

public interface UserDao {
	//处理新增用户业务逻辑
	public void addUser(User user);
	//处理装载用户业务逻辑
	public User loadUser(int id);
	//处理修改用户业务逻辑
	public void modiUser(User user);
	//处理删除用户业务逻辑
	public void delUser(int id);
}
