package test.spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/** 创建一个RowMapper对象实现数据记录到User对象的映射 */
public class UserRowMapper implements RowMapper{
	//实现RowMapper接口的mapRow方法,完成从记录到User对象的映射
	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		return new User(rs.getInt("id"),rs.getString("userName"),rs.getString("userPwd"));
	}

}
