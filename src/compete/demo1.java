package compete;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import java.util.HashMap;

	public class demo1 extends JFrame {
//		创建	
	    static JPanel panel1 = new JPanel();
		static JLabel label1 = new JLabel("用户：");
		static JLabel label2 = new JLabel("密码：");
		static JTextField textfield1 = new JTextField("");
		static JTextField textfield2 = new JTextField("");
		static JButton button1 = new JButton("登录");
		static JButton button2 = new JButton("注册");
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
		static demo1 frame1 = new demo1();
		 
		//用户名及密码
		
		
//		字体
		static Font font1 = new Font("SansSerif",Font.BOLD,25);
		static Font font2 = new Font("SansSerif",Font.BOLD,20);
	    
	    public demo1() {
	    	button1 = new JButton("登录");
	        button2 = new JButton("注册");
	        button2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // 打开另一个窗口
	                new www();
	            }
	        });
	        this.add(button2);
	        button1.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
					 final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
					 final String USER = "root";
					 final String PASS = "98991217q";
					 String User;
					 String PassWord;
					 int flag1 = 0;
					 int flag2 = 0;
					 int flag3 = 0;
					 User = textfield1.getText().toString();
					 PassWord = textfield2.getText().toString();
					 
					 while(true) {
					 if(User == null ||User.isEmpty()||PassWord == null||PassWord.isEmpty()) {
						 JOptionPane.showMessageDialog(null, "未输入用户名或密码", "提示", 0);
						 break;
					 }
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
						   sql = " SELECT data_user FROM `data` ;";
						   ResultSet rs = stmt.executeQuery(sql);
						   while(rs.next()){
				                // 通过字段检索
				                String user = rs.getString("data_user");
				               if(User.equals(user)) {
				            	  flag1 = 1;
				               }
						   }
						   sql = " SELECT data_password FROM `data` WHERE data_user = '"+User+"';";
						   ResultSet rs1 = stmt.executeQuery(sql);
						   while(rs1.next()){
				                // 通过字段检索
				                String password = rs1.getString("data_password");
				               if(PassWord.equals(password)) {
				            	   flag2 = 1;
				               }
						   }
						   if(flag1 == 1 && flag2 == 1) {
							   JOptionPane.showMessageDialog(null, "登录成功", "提示",JOptionPane.PLAIN_MESSAGE );
							   frame1.setVisible(false);
							   Game2048 game = new Game2048(400, 500);
					            game.setTitle("2048");
					            game.setLocationRelativeTo(null);
					            //居中
					            game.setVisible(true);
					            game.newGame();
						            
						       
		               }else {
		            	   if(flag1 == 0) {
		            		   JOptionPane.showMessageDialog(null, "用户名不存在", "提示",0 );
		            	   }else {
		            		   if(flag2 == 0 && flag1 == 1) {
		            			  JOptionPane.showMessageDialog(null, "密码错误", "提示",0 );
		            		   }
		            	   }
		               } 
						   rs.close();
						   rs1.close();
				            stmt.close();
				            conn.close();
				            break;
				        }catch(SQLException se){
				            // 处理 JDBC 错误
				            se.printStackTrace();
				        }catch(Exception a){
				            // 处理 Class.forName 错误
				            a.printStackTrace();
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
				            System.out.println("Goodbye!");
				            flag1 = 0;
				            flag2 = 0;
				            flag3 = 0;
				        }
					 }
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        this.add(button1);
	    }
	 
	    public static void main(String[] args) {
//			添加 
	        
	        
	        frame1.setTitle("Test");
	        frame1.setSize(400, 300);
	        frame1.setVisible(true);
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.add(panel1);
	        
			panel1.setSize(460, 220);
			panel1.setLocation(60, 200);
			panel1.setLayout(new GridLayout(3, 2, 20, 35));
			
			panel1.add(label1);
			panel1.add(textfield1);
			
			panel1.add(label2);
			panel1.add(textfield2);
			
			panel1.add(button1);
			panel1.add(button2);
			
			label1.setFont(font2);
			label2.setFont(font2);
			textfield1.setFont(font1);
			textfield2.setFont(font1);
			button1.setFont(font2);
			button2.setFont(font2);
			
			
			

			
//			窗体属性
			frame1.setTitle("用户登录");
			frame1.setSize(400,300);
			
			//	将窗体置于屏幕中间
			Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
			Dimension frameSize=frame1.getSize();
			frame1.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
			
			//	设置单击关闭按钮时的默认操作
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			
	    }
	    
	}
	// 另一个窗口
		class www extends JFrame {
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
			 
			//用户名及密码
			 final String USER = "root";
			 final String PASS = "98991217q";
			 
			String User;
			String PassWord;
			String PassWordChecked;
			String CheckWord;
			int flag1 = 0;
			int flag2 = 0;
			int flag3 = 0;
		    public www() {
		    	demo1 frame2 = new demo1();
//				创建
				JPanel panel2 = new JPanel();
				
		    	JLabel label1 = new JLabel("用户：");
				JLabel label2 = new JLabel("密码：");
				JLabel label3 = new JLabel("确认密码：");
				JLabel label4 = new JLabel("验证码：");
				
				JTextField textfield1 = new JTextField("");
				JTextField textfield2 = new JTextField("");
				JTextField textfield3 = new JTextField("");
				JTextField textfield4 = new JTextField("");
				JButton button1 = new JButton("Let's play!");

//				字体
				Font font1 = new Font("SansSerif",Font.BOLD,25);
				Font font2 = new Font("SansSerif",Font.BOLD,20);

//				添加
				frame2.add(panel2);
				panel2.setSize(350, 220);
				panel2.setLocation(250, 120);
				panel2.setLayout(new GridLayout(5, 1));
				
				panel2.add(label1);
				panel2.add(textfield1);
				
				panel2.add(label2);
				panel2.add(textfield2);
				
				panel2.add(label3);
				panel2.add(textfield3);
				
				panel2.add(label4);
				panel2.add(textfield4);
				
				panel2.add(button1);//搞不定
				
				label1.setFont(font2);
				label2.setFont(font2);
				label3.setFont(font2);
				label4.setFont(font2);
				textfield1.setFont(font1);
				textfield2.setFont(font1);
				textfield3.setFont(font1);
				textfield4.setFont(font1);
				button1.setFont(font2);
				
				button1.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						 User = textfield1.getText().toString();
						 PassWord = textfield2.getText().toString();
						 PassWordChecked = textfield3.getText().toString();
						 CheckWord = textfield4.getText().toString();
						 
						 while(true) {
							 if(User == null || User.isEmpty()||PassWord == null || PassWord.isEmpty()||PassWordChecked == null || PassWordChecked.isEmpty()||CheckWord == null || CheckWord.isEmpty()) {
								JOptionPane.showMessageDialog(null, "存在未输入信息", "提示", 0); 
								break;
							 }
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
							   sql = " SELECT data_user FROM `data` ;";
							   ResultSet rs = stmt.executeQuery(sql);
							   while(rs.next()){
					                // 通过字段检索
					                String user = rs.getString("data_user");
					    
					                // 输出数据
					               
					                if (user.equals(User)) {
										flag1 = 1;   
					                	JOptionPane.showMessageDialog(null,"用户名重复","提示",0);
					                	break;
									   }else {
										   if(!PassWord.equals(PassWordChecked)) {
											   flag2 = 1;
											   JOptionPane.showMessageDialog(null, "两次输入的密码不一致", "提示", 0);
											   break;
										   }
									   } 
							   }
							   if(flag1 == 0 && flag2 == 0) {
								   sql = "INSERT INTO data(data_user,data_password,data_file)VALUES('"+User+"','"+PassWord+"',0);";
								   stmt.executeUpdate(sql);
								   frame2.setVisible(false);
								   JOptionPane.showMessageDialog(null,"注册成功", "提示", JOptionPane.PLAIN_MESSAGE);
								   demo1.textfield1.setText(User);
								   demo1.textfield2.setText(
										   PassWord);
							   }
							   rs.close();
					            stmt.close();
					            conn.close();
					            break;
					        }catch(SQLException se){
					            // 处理 JDBC 错误
					            se.printStackTrace();
					        }catch(Exception a){
					            // 处理 Class.forName 错误
					            a.printStackTrace();
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
					            System.out.println("Goodbye!");
					            flag1 = 0;
					            flag2 = 0;
					            flag3 = 0;
					        }
						 }
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});

				
				 
			       
				 
				
//				窗体属性
				frame2.setTitle("用户注册");
				frame2.setSize(400,500);
				//	将窗体置于屏幕中间
				Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
				Dimension frameSize=frame2.getSize();
				frame2.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
				//	设置单击关闭按钮时的默认操作
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
		}
		}
		    @SuppressWarnings("serial")
		     class Game2048 extends JFrame {
		        // 移动方向
		        final public static int MOVE_UP = 0xf37;
		        final public static int MOVE_DOWN = 0xf36;
		        final public static int MOVE_LEFT = 0xf35;
		        final public static int MOVE_RIGHT = 0xf34;
		        // 游戏状态
		        final public static int GAME_OVER = 0xf33;
		        final public static int GAME_CONTINUE = 0xf32;
		        final public static int GAME_WIN = 0xf31;
		        // 按钮事件
		        final public static int BUTTON_NEW_GAME = 0xf30;
		        final public static int BUTTON_ABOUT = 0xf28;
		        final public static int BUTTON_EXIT = 0xf27;

		        /**
		         * 行
		         */
		        private int column;
		        /**
		         * 列
		         */
		        private int row;
		        /**
		         * 游戏状态
		         */
		        private int gameState;
		        /**
		         * 网格集  建立map
		         */
		        private HashMap<Point, Cube> viewList = new HashMap<>();
		        /**
		         * 计分板
		         */
		        private JMenuItem scoreBoard;
		        /**
		         * 计步器
		         */
		        private JMenuItem arithmometer;
		        /**
		         * 计步
		         */
		        private int count;
		        /**
		         * 新游戏加流程
		         */
		        private int gameLv;

		        /**
		         * main函数
		         * 
		         * @param args
		         */
//		        public static void main(String[] args) {
//		            Game2048 game = new Game2048(400, 500);
//		            game.setTitle("2048");
//		            game.setLocationRelativeTo(null);
//		            //居中
//		            game.setVisible(true);
//		            game.newGame();
//		        }

		        /**
		         * 构造一个默认大小的界面
		         */
		        public Game2048() {
		            this(400, 500);
		        }

		        /**
		         * 构造一个指定宽高的界面
		         * 
		         * @param width
		         *            宽
		         * @param height
		         *            高
		         */
		        public Game2048(int width, int height) {
		            column = width / 100;
		            row = height / 100;
		            //定义四行五列的表格布局
		            this.setLayout(new GridLayout(row, column));
		           
		            // 事件监听  enable Event并加入win弹窗提示
		            enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		            //调整表格大小
		            this.setSize(width, height);

		            // 利用button 绘制网格 怎么实现未知
		            for (int i = 0; i < row; i++) {
		                for (int j = 0; j < column; j++) {
		                    viewList.put(new Point(i, j), new Cube());
		                    this.add(getView(i, j).getView());
		                }
		            }

		            // 设置键盘监听
		            //建立菜单
		            this.addKeyListener(new MyKeyListener(this));

		            JMenuBar jmb = new JMenuBar();
		            JMenu jm = new JMenu("游戏");
		            JMenuItem item1 = new JMenuItem("新游戏");
		            item1.addMouseListener(new MyMouseListener(this,
		                    Game2048.BUTTON_NEW_GAME));
		            JMenuItem item2 = new JMenuItem("退出");
		            item2.addMouseListener(new MyMouseListener(this, Game2048.BUTTON_EXIT));
		            jm.add(item1);
		            jm.add(item2);

		            JMenu jm2 = new JMenu("关于");
		            JMenuItem item3 = new JMenuItem("关于");
		            item3.addMouseListener(new MyMouseListener(this, Game2048.BUTTON_ABOUT));
		            jm2.add(item3);

		            scoreBoard = new JMenuItem();
		            arithmometer = new JMenuItem();

		            jmb.add(jm);
		            jmb.add(jm2);
		            jmb.add(scoreBoard);
		            jmb.add(arithmometer);
		            this.setJMenuBar(jmb);
		        }

		        /**
		         * 向上移动
		         */
		        public void up() {
		            for (int x = 1; x < row; x++) {
		                for (int i = 0; i < column; i++) {
		                    move(Game2048.MOVE_UP, x, i, true);
		                }
		            }

		            createCube();
		            for (int x = 1; x < row; x++) {
		                for (int i = 0; i < column; i++) {
		                    move(Game2048.MOVE_UP, x, i, false);
		                }
		            }
		            addCount();
		        }

		        /**
		         * 向下移动
		         */
		        public void down() {
		            for (int x = row - 2; x >= 0; x--) {
		                for (int y = 0; y < column; y++) {
		                    move(Game2048.MOVE_DOWN, x, y, true);
		                }
		            }

		            createCube();
		            for (int x = row - 2; x >= 0; x--) {
		                for (int y = 0; y < column; y++) {
		                    move(Game2048.MOVE_DOWN, x, y, false);
		                }
		            }

		            addCount();
		        }

		        /**
		         * 向左移动
		         */
		        public void left() {
		            for (int y = 1; y < column; y++) {
		                for (int x = 0; x < row; x++) {
		                    move(Game2048.MOVE_LEFT, x, y, true);
		                }
		            }

		            createCube();
		            for (int y = 1; y < column; y++) {
		                for (int x = 0; x < row; x++) {
		                    move(Game2048.MOVE_LEFT, x, y, false);
		                }
		            }

		            addCount();
		        }

		        /**
		         * 向右移动
		         */
		        public void right() {
		            for (int y = column - 2; y >= 0; y--) {
		                for (int x = 0; x < row; x++) {
		                    move(Game2048.MOVE_RIGHT, x, y, true);
		                }
		            }

		            createCube();
		            for (int y = column - 2; y >= 0; y--) {
		                for (int x = 0; x < row; x++) {
		                    move(Game2048.MOVE_RIGHT, x, y, false);
		                }
		            }

		            addCount();
		        }

		        /**
		         * 移动
		         * 
		         * @param move_way
		         *            移动方向
		         * @param x
		         *            横坐标
		         * @param y
		         *            纵坐标
		         */
		        private void move(int move_way, int x, int y, boolean isAdd) {
		            switch (move_way) {
		            case Game2048.MOVE_DOWN: {
		                for (; x < row - 1; x++) {
		                    swap(getView(x + 1, y), getView(x, y), isAdd);
		                }
		            }
		                break;

		            case Game2048.MOVE_LEFT: {
		                for (; y > 0; y--) {
		                    swap(getView(x, y - 1), getView(x, y), isAdd);
		                }
		            }
		                break;

		            case Game2048.MOVE_RIGHT: {
		                for (; y < column - 1; y++) {
		                    swap(getView(x, y + 1), getView(x, y), isAdd);
		                }
		            }
		                break;

		            case Game2048.MOVE_UP: {
		                for (; x > 0; x--) {
		                    swap(getView(x - 1, y), getView(x, y), isAdd);
		                }
		            }
		                break;
		            }
		        }

		        /**
		         * 单向交换实现移动
		         * 
		         * @param next
		         *            移动至目标位置
		         * @param now
		         *            需要移动的目标
		         * @param isAdd
		         *            是否是第一次移动
		         */
		        private void swap(Cube next, Cube now, boolean isAdd) {
		            if (isAdd) {
		                if (now.getNum() != 0 && next.getNum() == 0) {
		                    next.setText(now.getNum());
		                    now.setText(0);
		                    next.setIsAdded(now.isAdded());
		                    now.setIsAdded(false);
		                } else if (!now.isAdded() && !next.isAdded()
		                        && next.getNum() == now.getNum() && now.getNum() != 0) {
		                    next.setText(now.getNum() * 2);
		                    now.setText(0);
		                    next.setIsAdded(true);
		                    now.setIsAdded(false);
		                }
		            } else {
		                if (next.getNum() == 0) {
		                    next.setText(now.getNum());
		                    now.setText(0);
		                }
		                now.setIsAdded(false);
		                next.setIsAdded(false);
		            }
		        }

		        /**
		         * 获取指定控件
		         * 
		         * @param x
		         * @param y
		         * @return Cube
		         */
		        private Cube getView(int x, int y) {
		            return viewList.get(new Point(x, y));
		        }

		        /**
		         * 生成随机控件 随机位置
		         */
		      
		        private void createCube() {
		            int x;
		            int y;

		            do {
		                x = (int) (Math.random() * 1000 % row);
		                y = (int) (Math.random() * 1000 % column);
		            } while (getView(x, y).getNum() != 0);

		            getView(x, y).setText(Math.random() > 0.5 ? 2 : 4);
		            isOverGame();
		        }

		        /**
		         * 检测游戏状态
		         */
		        private void isOverGame() {
		            int score = 0;
		            int state = Game2048.GAME_OVER;

		            for (int x = 0; x < row; x++) {
		                for (int y = 0; y < column; y++) {

		                    // 计算得分
		                    score += getView(x, y).getNum();

		                    if (getView(x, y).getNum() == 0) {
		                        state = Game2048.GAME_CONTINUE;
		                    } else if (getView(x, y).getNum() == 2048 * (gameLv + 1)) {
		                        state = Game2048.GAME_WIN;
		                    }
		                }
		            }

		            if (state != Game2048.GAME_CONTINUE && state != Game2048.GAME_WIN) {
		                gameState = Game2048.GAME_OVER;
		            } else {
		                gameState = state;
		            }

		            scoreBoard.setText("得分:" + score);

		        }

		        /**
		         * 计步
		         */
		        private void addCount() {
		            count++;
		            arithmometer.setText("计步：" + count);
		        }

		        /**
		         * 获取游戏状态
		         * 
		         * @return int
		         */
		        public int getGameState() {
		            return gameState;
		        }

		        /**
		         * 初始化游戏数据
		         */
		        private void initialise() {
		            for (int i = 0; i < row; i++) {
		                for (int j = 0; j < column; j++) {
		                    getView(i, j).setText(0);
		                }
		            }

		            createCube();
		            createCube();
		            count = 0;
		            arithmometer.setText("计步：" + count);
		            gameLv = 0;
		            this.setTitle("2048");
		        }

		        /**
		         * 开启新游戏
		         */
		        public void newGame() {
		            if (gameState == Game2048.GAME_CONTINUE) {
		                int jop = JOptionPane.showConfirmDialog(null, "是否开始新一轮游戏?", "Tips",
		                        JOptionPane.YES_NO_OPTION);

		                if (jop == JOptionPane.YES_OPTION) {
		                    initialise();
		                }
		            } else {
		                initialise();
		            }
		        }

		        /**
		         * 重载窗体事件-控制关闭
		         */
		        protected void processWindowEvent(WindowEvent e) {
		            if (e.getID() == WindowEvent.WINDOW_CLOSING) {
		                if (getGameState() == Game2048.GAME_CONTINUE) {
		                    int jop = JOptionPane.showConfirmDialog(null, "是否退出游戏?",
		                            "Tips", JOptionPane.YES_NO_OPTION);
		                    

		                    if (jop == JOptionPane.YES_OPTION) {
		                        super.processWindowEvent(e);
		                    }
		                } else {
		                    super.processWindowEvent(e);
		                }
		            }
		        }

		        /**
		         * 进入下一难度游戏
		         */
		        public void nextLv() {
		            gameLv++;
		            this.setTitle(2048 * (gameLv + 1) + "");
		        }

		        /**
		         * 关于
		         */
		        public void about() {
		            JOptionPane.showMessageDialog(null, "E-mail:czh60601@126.com");
		        }
		    }

		    class Cube {
		        private int num;
		        private JButton btn;
		        private boolean isAdded;

		        /**
		         * 构造一个方块
		         */
		        public Cube() {
		            btn = new JButton();
		            btn.setFont(new Font("微软雅黑", Font.BOLD, 24));
		            btn.setEnabled(false);
		            num = 0;
		            isAdded = false;
		        }

		        /**
		         * 设置文本内容
		         * 
		         * @param n
		         *            数值
		         */
		        public void setText(int n) {
		            num = n;
		            btn.setText(n != 0 ? n + "" : "");
		        }

		        /**
		         * 获取控件
		         * 
		         * @return JButton
		         */
		        public JButton getView() {
		            return btn;
		        }

		        /**
		         * 获取数值
		         * 
		         * @return int
		         */
		        public int getNum() {
		            return num;
		        }

		        /**
		         * 是否是相加而成 限当前移动次有效,移动结束后改回默认值-false
		         * 
		         * @return
		         */
		        public boolean isAdded() {
		            return isAdded;
		        }

		        /**
		         * 修改生成方式
		         * 
		         * @param b
		         *            true-相加而成
		         */
		        public void setIsAdded(boolean b) {
		            isAdded = b;
		        }

		    }

		    class MyKeyListener implements KeyListener {
		        /*
		         * 键盘代码 w/87 s/83 a/65 d/68 up/38 down/40 left/37 right/39 f1/112 f2/113
		         * f3/114
		         */
		        final public static int KEY_W = 0xf57;
		        final public static int KEY_S = 0xf53;
		        final public static int KEY_A = 0xf41;
		        final public static int KEY_D = 0xf44;
		        final public static int KEY_UP = 0xf26;
		        final public static int KEY_DOWN = 0xf28;
		        final public static int KEY_LEFT = 0xf25;
		        final public static int KEY_RIGHT = 0xf27;

		        private Game2048 game;

		        /**
		         * 构造一个键盘监听器
		         * 
		         * @param game
		         *            主界面
		         */
		        public MyKeyListener(Game2048 game) {
		            this.game = game;
		        }

		        @Override
		        public void keyPressed(KeyEvent e) {
		            int keyCode = e.getKeyCode() + 0xf00;

		            switch (game.getGameState()) {
		            case Game2048.GAME_CONTINUE: {
		                switch (keyCode) {
		                case MyKeyListener.KEY_W:
		                case MyKeyListener.KEY_UP: {
		                    game.up();
		                }
		                    break;

		                case MyKeyListener.KEY_S:
		                case MyKeyListener.KEY_DOWN: {
		                    game.down();
		                }
		                    break;

		                case MyKeyListener.KEY_A:
		                case MyKeyListener.KEY_LEFT: {
		                    game.left();
		                }
		                    break;

		                case MyKeyListener.KEY_D:
		                case MyKeyListener.KEY_RIGHT: {
		                    game.right();
		                }
		                    break;
		                }
		            }
		                break;

		            case Game2048.GAME_OVER: {
		                int jop = JOptionPane
		                        .showConfirmDialog(null, "很遗憾，你没能达成本次目标，是否开启新游戏?", "游戏结束",
		                                JOptionPane.YES_NO_OPTION);

		                if (jop == JOptionPane.YES_OPTION) {
		                    game.newGame();
		                }
		            }
		                break;

		            case Game2048.GAME_WIN: {
		                int jop = JOptionPane.showConfirmDialog(null,
		                        "你已完成本次目标:" + game.getTitle() + ",是否进入更高难度游戏?", "恭喜晋级",
		                        JOptionPane.YES_NO_OPTION);

		                if (jop == JOptionPane.YES_OPTION) {
		                    game.nextLv();
		                }
		            }
		                break;
		            }
		        }

		        @Override
		        public void keyReleased(KeyEvent e) {

		        }

		        @Override
		        public void keyTyped(KeyEvent e) {

		        }
		    }

		    class MyMouseListener implements MouseListener {
		        private Game2048 game;
		        private int btnEvn;

		        public MyMouseListener(Game2048 game, int btnEvn) {
		            this.game = game;
		            this.btnEvn = btnEvn;
		        }

		        @Override
		        public void mouseClicked(MouseEvent e) {

		        }

		        @Override
		        public void mouseEntered(MouseEvent e) {

		        }

		        @Override
		        public void mouseExited(MouseEvent e) {

		        }

		        @Override
		        public void mousePressed(MouseEvent e) {

		        }

		        @Override
		        public void mouseReleased(MouseEvent e) {
		            switch (btnEvn) {
		            case Game2048.BUTTON_NEW_GAME: {
		                game.newGame();
		            }
		                break;

		            case Game2048.BUTTON_ABOUT: {
		                game.about();
		            }
		                break;

		            case Game2048.BUTTON_EXIT: {
		                game.processWindowEvent(new WindowEvent(game,
		                        WindowEvent.WINDOW_CLOSING));
		            }
		                break;
		            }
		        }

		    }

		
		
		
