package test.spring.action;

import javax.annotation.Resource;

import test.spring.bean.User;
import test.spring.service.UserService;

/**
 * �û�����ҵ�������
 * @author Administrator
 *
 */
public class UserAction {
	//��������ҵ���߼����õ����
	@Resource UserService userService;
	//���������û�����
	public void addUser(){
		String userName="liubin";
		String userPwd="123456";
		String email = "abc@aa.com";
		String phone = "13800138000";
		String address = "����������԰";
		userService.addUser(userName, userPwd, email, phone, address);
		//throw new RuntimeException("���������׳����쳣��Ϣ������");
	}
	//����ɾ���û�����
	public void delUser(){
		userService.delUser(1);
		
	}
	//����װ���û�����
	public void loadUser(){
		User user=userService.loadUser(1);
		if (user!=null) {
			System.out.println("�û���="+user.getUserName());
			System.out.println("��ϵ�绰="+user.getUserInfo().getPhone());
		}else{
			System.out.println("IDΪ1���û�������!");
		}
		
		
	}
	//�����޸��û�����
	public void modiUser(){
		int id = 1;
		String userName="liujunyu";
		String userPwd="123456";
		String email = "abc@qq.com";
		String phone = "13800138000";
		String address = "����������԰";		
		userService.modiUser(id, userName, userPwd, email, phone, address);
	}
	
	
}
