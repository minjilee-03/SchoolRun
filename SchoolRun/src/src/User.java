package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	String url = "jdbc:mysql://127.0.0.1:3306/schoolrun?serverTimezone = UTC";
	String driver = "com.mysql.cj.jdbc.Driver";
	String id = "root";
	String pw = "mirim";
	String sql;
	int check = 0;
	Connection conn;
	Statement stmt;
	
	static String user_id;
	static String user_pw;
	static int [] rank = new int[5]; //��ŷ
	static int [] score = new int[5]; //��ŷ�� ���� ���� �迭
	static String [] name = new String[5]; //��ŷ�� ���� �̸� �迭
	static int timeCheck = 0;
	static int user_money; //DB�� ���� �ֱ�, ������ ��� ���� �ִ� ����
	public static int guest_money; //�Խ�Ʈ ��嶧 ����� �� ����
	static int user_score; //DB�� �� �ֱ� ���� �ִ� ����
	public static int user_stage; //Stage ����
	public static int play_stage = 1; //�÷����� ���������� �����ϴ� ����
	static int u_id = 0; //���� �ֱ� ���� �ʿ��� ����
	public static int isItem = 0; //�������� �ִ��� Ȯ���ϴ� ����

	
	//DB �����ϴ� �޼���
	public void connectDB() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connect OK");
			stmt = conn.createStatement();
		} catch(Exception e) {
			e.toString();
		}
	}
	
	
	//�α����ϴ� �޼���
	public boolean login(String name, String pwd) {
		boolean check_login = false;
		
		try {
			this.connectDB();
			sql = "select * from user where user_id= '" + name + "';";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				if(rs.getString("pw").equals(pwd)) {//����� ������
					check_login = true;
					this.user_id = name;
					this.user_pw = pwd;
				}
			}
			
		} catch (Exception e) {
			e.toString();
		}
		return check_login;
	}
	
	
	//�ߺ� üũ�ϴ� �޼���
	public int checkId(String name) {
		this.check = 1;
		try {
			this.connectDB();
			sql = "select * from user where user_id='" + name + "';";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //���� ���̵� ������ check�� ���� false�� �ٲ�
				if(rs.getString("user_id").equals(name)) {
					this.check = 2;
				} 
			}
		} catch (Exception e) {
			e.toString();
		}
		return this.check;
	}
	
	
	//ȸ�������ϴ� �޼���
	public void join(String name, String pwd) {
		try {
			this.connectDB();
			sql = "insert into user(user_id, pw) value('" + name + "', '" + pwd + "');";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.toString();
		}
	}
	
	
	
	//���� ������ ��� ������ ��Ȳ ��������
	public void getAll() {
		try {
			this.connectDB();
			
			sql = "select id from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				u_id = rs.getInt("id");
				System.out.println(u_id);
			} // �ش� ���̵� ���ϱ�

			sql = "select score from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_score = rs.getInt("score");
				System.out.println(user_score);
			} // �ش� ���� ���ϱ�

			sql = "select money from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_money = rs.getInt("money");
				System.out.println(user_money);
			} // �ش� �� ���ϱ�
			
			sql = "select stage from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_stage = rs.getInt("stage");
				System.out.println(user_stage);
			} // �ش� ���� ���ϱ�


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//��� �ֱ�
	public void intoResult(int score, int money) {
		
		System.out.println(this.user_id);
		System.out.println(this.user_pw);
	
		try {
			this.connectDB();
			if (this.user_id != null) { //�α����� ȸ���� ��
				
				getAll();
				System.out.println(this.u_id);
				
				//������ ����� �������� �̹��� ���� ������ �� ���� �� ��� ����, �׷��� ������ ��� ����X (=���� ���� ������ db�� �����Ѵٴ� ��)
				if (this.user_score < score) {
					sql = "UPDATE user SET score = " + score + " WHERE id = " + this.u_id + ";";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}

				// (������ �ִ� �� + ������ �ϸ鼭 ���� ��)�� ��� ����
				sql = "UPDATE user SET money = " + (user_money + money) + " WHERE id = " + this.u_id + ";";
				System.out.println(sql);
				stmt.executeUpdate(sql);
			} else {
				this.guest_money += money;
			}
			
			
		} catch (Exception e) {
			e.toString();
		}
	}
	
	
	//��ŷ �޼���
	public void setRank() {
		int rank_num [] = new int[5];
		int now_id = 0;
		int i = 0;
		
		try {
			this.connectDB();
			//����
			sql = "select * from user order by score desc;";
			ResultSet rs = stmt.executeQuery(sql);
		
			//while��, ranking ���ֱ�
			while(rs.next()) {
				if(i>=5) {
					break;
				}
				rank_num[i] = rs.getInt("id"); 
				System.out.println("����");
				i+=1;
			}
			//for������  ���ֱ�
			for(int j = 0; j<rank_num.length; j++) {
				sql = "UPDATE user SET ranking = "+ (j+1) + " WHERE id = " + rank_num[j];
				stmt.executeUpdate(sql);
			}
			
			for(int j = 0; j<rank_num.length; j++) {
				this.rank[j] = j+1; //��ũ�� �� �ֱ�
				sql = "select * from user where ranking="+(j+1); //�̸�, ���� ���ϱ�
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.name[j] = rs.getString("user_id"); //�̸�
					this.score[j] = rs.getInt("score"); //����
				}
			}
			
			this.timeCheck = 1;
			System.out.println("��ŷüũ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//���� �ι� ������ ����
	public void buyDoubleScoreItem() {
		getAll();
		if(this.user_id != null) {
			try {
				this.connectDB();
				System.out.println("��� �� �� : " + this.user_money);
				if (this.user_money >= 50) {
					this.isItem += 1; // 1�̸� ���� �ι�
					System.out.println("������ ���� : " + isItem);
					sql = "UPDATE user SET money = " + (this.user_money - 50) + " WHERE id = " + this.u_id;
					stmt.executeUpdate(sql);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (this.guest_money >= 50) {
				this.isItem += 1; 
				this.guest_money -= 50;
			}
		}
	}
	
	//�� �ι� ������ ����
	public void buyDoubleMoneyItem() {
		getAll();
		if(this.user_id != null) {
			try {
				this.connectDB();
				if (this.user_money >= 50) {
					this.isItem += 2; // 1�̸� ���� �ι�
					sql = "UPDATE user SET money = " + (this.user_money - 50) + " WHERE id = " + this.u_id;
					stmt.executeUpdate(sql);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (this.guest_money >= 50) {
				this.isItem += 2; 
				this.guest_money -= 50;
			}
		}
	}
	
	//�������� ����
	public boolean setplayStage(int num) {
		try {
			this.connectDB();
			getAll();
			
			if(user_id!=null) {
				if(num > this.user_stage) {
					System.out.println("���� �ȵ�.");
				} else {
					this.play_stage = num;
					System.out.println(num+"�� �������� ����");
					return true;
				}
			} else {
				this.play_stage = num;
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public void setStage(int num) {
		try {
			this.connectDB();
			getAll();
			
			if(num==1 || num==2) {
				sql = "UPDATE user SET stage = " + (num+1) + " WHERE id = " + this.u_id;
				stmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) {
		User u1 = new User();
		u1.setRank();
	}
}