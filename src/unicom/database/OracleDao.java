package unicom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class OracleDao extends BillingDao {
	public void conn() {
		//Connection conn = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@192.168.100.3:1521:ylrx";
		String username = "tongji";
		String password = "tongji";
		Properties prop = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException cnfex) {

			System.err.println("装载 JDBC/ODBC 驱动程序失败。");
			cnfex.printStackTrace();
			System.exit(1);
		} catch (SQLException sqlex) {
			System.err.println("无法连接数据库");
			sqlex.printStackTrace();
			System.exit(1);
		}
		//this.conn=
		//return conn;
	}

}
