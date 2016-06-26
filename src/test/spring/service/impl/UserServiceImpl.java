package test.spring.service.impl;

import javax.annotation.Resource;

import test.spring.bean.User;
import test.spring.bean.UserInfo;
import test.spring.dao.UserDao;
import test.spring.service.UserService;

public class UserServiceImpl implements UserService{
	//ͨ��@Resourceע��ע�����ݷ������
	@Resource UserDao dao;
	//���������û�ҵ���߼�
	@Override
	public void addUser(String userName, String userPwd,String email,String phone,String address) {
		User user=new User();
		//��װ�˺���Ϣ
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		//��װ�û���������
		UserInfo userInfo=new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPhone(phone);
		userInfo.setAddress(address);
		user.setUserInfo(userInfo);
		dao.addUser(user);
		
	}
	//����װ���û�ҵ���߼�
	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return dao.loadUser(id);
	}
	//�����޸��û�ҵ���߼�
	@Override
	public void modiUser (int id, String userName, String userPwd,String email,String phone,String address) {
		User user=dao.loadUser(id);
		if(user!=null){
			user.setUserName(userName);
			user.setUserPwd(userPwd);
			//�E���û���������
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
	//����ɾ���û�ҵ���߼�
	@Override
	public void delUser(int id) {
		dao.delUser(id);
		
	}

	
}
