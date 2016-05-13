package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Test
{
	@org.junit.Test
	public void test() throws Exception
	{
		String driver = "com.mysql.jdbc.Driver" ; 
		String url = "jdbc:mysql://localhost/test" ; 
		String userName = "root" ; 
		String password = "root" ; 
		Class.forName(driver).newInstance() ; 
		Connection connection = DriverManager.getConnection(url, userName, password) ; 
		String sql = "select * from test1 where age = 23 and name = '凉了时光乱了心'" ; 
		PreparedStatement preparedStatement = connection.prepareStatement(sql) ; 
		Date date = new Date() ; 
		ResultSet resultSet = preparedStatement.executeQuery() ; 
		while(resultSet.next())
		{
			resultSet.getString(1) ; 
		}
		Date date1 = new Date() ; 
		System.out.println(date1.getTime() - date.getTime());
	}
}
