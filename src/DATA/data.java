package DATA;
import java.sql.*;
public class data {
	//JDBC������   ���ݿ�URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	 
	//�û���������
	 static final String USER = "root";
	 static final String PASS = "98991217q";
	 
	 public static void main(String args[]) {
		   Connection conn = null;
		   Statement stmt = null;
		   try {
			   //ע��JDBC����
			   Class.forName("com.mysql.jdbc.Driver");
			   System.out.println("�������ݿ�");
			   //������
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   
			   System.out.println("ʵ����Statement����...");
			   //ʵ����ͼ���������
			   stmt = conn.createStatement();
			   String sql;
			   //��������
//			   sql = "INSERT INTO data(data_user,data_password)VALUES('miaomiaomiao','wangwangwang');";
//			   stmt.executeUpdate(sql);
//			   sql = "SELECT 'data_id' FROM `data` where 'data_user' =' michaelwxq';";
			   //��ѯ��¼
			  sql = "SELECT * from data;";
			   ResultSet rs = stmt.executeQuery(sql);
			   // չ����������ݿ�
//			   
//			   int id = rs.getInt("data_id");
//			   System.out.println(id);
			   
	            while(rs.next()){
	                // ͨ���ֶμ���
	                int id  = rs.getInt("data_id");
	                String user = rs.getString("data_user");
	                String password = rs.getString("data_password");
	    
	                // �������
	                System.out.print("ID: " + id);
	                System.out.print(", �û���: " + user);
	                System.out.print(", ����: " + password);
	                System.out.print("\n");
	            }
//	             ��ɺ�ر�
	            rs.close();
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            // ���� JDBC ����
	            se.printStackTrace();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }finally{
	            // �ر���Դ
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// ʲô������
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Goodbye!");
	    }
	}
