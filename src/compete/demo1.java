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
//		����	
	    static JPanel panel1 = new JPanel();
		static JLabel label1 = new JLabel("�û���");
		static JLabel label2 = new JLabel("���룺");
		static JTextField textfield1 = new JTextField("");
		static JTextField textfield2 = new JTextField("");
		static JButton button1 = new JButton("��¼");
		static JButton button2 = new JButton("ע��");
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
		static demo1 frame1 = new demo1();
		 
		//�û���������
		
		
//		����
		static Font font1 = new Font("SansSerif",Font.BOLD,25);
		static Font font2 = new Font("SansSerif",Font.BOLD,20);
	    
	    public demo1() {
	    	button1 = new JButton("��¼");
	        button2 = new JButton("ע��");
	        button2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // ����һ������
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
						 JOptionPane.showMessageDialog(null, "δ�����û���������", "��ʾ", 0);
						 break;
					 }
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
						   sql = " SELECT data_user FROM `data` ;";
						   ResultSet rs = stmt.executeQuery(sql);
						   while(rs.next()){
				                // ͨ���ֶμ���
				                String user = rs.getString("data_user");
				               if(User.equals(user)) {
				            	  flag1 = 1;
				               }
						   }
						   sql = " SELECT data_password FROM `data` WHERE data_user = '"+User+"';";
						   ResultSet rs1 = stmt.executeQuery(sql);
						   while(rs1.next()){
				                // ͨ���ֶμ���
				                String password = rs1.getString("data_password");
				               if(PassWord.equals(password)) {
				            	   flag2 = 1;
				               }
						   }
						   if(flag1 == 1 && flag2 == 1) {
							   JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��ʾ",JOptionPane.PLAIN_MESSAGE );
							   frame1.setVisible(false);
							   Game2048 game = new Game2048(400, 500);
					            game.setTitle("2048");
					            game.setLocationRelativeTo(null);
					            //����
					            game.setVisible(true);
					            game.newGame();
						            
						       
		               }else {
		            	   if(flag1 == 0) {
		            		   JOptionPane.showMessageDialog(null, "�û���������", "��ʾ",0 );
		            	   }else {
		            		   if(flag2 == 0 && flag1 == 1) {
		            			  JOptionPane.showMessageDialog(null, "�������", "��ʾ",0 );
		            		   }
		            	   }
		               } 
						   rs.close();
						   rs1.close();
				            stmt.close();
				            conn.close();
				            break;
				        }catch(SQLException se){
				            // ���� JDBC ����
				            se.printStackTrace();
				        }catch(Exception a){
				            // ���� Class.forName ����
				            a.printStackTrace();
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
//			��� 
	        
	        
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
			
			
			

			
//			��������
			frame1.setTitle("�û���¼");
			frame1.setSize(400,300);
			
			//	������������Ļ�м�
			Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ĵ�С
			Dimension frameSize=frame1.getSize();
			frame1.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
			
			//	���õ����رհ�ťʱ��Ĭ�ϲ���
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			
	    }
	    
	}
	// ��һ������
		class www extends JFrame {
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
			 
			//�û���������
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
//				����
				JPanel panel2 = new JPanel();
				
		    	JLabel label1 = new JLabel("�û���");
				JLabel label2 = new JLabel("���룺");
				JLabel label3 = new JLabel("ȷ�����룺");
				JLabel label4 = new JLabel("��֤�룺");
				
				JTextField textfield1 = new JTextField("");
				JTextField textfield2 = new JTextField("");
				JTextField textfield3 = new JTextField("");
				JTextField textfield4 = new JTextField("");
				JButton button1 = new JButton("Let's play!");

//				����
				Font font1 = new Font("SansSerif",Font.BOLD,25);
				Font font2 = new Font("SansSerif",Font.BOLD,20);

//				���
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
				
				panel2.add(button1);//�㲻��
				
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
								JOptionPane.showMessageDialog(null, "����δ������Ϣ", "��ʾ", 0); 
								break;
							 }
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
							   sql = " SELECT data_user FROM `data` ;";
							   ResultSet rs = stmt.executeQuery(sql);
							   while(rs.next()){
					                // ͨ���ֶμ���
					                String user = rs.getString("data_user");
					    
					                // �������
					               
					                if (user.equals(User)) {
										flag1 = 1;   
					                	JOptionPane.showMessageDialog(null,"�û����ظ�","��ʾ",0);
					                	break;
									   }else {
										   if(!PassWord.equals(PassWordChecked)) {
											   flag2 = 1;
											   JOptionPane.showMessageDialog(null, "������������벻һ��", "��ʾ", 0);
											   break;
										   }
									   } 
							   }
							   if(flag1 == 0 && flag2 == 0) {
								   sql = "INSERT INTO data(data_user,data_password,data_file)VALUES('"+User+"','"+PassWord+"',0);";
								   stmt.executeUpdate(sql);
								   frame2.setVisible(false);
								   JOptionPane.showMessageDialog(null,"ע��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								   demo1.textfield1.setText(User);
								   demo1.textfield2.setText(
										   PassWord);
							   }
							   rs.close();
					            stmt.close();
					            conn.close();
					            break;
					        }catch(SQLException se){
					            // ���� JDBC ����
					            se.printStackTrace();
					        }catch(Exception a){
					            // ���� Class.forName ����
					            a.printStackTrace();
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

				
				 
			       
				 
				
//				��������
				frame2.setTitle("�û�ע��");
				frame2.setSize(400,500);
				//	������������Ļ�м�
				Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ĵ�С
				Dimension frameSize=frame2.getSize();
				frame2.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
				//	���õ����رհ�ťʱ��Ĭ�ϲ���
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
		}
		}
		    @SuppressWarnings("serial")
		     class Game2048 extends JFrame {
		        // �ƶ�����
		        final public static int MOVE_UP = 0xf37;
		        final public static int MOVE_DOWN = 0xf36;
		        final public static int MOVE_LEFT = 0xf35;
		        final public static int MOVE_RIGHT = 0xf34;
		        // ��Ϸ״̬
		        final public static int GAME_OVER = 0xf33;
		        final public static int GAME_CONTINUE = 0xf32;
		        final public static int GAME_WIN = 0xf31;
		        // ��ť�¼�
		        final public static int BUTTON_NEW_GAME = 0xf30;
		        final public static int BUTTON_ABOUT = 0xf28;
		        final public static int BUTTON_EXIT = 0xf27;

		        /**
		         * ��
		         */
		        private int column;
		        /**
		         * ��
		         */
		        private int row;
		        /**
		         * ��Ϸ״̬
		         */
		        private int gameState;
		        /**
		         * ����  ����map
		         */
		        private HashMap<Point, Cube> viewList = new HashMap<>();
		        /**
		         * �Ʒְ�
		         */
		        private JMenuItem scoreBoard;
		        /**
		         * �Ʋ���
		         */
		        private JMenuItem arithmometer;
		        /**
		         * �Ʋ�
		         */
		        private int count;
		        /**
		         * ����Ϸ������
		         */
		        private int gameLv;

		        /**
		         * main����
		         * 
		         * @param args
		         */
//		        public static void main(String[] args) {
//		            Game2048 game = new Game2048(400, 500);
//		            game.setTitle("2048");
//		            game.setLocationRelativeTo(null);
//		            //����
//		            game.setVisible(true);
//		            game.newGame();
//		        }

		        /**
		         * ����һ��Ĭ�ϴ�С�Ľ���
		         */
		        public Game2048() {
		            this(400, 500);
		        }

		        /**
		         * ����һ��ָ����ߵĽ���
		         * 
		         * @param width
		         *            ��
		         * @param height
		         *            ��
		         */
		        public Game2048(int width, int height) {
		            column = width / 100;
		            row = height / 100;
		            //�����������еı�񲼾�
		            this.setLayout(new GridLayout(row, column));
		           
		            // �¼�����  enable Event������win������ʾ
		            enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		            //��������С
		            this.setSize(width, height);

		            // ����button �������� ��ôʵ��δ֪
		            for (int i = 0; i < row; i++) {
		                for (int j = 0; j < column; j++) {
		                    viewList.put(new Point(i, j), new Cube());
		                    this.add(getView(i, j).getView());
		                }
		            }

		            // ���ü��̼���
		            //�����˵�
		            this.addKeyListener(new MyKeyListener(this));

		            JMenuBar jmb = new JMenuBar();
		            JMenu jm = new JMenu("��Ϸ");
		            JMenuItem item1 = new JMenuItem("����Ϸ");
		            item1.addMouseListener(new MyMouseListener(this,
		                    Game2048.BUTTON_NEW_GAME));
		            JMenuItem item2 = new JMenuItem("�˳�");
		            item2.addMouseListener(new MyMouseListener(this, Game2048.BUTTON_EXIT));
		            jm.add(item1);
		            jm.add(item2);

		            JMenu jm2 = new JMenu("����");
		            JMenuItem item3 = new JMenuItem("����");
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
		         * �����ƶ�
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
		         * �����ƶ�
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
		         * �����ƶ�
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
		         * �����ƶ�
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
		         * �ƶ�
		         * 
		         * @param move_way
		         *            �ƶ�����
		         * @param x
		         *            ������
		         * @param y
		         *            ������
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
		         * ���򽻻�ʵ���ƶ�
		         * 
		         * @param next
		         *            �ƶ���Ŀ��λ��
		         * @param now
		         *            ��Ҫ�ƶ���Ŀ��
		         * @param isAdd
		         *            �Ƿ��ǵ�һ���ƶ�
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
		         * ��ȡָ���ؼ�
		         * 
		         * @param x
		         * @param y
		         * @return Cube
		         */
		        private Cube getView(int x, int y) {
		            return viewList.get(new Point(x, y));
		        }

		        /**
		         * ��������ؼ� ���λ��
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
		         * �����Ϸ״̬
		         */
		        private void isOverGame() {
		            int score = 0;
		            int state = Game2048.GAME_OVER;

		            for (int x = 0; x < row; x++) {
		                for (int y = 0; y < column; y++) {

		                    // ����÷�
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

		            scoreBoard.setText("�÷�:" + score);

		        }

		        /**
		         * �Ʋ�
		         */
		        private void addCount() {
		            count++;
		            arithmometer.setText("�Ʋ���" + count);
		        }

		        /**
		         * ��ȡ��Ϸ״̬
		         * 
		         * @return int
		         */
		        public int getGameState() {
		            return gameState;
		        }

		        /**
		         * ��ʼ����Ϸ����
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
		            arithmometer.setText("�Ʋ���" + count);
		            gameLv = 0;
		            this.setTitle("2048");
		        }

		        /**
		         * ��������Ϸ
		         */
		        public void newGame() {
		            if (gameState == Game2048.GAME_CONTINUE) {
		                int jop = JOptionPane.showConfirmDialog(null, "�Ƿ�ʼ��һ����Ϸ?", "Tips",
		                        JOptionPane.YES_NO_OPTION);

		                if (jop == JOptionPane.YES_OPTION) {
		                    initialise();
		                }
		            } else {
		                initialise();
		            }
		        }

		        /**
		         * ���ش����¼�-���ƹر�
		         */
		        protected void processWindowEvent(WindowEvent e) {
		            if (e.getID() == WindowEvent.WINDOW_CLOSING) {
		                if (getGameState() == Game2048.GAME_CONTINUE) {
		                    int jop = JOptionPane.showConfirmDialog(null, "�Ƿ��˳���Ϸ?",
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
		         * ������һ�Ѷ���Ϸ
		         */
		        public void nextLv() {
		            gameLv++;
		            this.setTitle(2048 * (gameLv + 1) + "");
		        }

		        /**
		         * ����
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
		         * ����һ������
		         */
		        public Cube() {
		            btn = new JButton();
		            btn.setFont(new Font("΢���ź�", Font.BOLD, 24));
		            btn.setEnabled(false);
		            num = 0;
		            isAdded = false;
		        }

		        /**
		         * �����ı�����
		         * 
		         * @param n
		         *            ��ֵ
		         */
		        public void setText(int n) {
		            num = n;
		            btn.setText(n != 0 ? n + "" : "");
		        }

		        /**
		         * ��ȡ�ؼ�
		         * 
		         * @return JButton
		         */
		        public JButton getView() {
		            return btn;
		        }

		        /**
		         * ��ȡ��ֵ
		         * 
		         * @return int
		         */
		        public int getNum() {
		            return num;
		        }

		        /**
		         * �Ƿ�����Ӷ��� �޵�ǰ�ƶ�����Ч,�ƶ�������Ļ�Ĭ��ֵ-false
		         * 
		         * @return
		         */
		        public boolean isAdded() {
		            return isAdded;
		        }

		        /**
		         * �޸����ɷ�ʽ
		         * 
		         * @param b
		         *            true-��Ӷ���
		         */
		        public void setIsAdded(boolean b) {
		            isAdded = b;
		        }

		    }

		    class MyKeyListener implements KeyListener {
		        /*
		         * ���̴��� w/87 s/83 a/65 d/68 up/38 down/40 left/37 right/39 f1/112 f2/113
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
		         * ����һ�����̼�����
		         * 
		         * @param game
		         *            ������
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
		                        .showConfirmDialog(null, "���ź�����û�ܴ�ɱ���Ŀ�꣬�Ƿ�������Ϸ?", "��Ϸ����",
		                                JOptionPane.YES_NO_OPTION);

		                if (jop == JOptionPane.YES_OPTION) {
		                    game.newGame();
		                }
		            }
		                break;

		            case Game2048.GAME_WIN: {
		                int jop = JOptionPane.showConfirmDialog(null,
		                        "������ɱ���Ŀ��:" + game.getTitle() + ",�Ƿ��������Ѷ���Ϸ?", "��ϲ����",
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

		
		
		
