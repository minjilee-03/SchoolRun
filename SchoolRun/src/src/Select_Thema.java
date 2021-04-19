package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.MapInfo;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//캐릭터의 학년을 고르는 창

public class Select_Thema extends JFrame {
	public static String back;
	public static String field1;
	public static String field2;
	public static String field3;
	public static String field4;
	public static String tacle;
	public static String tacle2;
	MapInfo m1 = new MapInfo();
	Music introMusic = new Music("..//music//CHARACTER.MP3", true);
	
	public Select_Thema() {
		introMusic.start();
		JPanel p = new JPanel();
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		//버튼 정의
		JButton stage1btn = new JButton("");
		JButton stage2btn = new JButton("");
		JButton stage3btn = new JButton("");
		JButton christmasbtn = new JButton("");
		JButton halloweenbtn = new JButton("");
		
		stage1btn.setIcon(new ImageIcon("..//image//btn_image//stage1_thema.jpg"));
		stage2btn.setIcon(new ImageIcon("..//image//btn_image//stage2_thema.jpg"));
		stage3btn.setIcon(new ImageIcon("..//image//btn_image//stage3_thema.jpg"));
		christmasbtn.setIcon(new ImageIcon("..//image//btn_image//christmas_thema.jpg"));
		halloweenbtn.setIcon(new ImageIcon("..//image//btn_image//hw_thema.jpg "));
		
		//버튼 판넬에 붙이기
		getContentPane().add(p);
		p.setLayout(null);
		p.add(backbtn);
		p.add(stage1btn);
		p.add(stage2btn);
		p.add(stage3btn);
		p.add(christmasbtn);
		p.add(halloweenbtn);
		
		stage1btn.setBorderPainted(false);
		stage2btn.setBorderPainted(false);
		stage3btn.setBorderPainted(false);
		backbtn.setBorderPainted(false);
		christmasbtn.setBorderPainted(false);
		halloweenbtn.setBorderPainted(false);
		
		//버튼 위치
		backbtn.setBounds(0, 0, 196, 57);
		stage1btn.setBounds(200, 140, 250, 250);
		stage2btn.setBounds(575, 140, 250, 250);
		stage3btn.setBounds(950, 140, 250, 250);
		christmasbtn.setBounds(400, 480, 250, 250);
		halloweenbtn.setBounds(775, 480, 250, 250);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//back_image//Select_Characte_back.jpg"));
		lblNewLabel.setBounds(-12, 0, 1490, 806);
		p.add(lblNewLabel);
		
		setTitle("SchoolRun");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x를 누르면 닫히게 한다는 것(SWING은 이게 없어도 먹힘)
		setSize(1500,850);
		setVisible(true);
		
		
		//버튼 액션
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new SelectCT();
			}
		});
		
		//스테이지 1
		stage1btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String backImg = "..//image//game_image//stage1_back.jpg";
				String fieldImg = "..//image//game_image//book_field.png";
				String field2Img = "..//image//game_image//book_field2.png";
				String field3Img = "..//image//game_image//book_field3.png";
				String field4Img = "..//image//game_image//book_field4.png";
				String tacle1Img = "..//image//game_image//tacle01.png";
				String tacle2Img = "..//image//game_image//tacle02.png";
				String musicStr = "..//music//STAGE1.MP3";
				
				m1.check = 1;
				m1.setMap(backImg, fieldImg, field2Img, field3Img, field4Img, tacle1Img, tacle2Img, musicStr);
				ThemaSetResult ta = new ThemaSetResult();
			}	
		});
		
		//스테이지 2
		stage2btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String backImg = "..//image//game_image//stage2_back.jpg";
				String fieldImg = "..//image//game_image//ball_field.png";
				String field2Img = "..//image//game_image//ball_field2.png";
				String field3Img = "..//image//game_image//ball_field3.png";
				String field4Img = "..//image//game_image//ball_field4.png";
				String tacle1Img = "..//image//game_image//tacle03.png";
				String tacle2Img = "..//image//game_image//tacle04.png";
				String musicStr = "..//music//STAGE2.MP3";
					
				m1.check = 1;
				m1.setMap(backImg, fieldImg, field2Img, field3Img, field4Img, tacle1Img, tacle2Img, musicStr);
				ThemaSetResult ta = new ThemaSetResult();
			}	
		});
		
		//스테이지 3
		stage3btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String backImg = "..//image//game_image//stage3_back.jpg";
				String fieldImg = "..//image//game_image//cloud_field.png";
				String field2Img = "..//image//game_image//cloud_field2.png";
				String field3Img = "..//image//game_image//cloud_field3.png";
				String field4Img = "..//image//game_image//cloud_field4.png";
				String tacle1Img = "..//image//game_image//tacle_ring.png";
				String tacle2Img = "..//image//game_image//tacle02_stick.png";
				String musicStr = "..//music//STAGE3.MP3";
	
				m1.check = 1;
				m1.setMap(backImg, fieldImg, field2Img, field3Img, field4Img, tacle1Img, tacle2Img, musicStr);
				ThemaSetResult ta = new ThemaSetResult();
			}	
		});
		
		//크리스마스 
		christmasbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String backImg = "..//image//game_image//Christmas_back.jpg";
				String fieldImg = "..//image//game_image//santa_field2.png";
				String field2Img = "..//image//game_image//santa_field3.png";
				String field3Img = "..//image//game_image//santa_field4.png";
				String field4Img = "..//image//game_image//santa_field5.png";
				String tacle1Img = "..//image//game_image//tacle_07.png";
				String tacle2Img = "..//image//game_image//tacle_08.png";
				String musicStr = "..//music//CHRISTMAS.MP3";	

				m1.check = 1;
				m1.setMap(backImg, fieldImg, field2Img, field3Img, field4Img, tacle1Img, tacle2Img, musicStr);
				ThemaSetResult ta = new ThemaSetResult();
			}	
		});
		
		//할로윈
		halloweenbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String backImg = "..//image//game_image//Halloween_back.jpg";
				String fieldImg = "..//image//game_image//h_field.png";
				String field2Img = "..//image//game_image//h_field2.png";
				String field3Img = "..//image//game_image//h_field3.png";
				String field4Img = "..//image//game_image//h_field4.png";
				String tacle1Img = "..//image//game_image//tacle_05.png";
				String tacle2Img = "..//image//game_image//tacle_06.png";
				String musicStr = "..//music//HALLOWEEN.MP3";
				
				m1.check = 1;
				m1.setMap(backImg, fieldImg, field2Img, field3Img, field4Img, tacle1Img, tacle2Img, musicStr);
				ThemaSetResult ta = new ThemaSetResult();
			}	
		});
	}

	public static void main(String args[]) {
		new Select_Thema();
	}
}