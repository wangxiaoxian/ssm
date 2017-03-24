package cn.springmvc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.springmvc.test.model.TestUser;

public class DBUtilsTest {

	private Connection conn = null;
	
	@Before
	public void initJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@10.1.4.61:1521:yx10g";    
		String user="wapwxcs";    
		String password="wapwxcs";    
		conn = DriverManager.getConnection(url, user, password);
	}
	
	@Test
	public void selectTest() throws SQLException {
		//This is a fairly generic implementation that can be reused across many projects. 
		//In recognition of this DbUtils provides a set of ResultSetHandler implementations in the org.apache.commons.dbutils.handlers package 
		//that perform common transformations into arrays, Maps, and JavaBeans. 
		ResultSetHandler<Object[]> h = new ResultSetHandler<Object[]>() {
		    public Object[] handle(ResultSet rs) throws SQLException {
		        if (!rs.next()) {
		            return null;
		        }
		    
		        ResultSetMetaData meta = rs.getMetaData();
		        int cols = meta.getColumnCount();
		        Object[] result = new Object[cols];

		        for (int i = 0; i < cols; i++) {
		            result[i] = rs.getObject(i + 1);
		        }

		        return result;
		    }

		};
		
		QueryRunner run = new QueryRunner();
		Object[] result = run.query(
	        conn, "SELECT * FROM test_user WHERE user_id=?", h, "007");
//	    Object[] result = run.query(
//	    		conn, "SELECT * FROM test_user", h);
	        // do something with the result
		System.out.println(result);
	}
	
	@Test
	public void selectTest2() throws SQLException {
		ResultSetHandler<TestUser> h2 = new BeanHandler<TestUser>(TestUser.class);
		ResultSetHandler<List<TestUser>> h3 = new BeanListHandler<TestUser>(TestUser.class);
		
		QueryRunner run = new QueryRunner();
		TestUser result2 = run.query(
	        conn, "SELECT * FROM test_user WHERE user_id=?", h2, "007");
		
		List<TestUser> result3 = run.query(
		        conn, "SELECT * FROM test_user WHERE user_id=?", h3, "007");
		System.out.println(result2);
		System.out.println(result3);
	}
	
	public void insertOrUpdateTest() throws SQLException {
		QueryRunner run = new QueryRunner();
	    // Execute the SQL update statement and return the number of
	    // inserts that were made
	    int inserts = run.update(conn, "INSERT INTO Person (name,height) VALUES (?,?)",
	                              "John Doe", 1.82 );
	    // The line before uses varargs and autoboxing to simplify the code

	    // Now it's time to rise to the occation...
	    int updates = run.update(conn, "UPDATE Person SET height=? WHERE name=?",
	                              2.05, "John Doe" );
	    // So does the line above
	}
	
	@After
	public void clearConnection() throws SQLException {
		// Use this helper method so we don't have to check for null
		DbUtils.close(conn);
	}
}
