package test.spring.service;

import test.spring.bean.User;

	public interface UserService {
	//���������û�ҵ���߼�
	public void addUser(String userName,String userPwd,String email,String phone,String address);
	//����װ���û�ҵ���߼�
	public User loadUser(int id);
	//�����޸��û�ҵ���߼�
	public void modiUser(int id,String userName,String userPwd,String email,String phone,String address);
	//����ɾ���û�ҵ���߼�
	public void delUser(int id);
}
