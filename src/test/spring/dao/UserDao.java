package test.spring.dao;

import test.spring.bean.User;
/**
 * �û�����ײ����ݷ��ʽӿ�
 * @author Administrator
 *
 */

public interface UserDao {
	//���������û�ҵ���߼�
	public void addUser(User user);
	//����װ���û�ҵ���߼�
	public User loadUser(int id);
	//�����޸��û�ҵ���߼�
	public void modiUser(User user);
	//����ɾ���û�ҵ���߼�
	public void delUser(int id);
}
