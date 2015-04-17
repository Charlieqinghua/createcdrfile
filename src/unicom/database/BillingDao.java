package unicom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import unicom.tools.DicTion;
/*
 * 
 * 之所以要使用下面这条语句，是因为要使用MySQL的驱动，
 * 所以我们要把它驱动起来，可以通过Class.forName把它加载进去，
 * 也可以通过初始化来驱动起来，下面三种形式都可以
 * Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
 * */
public class BillingDao {	
	Connection conn = null;	 
    String url =DicTion.url;
    String username = DicTion.username;
    String password=DicTion.password;
    String classname=DicTion.classname;
	public void conn()
	{
		int result=0;
        try 
        {
            Class.forName(classname);
            System.out.println("success driver");
            conn = DriverManager.getConnection(url,username,password);
         }
        catch(Exception e)
        {
        	e.printStackTrace();        	
        }
        finally
        {
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
	}
	public void delete(String sql)
	{
		   //
           PreparedStatement pps = null;
		try {
			pps = conn.prepareStatement(sql);
			boolean re=pps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
	        {
	        	try {
	        		pps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}
	

	public  void  insertBillingBean(BillingBean []beanlist,String sql)
	{
		
		int beansize = beanlist.length;
		int tt[];
		PreparedStatement pst = null;
		try {
				pst = conn.prepareStatement(sql);
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BillingBean bean = null;
			for (int i = 0; i < beansize; i++) {
				bean = beanlist[i];
				try {
					if(bean!=null)
					{
						//System.out.println(bean.getTimePre().toString());
						if(pst!=null)
						{
							pst.setString(1, bean.getTimePre().toString());
							pst.setString(2, bean.getType().toString());
							pst.setLong(3, Long.parseLong(bean.getCallmobile().toString()));
							pst.setLong(4,Long.parseLong(bean.getCalledmobile().toString()));
							pst.setString(5, bean.getTimein().toString());
							pst.setString(6, bean.getTimeout().toString());
							pst.setInt(7, Integer.parseInt(bean.getCi().toString()));
							pst.setInt(8, Integer.parseInt(bean.getLac().toString()));
							pst.setString(9, bean.getImei().toString());
							pst.setString(10, bean.getImsi().toString());
							pst.addBatch();
						}
						else{
							System.out.println("pst ===null");
						}
					}
	
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			}
			try {
				
				tt = pst.executeBatch();
				//System.out.println("update : " + tt.length);
				conn.commit();
				conn.setAutoCommit(true);
				//pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(conn);
			}

		
		
     
	}
	
     
	
	public void query()
	{
		 String query="select * from tb2";
         PreparedStatement pps = null;
		try {
			pps = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         ResultSet rs = null;
		try {
			rs = pps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			while(rs.next())
			 {
			 	System.out.println(rs.getString(1)+" "+rs.getString(2));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	public void freeConn(){
		//cpm.freeConnection(conn);
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
