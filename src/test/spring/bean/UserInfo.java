package test.spring.bean;
/**
 * �����û�����
 * @author Administrator
 *
 */
public class UserInfo {
	private int id;//��ȻID��
	private int userId;//�û�ID�˺�
	private String email;
	private String phone;
	private String address;
	public UserInfo() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
