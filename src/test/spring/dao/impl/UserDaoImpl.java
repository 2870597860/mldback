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
 *  �û�����ײ����ݷ��ʽӿ�ʵ�� 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	//ͨ��@Resourceע��ע��Spring�ṩ��JdbcTemplateʵ��
	@Resource JdbcTemplate jdbcTemplate;
	
	//���������û�ҵ���߼�
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
	//����װ���û�ҵ���߼�
	public User loadUser(int id){
		try{
		//װ���û��˺���Ϣ
		User user =(User) jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id},new int[]{Types.INTEGER},new UserRowMapper());
		if (user!=null) {
			//װ���û���������
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
		//�޸��û��˺���Ϣ
		jdbcTemplate.update("update users set userName=?,userPwd=? where id=?",new Object[]{user.getUserName(),user.getUserPwd(),user.getId()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		UserInfo userInfo=user.getUserInfo();
		if (userInfo!=null) {
			//�޸��û���������
			jdbcTemplate.update("update userinfo set Email=?,Phone=?,Address=? where UserID=?",new Object[]{userInfo.getEmail(),userInfo.getPhone(),userInfo.getAddress(),user.getId()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		}		
		System.out.println("ID��Ϊ"+user.getId()+"�޸ĳɹ�");
	}
	@Override
	public void delUser(int id) {
	//ɾ���û��˺���Ϣ
	jdbcTemplate.update("delete from users where id=?", new Object[]{id},new int[]{Types.INTEGER});
	//ɾ���û���������
	jdbcTemplate.update("delete from userinfo where UserID=?", new Object[]{id},new int[]{Types.INTEGER});
	System.out.println("ID��Ϊ"+id+"���û�ɾ���ɹ�!");
	}
}
