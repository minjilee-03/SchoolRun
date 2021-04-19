package src;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.CharacterInfo;
import Game.Stage1;
import Game.Stage2;
import Game.Stage3;

//테마 고르는창
public class SelectItem extends JFrame {
	User u1 = new User();
	Music introMusic = new Music("..//music//ITEM_BGM.MP3", true);//뮤직
	CharacterInfo info = new CharacterInfo();
	JLabel character;
	
	public SelectItem() {
		introMusic.start();
		
		JPanel p = new JPanel();
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		getContentPane().add(p);
		p.setLayout(null);
		p.add(backbtn);
		backbtn.setBounds(0, 743, 196, 51);
		backbtn.setBorderPainted(false);
		
		if(info.runStr.equals("..//image//game_image//bong_1.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//bong1_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//bong_2.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//bong2_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//bong_3.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//bong3_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//seori_1.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//seori1_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//seori_2.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//seori2_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//seori_3.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//seori3_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//nari_1.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//nari1_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//nari_2.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//nari2_img.gif"));
		} else if(info.runStr.equals("..//image//game_image//nari_3.gif")) {
			character = new JLabel(new ImageIcon("..//image//game_image//nari3_img.gif"));
		}
	
		character.setBounds(165, 250, 400, 450);
		p.setLayout(null);
		p.add(character);
		
		//돈 두배 아이템 버튼
		JButton doubleMoney = new JButton("돈 두배");
		doubleMoney.setIcon(new ImageIcon("..//image//game_image//coin_double.png"));
		doubleMoney.setBorderPainted(false);
		doubleMoney.setContentAreaFilled(false);
		//doubleMoney.setDisabledIcon(new ImageIcon());
		doubleMoney.setBounds(750, 235, 250, 250);
		p.add(doubleMoney);
		doubleMoney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				u1.buyDoubleMoneyItem();
				System.out.println("아이템 isItem : " + u1.isItem);
			}
		});
		
		//점수 두배 아이템 버튼
		JButton doubleScore = new JButton("점수 두배");
		doubleScore.setIcon(new ImageIcon("..//image//game_image//score_double.png"));
		doubleScore.setContentAreaFilled(false);
		doubleScore.setBorderPainted(false);
		//doubleMoney.setDisabledIcon(new ImageIcon());
		doubleScore.setBounds(1050, 235, 250, 250);
		p.add(doubleScore);
		doubleScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				u1.buyDoubleScoreItem();
				System.out.println("아이템 isItem : " + u1.isItem);
			}
		});
		
		
		JButton startbtn = new JButton("");
		startbtn.setBorderPainted(false);
		startbtn.setIcon(new ImageIcon("..//image//btn_image//start_game.jpg"));
		startbtn.setBounds(696, 542, 662, 198);
		p.add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				introMusic.close();
				if(u1.play_stage==1) {
					Stage1 s1 = new Stage1();
				} else if(u1.play_stage==2) {
					Stage2 s2 = new Stage2();
				} else if(u1.play_stage==3) {
					Stage3 s3 = new Stage3();
				} else { //아무것도 안고르면 그냥 자기 레벨에 맞는 스테이지 실행
					Stage1 s1 = new Stage1();
				}
			}
		});
		
		JLabel back_label = new JLabel("");
		back_label.setIcon(new ImageIcon("..//image//back_image//Item_back.jpg"));
		back_label.setBounds(0, 0, 1478, 794);
		p.add(back_label);
	
		setTitle("SchoolRun!");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x를 누르면 닫히게 한다는 것(SWING은 이게 없어도 먹힘)
		setSize(1500,850);
		setVisible(true);
		
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				introMusic.close();
				Main_lobi ms = new Main_lobi(); //캐릭터, 테마 중에 무엇을 고를지 선택
			}
		});	
	}
	
	public static void main(String args[]) {
		new SelectItem();
	}
}