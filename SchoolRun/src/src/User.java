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
	static int [] rank = new int[5]; //랭킹
	static int [] score = new int[5]; //랭킹에 넣을 점수 배열
	static String [] name = new String[5]; //랭킹에 넣을 이름 배열
	static int timeCheck = 0;
	static int user_money; //DB에 값을 넣기, 아이템 사기 위해 있는 변수
	public static int guest_money; //게스트 모드때 사용할 돈 변수
	static int user_score; //DB에 값 넣기 위해 있는 변수
	public static int user_stage; //Stage 변수
	public static int play_stage = 1; //플레이할 스테이지를 리턴하는 변수
	static int u_id = 0; //값을 넣기 위해 필요한 변수
	public static int isItem = 0; //아이템이 있는지 확인하는 변수

	
	//DB 연결하는 메서드
	public void connectDB() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connect OK");
			stmt = conn.createStatement();
		} catch(Exception e) {
			e.toString();
		}
	}
	
	
	//로그인하는 메서드
	public boolean login(String name, String pwd) {
		boolean check_login = false;
		
		try {
			this.connectDB();
			sql = "select * from user where user_id= '" + name + "';";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				if(rs.getString("pw").equals(pwd)) {//비번이 같으면
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
	
	
	//중복 체크하는 메서드
	public int checkId(String name) {
		this.check = 1;
		try {
			this.connectDB();
			sql = "select * from user where user_id='" + name + "';";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //같은 아이디가 있으면 check의 값이 false로 바뀜
				if(rs.getString("user_id").equals(name)) {
					this.check = 2;
				} 
			}
		} catch (Exception e) {
			e.toString();
		}
		return this.check;
	}
	
	
	//회원가입하는 메서드
	public void join(String name, String pwd) {
		try {
			this.connectDB();
			sql = "insert into user(user_id, pw) value('" + name + "', '" + pwd + "');";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.toString();
		}
	}
	
	
	
	//현재 유저의 모든 변수들 현황 가져오기
	public void getAll() {
		try {
			this.connectDB();
			
			sql = "select id from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				u_id = rs.getInt("id");
				System.out.println(u_id);
			} // 해당 아이디 구하기

			sql = "select score from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_score = rs.getInt("score");
				System.out.println(user_score);
			} // 해당 점수 구하기

			sql = "select money from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_money = rs.getInt("money");
				System.out.println(user_money);
			} // 해당 돈 구하기
			
			sql = "select stage from user where user_id='" + this.user_id + "';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.user_stage = rs.getInt("stage");
				System.out.println(user_stage);
			} // 해당 레벨 구하기


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//결과 넣기
	public void intoResult(int score, int money) {
		
		System.out.println(this.user_id);
		System.out.println(this.user_pw);
	
		try {
			this.connectDB();
			if (this.user_id != null) { //로그인한 회원일 때
				
				getAll();
				System.out.println(this.u_id);
				
				//기존에 저장된 점수보다 이번에 나온 점수가 더 높을 때 디비에 저장, 그렇지 않으면 디비에 저장X (=가장 높은 점수를 db에 저장한다는 뜻)
				if (this.user_score < score) {
					sql = "UPDATE user SET score = " + score + " WHERE id = " + this.u_id + ";";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}

				// (기존에 있는 돈 + 게임을 하면서 얻은 돈)을 디비에 저장
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
	
	
	//랭킹 메서드
	public void setRank() {
		int rank_num [] = new int[5];
		int now_id = 0;
		int i = 0;
		
		try {
			this.connectDB();
			//정렬
			sql = "select * from user order by score desc;";
			ResultSet rs = stmt.executeQuery(sql);
		
			//while문, ranking 값넣기
			while(rs.next()) {
				if(i>=5) {
					break;
				}
				rank_num[i] = rs.getInt("id"); 
				System.out.println("정렬");
				i+=1;
			}
			//for문통해  값넣기
			for(int j = 0; j<rank_num.length; j++) {
				sql = "UPDATE user SET ranking = "+ (j+1) + " WHERE id = " + rank_num[j];
				stmt.executeUpdate(sql);
			}
			
			for(int j = 0; j<rank_num.length; j++) {
				this.rank[j] = j+1; //랭크의 값 넣기
				sql = "select * from user where ranking="+(j+1); //이름, 점수 구하기
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.name[j] = rs.getString("user_id"); //이름
					this.score[j] = rs.getInt("score"); //점수
				}
			}
			
			this.timeCheck = 1;
			System.out.println("랭킹체크");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//점수 두배 아이템 구매
	public void buyDoubleScoreItem() {
		getAll();
		if(this.user_id != null) {
			try {
				this.connectDB();
				System.out.println("사기 전 돈 : " + this.user_money);
				if (this.user_money >= 50) {
					this.isItem += 1; // 1이면 돈이 두배
					System.out.println("아이템 상태 : " + isItem);
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
	
	//돈 두배 아이템 구매
	public void buyDoubleMoneyItem() {
		getAll();
		if(this.user_id != null) {
			try {
				this.connectDB();
				if (this.user_money >= 50) {
					this.isItem += 2; // 1이면 돈이 두배
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
	
	//스테이지 설정
	public boolean setplayStage(int num) {
		try {
			this.connectDB();
			getAll();
			
			if(user_id!=null) {
				if(num > this.user_stage) {
					System.out.println("레벨 안됨.");
				} else {
					this.play_stage = num;
					System.out.println(num+"번 스테이지 설정");
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