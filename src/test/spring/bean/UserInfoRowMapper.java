package test.spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/** 创建一个RowMapper对象实现数据记录到UserInfo对象的映射 */
public class UserInfoRowMapper implements RowMapper{
	//实现RowMapper接口的mapRow方法,完成从记录到UserInfo对象的映射
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
