package Game;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import class_pack.Back;
import class_pack.Character;
import class_pack.Foot;
import class_pack.Jelly;
import class_pack.Tacle;
import class_pack.Util;
import src.Music;
import src.User;

public class Stage2 {
	private JFrame frame;
	JPanel panel;
	MapInfo m1 = new MapInfo();
	
	//배경
	private ImageIcon backIc = new ImageIcon(m1.backStr);
	private ImageIcon backIc_2 = new ImageIcon(m1.backStr);
	//캐릭터 이미지
	CharacterInfo ci = new CharacterInfo();
	private ImageIcon cookieIc = new ImageIcon(ci.runStr);
	private ImageIcon jumpIc = new ImageIcon(ci.jumpStr);
	private ImageIcon doubleJumpIc = new ImageIcon(ci.doubleJumpStr);
	private ImageIcon fallIc = new ImageIcon(ci.fallStr);
	private ImageIcon hitIc = new ImageIcon(ci.hitStr);
	private ImageIcon slideIc = new ImageIcon(ci.slideStr);
	//젤리 이미지
	private ImageIcon jellyIc = new ImageIcon("..//image//game_image//jelly.png");
	private ImageIcon moneyIc = new ImageIcon("..//image//game_image//money.png");
	private ImageIcon hpIc = new ImageIcon("..//image//game_image//hp.png");
	private ImageIcon effectIc = new ImageIcon("..//image//game_image//effect.png");
	private ImageIcon hpBarIc = new ImageIcon("..//image//game_image//hp_bar.png");
	//발판 이미지
	private ImageIcon field1Ic = new ImageIcon(m1.field1Str);
	private ImageIcon field2Ic = new ImageIcon(m1.field2Str);
	private ImageIcon field3Ic = new ImageIcon(m1.field3Str);
	private ImageIcon field4Ic = new ImageIcon(m1.field4Str);
	//장애물 이미지
	private ImageIcon tacleIc_1 = new ImageIcon(m1.tacle1Str);
	private ImageIcon tacleIc_2 = new ImageIcon(m1.tacle2Str);
	//리스트
	private List<Jelly> jellyList = new ArrayList<>();
	private List<Foot> fieldList = new ArrayList<>();
	private List<Tacle> tacleList = new ArrayList<>();
	private String jellyStr = "00000000000110000002200000000100000100022000000300010000000000100100100100200100200000001100010101010101010101010101010101010101010101010100000000003";
	private String fieldStr = "123412341234023412341204123412341234123412341234123410041234123412341230123412341200123412341234123412341234023412341234123410041234123412341234123012"; //150개
	private String tacleStr = "0000000000000011000000020000000100000022000000000011000000020000002000001000002000000001000000110000022200000001100000200000000000000022000000000";
	//그 외 게임에 필요한 변수
	private int runPage = 0;
	private int speedUp = 0;
	private int resultScore = 0;
	private int resultMoney = 0;
	private int gameSpeed = 5;
	private int nowField = 1500;
	private boolean downKeyOn = false;
	private boolean over = false;
	Music introMusic = new Music(m1.musicStr,true);
	
	User u1 = new User();
	Resultgame rg;
	Character c1;
	Back b1;
	Back b2;
	
	int foots, face;
	
	static int getGround(String ground, int index) {
		return Integer.parseInt(ground.substring(index, index+1));
	}

	
	//panel 클래스
	class GamePanel extends JPanel {
		//셍성자
		public GamePanel() {
			introMusic.start();
			setFocusable(true);
			c1 = new Character(cookieIc.getImage());
			
			if(c1.getImage() != slideIc.getImage()) {
				face = c1.getX() + c1.getWidth();
				foots = c1.getY() + c1.getHeight();
			} else {
				face = c1.getX() + 120;
				foots = c1.getY() + 80;
			}
			
			b1 = new Back(backIc.getImage(), 0, 0, backIc.getImage().getWidth(null), backIc.getImage().getWidth(null));
			b2 = new Back(backIc.getImage(), backIc.getImage().getWidth(null), 0, backIc.getImage().getWidth(null), backIc.getImage().getWidth(null));
			
			//jelly 리스트
			for(int i = 0; i < jellyStr.length(); i++) {
				int tempX = i * jellyIc.getImage().getWidth(null);
				
				if(getGround(jellyStr, i) == 1) { //1이면 젤리
					jellyList.add(new Jelly(jellyIc.getImage(), tempX, 500, jellyIc.getImage().getWidth(null), jellyIc.getImage().getHeight(null), 100));
				} else if(getGround(jellyStr, i) == 2) {
					jellyList.add(new Jelly(moneyIc.getImage(), tempX, 500, moneyIc.getImage().getWidth(null), moneyIc.getImage().getHeight(null), 50));
				} else if(getGround(jellyStr, i) == 3) {
					jellyList.add(new Jelly(hpIc.getImage(), tempX, 500, hpIc.getImage().getWidth(null), hpIc.getImage().getHeight(null), 100));	
				}
			}
			
			//발판 리스트
			for(int i = 0; i<fieldStr.length(); i++) {
				int tempX = i * field1Ic.getImage().getWidth(null);
				
				if(getGround(fieldStr, i) == 1) {
					fieldList.add(new Foot(field1Ic.getImage(), tempX, 750, field1Ic.getImage().getWidth(null), field1Ic.getImage().getHeight(null)));
				} else if(getGround(fieldStr, i) == 2) {
					fieldList.add(new Foot(field2Ic.getImage(), tempX, 750, field2Ic.getImage().getWidth(null), field2Ic.getImage().getHeight(null)));
				} else if(getGround(fieldStr, i) == 3) {
					fieldList.add(new Foot(field3Ic.getImage(), tempX, 750, field3Ic.getImage().getWidth(null), field3Ic.getImage().getHeight(null)));
				} else if(getGround(fieldStr, i) == 4) {
					fieldList.add(new Foot(field4Ic.getImage(), tempX, 750, field4Ic.getImage().getWidth(null), field4Ic.getImage().getHeight(null)));
				}
			}
			
			//장애물 리스트
			for(int i = 0; i<tacleStr.length(); i++) {
				int tempX = i * tacleIc_1.getImage().getWidth(null);
				
				if(getGround(tacleStr, i) == 1) {
					tacleList.add(new Tacle(tacleIc_1.getImage(), tempX, 670, tacleIc_1.getImage().getWidth(null), tacleIc_1.getImage().getHeight(null), 0));
				} else if(getGround(tacleStr, i) == 2) {
					tacleList.add(new Tacle(tacleIc_2.getImage(), tempX, 470, tacleIc_2.getImage().getWidth(null), tacleIc_2.getImage().getHeight(null), 0));
				}
			}
			
			
			//리페인트 쓰레드
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("=====================================스레드 시작===========================================");
					while(!over) {
						repaint();
						speedUp += gameSpeed;
						System.out.println("Y값 : " + c1.getY());
						System.out.println("runPage2값 : " + speedUp);
						
						
						if(c1.getY() > 750) {
							over = true;
							break;
						} else if(c1.getHp() <= 0) {
							over = true;
							break;
						} else if(speedUp >= 11500) {
							over = true;
							System.out.println("게임 성공!");
							u1.setStage(2);
							break;
						}
						
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
					System.out.println("=========================================스레드 종료=============================================");
					frame.dispose();
					introMusic.close();
					if(u1.isItem==1) {
						Resultgame rg = new Resultgame((resultScore*2), resultMoney);
						u1.isItem = 0;
					} else if(u1.isItem==2) {
						Resultgame rg = new Resultgame(resultScore, (resultMoney*2));
						u1.isItem = 0;
					} else if(u1.isItem==3){
						Resultgame rg = new Resultgame((resultScore*2), (resultMoney*2));
						u1.isItem = 0;
					} else {
						Resultgame rg = new Resultgame(resultScore, resultMoney);
					}
				}
			}).start();
			
			gamemove();
			fall();
			
			
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_SPACE && c1.getCountJump() < 2) {
						jump();
					}
					
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						downKeyOn = true;
						
						if(c1.getImage() != slideIc.getImage() && !c1.isJump() && !c1.isFall()) {
							c1.setImage(slideIc.getImage());
						}
					}
				}
				
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						downKeyOn = false;
						
						if(c1.getImage() == slideIc.getImage() && !c1.isJump() && !c1.isFall()) {
							c1.setImage(cookieIc.getImage());
						}
					}
				}
			});	
			
			
			
		} //생성자 끝

		//페인트 메서드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(b1.getImage(), b1.getX(), 0, null);
			g.drawImage(b2.getImage(), b2.getX(), 0, null);
			
			for(int i = 0; i< fieldList.size(); i++) {
				Image tempImg = fieldList.get(i).getImage();
				int tempX = fieldList.get(i).getX();
				int tempY = fieldList.get(i).getY();
				int tempWidth = fieldList.get(i).getWidth();
				int tempHeight = fieldList.get(i).getHeight();
				
				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}
			
			//젤리
			for(int i = 0; i< jellyList.size(); i++) {
				Image tempImg = jellyList.get(i).getImage();
				int tempX = jellyList.get(i).getX();
				int tempY = jellyList.get(i).getY();
				int tempWidth = jellyList.get(i).getWidth();
				int tempHeight = jellyList.get(i).getHeight();
				
				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}
			
			//장애물
			for(int i = 0; i< tacleList.size(); i++) {
				Image tempImg = tacleList.get(i).getImage();
				int tempX = tacleList.get(i).getX();
				int tempY = tacleList.get(i).getY();
				int tempWidth = tacleList.get(i).getWidth();
				int tempHeight = tacleList.get(i).getHeight();
				
				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}
			
			if(c1.getImage() != slideIc.getImage()) {
				g.drawImage(c1.getImage(), c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight(), null);
			} else {
				g.drawImage(c1.getImage(), c1.getX(), c1.getY()+40, 120, 80, null);
			}
			
			g.drawImage(hpBarIc.getImage(), 50, 40, (c1.getHp()/2), 30, null);
			
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(resultScore), 1400, 20);
			
			g.setColor(Color.RED);
			g.drawString(Integer.toString(resultScore), 1400, 40);
			
		}
	}

	
	//움직이는 메서드
	void gamemove() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(!over) {
					if(runPage > 700) { 
						c1.setHp(c1.getHp()-10);
						runPage = 0;
					} 
					
					runPage += gameSpeed;
					
					if(b1.getX() < -(b1.getWidth()-1)) { b1.setX(b1.getWidth()); } 
					if(b2.getX() < -(b2.getWidth()-1)) { b2.setX(b2.getWidth()); }
					
					b1.setX(b1.getX() - gameSpeed/3);
					b2.setX(b2.getX() - gameSpeed/3);
					
					for(int i = 0; i<fieldList.size(); i++) {
						Foot tempfield = fieldList.get(i);
					
						if(tempfield.getX() < -90) {
							fieldList.remove(tempfield);
						} else {
							tempfield.setX(tempfield.getX() - gameSpeed);
						}
					}
					
					
					for(int i = 0; i<jellyList.size(); i++) {
						Jelly tempjelly = jellyList.get(i);
					
						if(tempjelly.getX() < -90) {
							jellyList.remove(tempjelly);
						} else {
							tempjelly.setX(tempjelly.getX() - gameSpeed);
							foots = c1.getY() + c1.getHeight();
							
							//젤리 이미지라면
							if(tempjelly.getImage() == jellyIc.getImage()) {
								if(c1.getImage() != slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										resultScore += tempjelly.getScore();
										
									} else if(c1.getImage() == slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() + c1.getHeight()*1/3 &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										resultScore += tempjelly.getScore();
									}
								
							//돈 이미지라면
							} else if(tempjelly.getImage() == moneyIc.getImage()) {
								if(c1.getImage() != slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										resultMoney += tempjelly.getScore();
										
									} else if(c1.getImage() == slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() + c1.getHeight()*1/3 &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										resultMoney += tempjelly.getScore();
									}
							//생명 이미지라면
							} else if(tempjelly.getImage() == hpIc.getImage()) {
								if(c1.getImage() != slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										if(c1.getHp() < 1000) {
											c1.setHp(c1.getHp() + tempjelly.getScore());
										}
										
									} else if(c1.getImage() == slideIc.getImage() && 
										tempjelly.getX() + tempjelly.getWidth()*20/100 >= c1.getX() &&
										tempjelly.getX() + tempjelly.getWidth()*80/100 <= face &&
										tempjelly.getY() + tempjelly.getWidth()*20/100 >= c1.getY() + c1.getHeight()*1/3 &&
										tempjelly.getY() + tempjelly.getWidth()*80/100 <= foots &&
										tempjelly.getImage() != effectIc.getImage()) {
										
										tempjelly.setImage(effectIc.getImage());
										if(c1.getHp() < 1000) {
											c1.setHp(c1.getHp() + tempjelly.getScore());
										}
									}
							}
						}
					}
					
					
					for(int i = 0; i<tacleList.size(); i++) {
						Tacle temptacle = tacleList.get(i);
						
						if(temptacle.getX() < -90) {
							fieldList.remove(temptacle);
						} else {
							temptacle.setX(temptacle.getX() - gameSpeed);
							face = c1.getX() + c1.getWidth();
							foots = c1.getY() + c1.getHeight();
							
							if(!c1.isInvincible() && c1.getImage() != slideIc.getImage()
									&& temptacle.getX() + temptacle.getWidth()/2 >= c1.getX()
									&& temptacle.getX() + temptacle.getWidth()/2 <= face
									&& temptacle.getY() + temptacle.getHeight()/2 >= c1.getY()
									&& temptacle.getY() + temptacle.getHeight()/2 <= foots) {
								hit();
							} else if(!c1.isInvincible() && c1.getImage() != slideIc.getImage()
									&& temptacle.getX() + temptacle.getWidth()/2 >= c1.getX()
									&& temptacle.getX() + temptacle.getWidth()/2 <= face
									&& temptacle.getY() <= c1.getY()
									&& temptacle.getY() + temptacle.getHeight()*95/100 > c1.getY()) {
								hit();
							}else if(!c1.isInvincible() && c1.getImage() == slideIc.getImage()
									&& temptacle.getX() + temptacle.getWidth()/2 >= c1.getX()
									&& temptacle.getX() + temptacle.getWidth()/2 <= face
									&& temptacle.getY() + temptacle.getHeight()/2 >= c1.getY() + c1.getHeight()*2/3
									&& temptacle.getY() + temptacle.getHeight()/2 <= foots) {
								hit();
							} else if(!c1.isInvincible() && c1.getImage() == slideIc.getImage()
									&& temptacle.getX() + temptacle.getWidth()/2 >= c1.getX()
									&& temptacle.getX() + temptacle.getWidth()/2 <= face
									&& temptacle.getY() < c1.getY()
									&& temptacle.getY() + temptacle.getHeight()*95/100 > c1.getY() + c1.getHeight()*2/3) {
								hit();
							}
						}
					}
					
					int tempField;
					int tempNowField;
					
					if(c1.isInvincible()) {
						tempNowField = 750;
					} else {
						tempNowField = 1500;
					}
					
					for(int i = 0; i<fieldList.size(); i++) {
						int tempX = fieldList.get(i).getX();
						                  
						if(tempX > c1.getX()-60 && tempX <= face) {
							tempField = fieldList.get(i).getY();
							foots = c1.getY() + c1.getHeight();
							
							if(tempField < tempNowField && tempField >= foots) {
								tempNowField = tempField;
							}
						}
					}
					
					nowField = tempNowField;
				
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	
	//맞는 메서드
	void hit() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				c1.setInvincible(true);
				System.out.println("무적상태 시작");
				c1.setHp(c1.getHp() - 200);
				c1.setImage(hitIc.getImage());
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(c1.getImage() == hitIc.getImage()) {
					c1.setImage(cookieIc.getImage());
				}
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				c1.setInvincible(false);
				System.out.println("무적상태 종료");
			}
			
		}).start();
	}
	
	
	//떨어지는 메서드
	void fall() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(!over) {
					foots = c1.getY() + c1.getHeight();
					
					if(foots < nowField && !c1.isJump() && !c1.isFall()) { //캐릭터가 발판보다 위에 있고, 점프중이 아니고, 낙하중이 아닐 때
						c1.setFall(true);
						System.out.println("낙하");
						
						if(c1.getCountJump() == 2) { //더블점프 후 떨어지는거면 이미지 바꾸기
							c1.setImage(fallIc.getImage());
						}
						
						long t1 = Util.getTime();
						long t2;
						int set = 1;
						
						while(foots < nowField) { //발판보다 캐릭터가 위에 있을 때~발이 발판에 닿을때까지
							t2 = Util.getTime() - t1;
							int fallY = set + (int) ((t2)/40);
							foots = c1.getY() + c1.getHeight();
							
							if(foots + fallY >= nowField) {
								fallY = nowField - foots;
							}
							
							c1.setY(c1.getY()+fallY);
							
							if(c1.isJump()) {
								break;
							}
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						c1.setFall(false);
						System.out.println("낙하끝");
						
						if(downKeyOn && !c1.isJump() && !c1.isFall() && c1.getImage() != slideIc.getImage()) { //캐릭터 이미지 바꾸기
							c1.setImage(cookieIc.getImage());
						} else if(!downKeyOn && !c1.isJump() && !c1.isFall() && c1.getImage() != cookieIc.getImage()) {
							c1.setImage(cookieIc.getImage());
						}
						
						if(!c1.isJump()) {c1.setCountJump(0);}
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	//점프하는 메서드
	void jump() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				c1.setCountJump(c1.getCountJump()+1);
				int nowJump = c1.getCountJump();
				c1.setJump(true);
				
				if(c1.getCountJump() == 1) {
					System.out.println("점프시작");
					c1.setImage(jumpIc.getImage());
				} else if(c1.getCountJump() == 2) {
					System.out.println("더블점프");
					c1.setImage(doubleJumpIc.getImage());
				}
				
				long t1 = Util.getTime();
				long t2;
				int set = 8;
				int jumpY = 1;
				
				while(jumpY >= 0) {
					t2 = Util.getTime() - t1;
					jumpY = set - (int) ((t2)/40);
					c1.setY(c1.getY()-jumpY);
					System.out.println("점프 Y 값 : " + c1.getY());
					
					if(nowJump != c1.getCountJump()) {
						break;
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(nowJump == c1.getCountJump()) {
					c1.setJump(false);
				}
				System.out.println("점프 끝");
			}
		}).start();
	}
	

	//메인
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stage2 window = new Stage2();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//생성자
	public Stage2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new GamePanel();
		panel.setBounds(0, 0, 1478, 794);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(100,100);
		frame.setResizable(false);
	}
	
}