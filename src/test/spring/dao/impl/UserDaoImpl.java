package test.spring.dao.impl;

import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import test.spring.bean.User;
import test.spring.bean.UserInfo;
import test.spring.bean.UserInfoRowMapper;
import test.spring.bean.UserRowMapper;
import test.spring.dao.UserDao;
/**
 *  用户管理底层数据访问接口实现 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	//通过@Resource注解注入Spring提供的JdbcTemplate实例
	@Resource JdbcTemplate jdbcTemplate;
	
	//处理新增用户业务逻辑
	@Override
	public void addUser(User user){
		jdbcTemplate.update("insert into users(userName,userPwd) value(?,?)",
					new Object[]{user.getUserName(),user.getUserPwd()},
					new int[]{Types.VARCHAR,Types.VARCHAR});
		
		int userid=jdbcTemplate.queryForObject("select id from users where userName=? and userPwd=?",
				new Object[]{user.getUserName(),user.getUserPwd()},
				new int[]{Types.VARCHAR,Types.VARCHAR}, Integer.class);
		UserInfo userInfo=user.getUserInfo();
		if (userInfo!=null) {
			jdbcTemplate.update("insert into userinfo(UserID,Email,Phone,Address) value(?,?,?,?)",
					new Object[]{userid,userInfo.getEmail(),userInfo.getPhone(),userInfo.getAddress()},
					new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
		}
	}
	@Override
	//处理装载用户业务逻辑
	public User loadUser(int id){
		try{
		//装载用户账号信息
		User user =(User) jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id},new int[]{Types.INTEGER},new UserRowMapper());
		if (user!=null) {
			//装载用户个人资料
			UserInfo userInfo=(UserInfo)jdbcTemplate.queryForObject("select * from userinfo where UserID=?", new Object[]{id},new int[]{Types.INTEGER},new UserInfoRowMapper());
			user.setUserInfo(userInfo);
		}
		return user;
		}catch (Exception e) {
			return null;
		}
		
		
	}
	@Override
	public void modiUser(User user) {
		//修改用户账号信息
		jdbcTemplate.update("update users set userName=?,userPwd=? where id=?",new Object[]{user.getUserName(),user.getUserPwd(),user.getId()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		UserInfo userInfo=user.getUserInfo();
		if (userInfo!=null) {
			//修改用户个人资料
			jdbcTemplate.update("update userinfo set Email=?,Phone=?,Address=? where UserID=?",new Object[]{userInfo.getEmail(),userInfo.getPhone(),userInfo.getAddress(),user.getId()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		}		
		System.out.println("ID号为"+user.getId()+"修改成功");
	}
	@Override
	public void delUser(int id) {
	//删除用户账号信息
	jdbcTemplate.update("delete from users where id=?", new Object[]{id},new int[]{Types.INTEGER});
	//删除用户个人资料
	jdbcTemplate.update("delete from userinfo where UserID=?", new Object[]{id},new int[]{Types.INTEGER});
	System.out.println("ID号为"+id+"的用户删除成功!");
	}
}
