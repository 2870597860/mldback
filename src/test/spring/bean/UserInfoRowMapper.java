package test.spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/** ����һ��RowMapper����ʵ�����ݼ�¼��UserInfo�����ӳ�� */
public class UserInfoRowMapper implements RowMapper{
	//ʵ��RowMapper�ӿڵ�mapRow����,��ɴӼ�¼��UserInfo�����ӳ��
	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		UserInfo userInfo=new UserInfo();
		userInfo.setId(rs.getInt("id"));
		userInfo.setUserId(rs.getInt("UserId"));
		userInfo.setEmail(rs.getString("Email"));
		userInfo.setPhone(rs.getString("Phone"));
		userInfo.setAddress(rs.getString("Address"));
		return userInfo;
	}

}
