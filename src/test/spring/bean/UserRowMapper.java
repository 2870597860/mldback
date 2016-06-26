package test.spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/** ����һ��RowMapper����ʵ�����ݼ�¼��User�����ӳ�� */
public class UserRowMapper implements RowMapper{
	//ʵ��RowMapper�ӿڵ�mapRow����,��ɴӼ�¼��User�����ӳ��
	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		return new User(rs.getInt("id"),rs.getString("userName"),rs.getString("userPwd"));
	}

}
