package compete;
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
			   //编写SQl语句
			   sql = "SELECT id, name, url FROM websites";
			   //查询记录
			   ResultSet rs = stmt.executeQuery(sql);
			   
			   // 展开结果集数据库
	            while(rs.next()){
	                // 通过字段检索
	                int id  = rs.getInt("id");
	                String name = rs.getString("name");
	                String url = rs.getString("url");
	    
	                // 输出数据
	                System.out.print("ID: " + id);
	                System.out.print(", 站点名称: " + name);
	                System.out.print(", 站点 URL: " + url);
	                System.out.print("\n");
	            }
	            // 完成后关闭
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
