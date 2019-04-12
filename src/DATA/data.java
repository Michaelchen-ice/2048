package DATA;
import java.sql.*;
public class data {
	//JDBC驱动名   数据库URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	 
	//用户名及密码
	 static final String USER = "root";
	 static final String PASS = "98991217q";
	 
	 public static void main(String args[]) {
		   Connection conn = null;
		   Statement stmt = null;
		   try {
			   //注册JDBC驱动
			   Class.forName("com.mysql.jdbc.Driver");
			   System.out.println("连接数据库");
			   //打开链接
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   
			   System.out.println("实例化Statement对象...");
			   //实例化图库操作对象
			   stmt = conn.createStatement();
			   String sql;
			   //增加数据
//			   sql = "INSERT INTO data(data_user,data_password)VALUES('miaomiaomiao','wangwangwang');";
//			   stmt.executeUpdate(sql);
//			   sql = "SELECT 'data_id' FROM `data` where 'data_user' =' michaelwxq';";
			   //查询记录
			  sql = "SELECT * from data;";
			   ResultSet rs = stmt.executeQuery(sql);
			   // 展开结果集数据库
//			   
//			   int id = rs.getInt("data_id");
//			   System.out.println(id);
			   
	            while(rs.next()){
	                // 通过字段检索
	                int id  = rs.getInt("data_id");
	                String user = rs.getString("data_user");
	                String password = rs.getString("data_password");
	    
	                // 输出数据
	                System.out.print("ID: " + id);
	                System.out.print(", 用户名: " + user);
	                System.out.print(", 密码: " + password);
	                System.out.print("\n");
	            }
//	             完成后关闭
	            rs.close();
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Goodbye!");
	    }
	}
