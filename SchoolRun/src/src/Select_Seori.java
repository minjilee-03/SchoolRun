package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.CharacterInfo;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//캐릭터의 학년을 고르는 창

public class Select_Seori extends JFrame {
	CharacterInfo c1= new CharacterInfo(); //캐릭터 이미지 값 저장하는 클래스
	Music introMusic = new Music("..//music//CHARACTER.MP3",true);
	
	public Select_Seori() {
		introMusic.start();
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 250, 205));
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		JButton g1 = new JButton("");
		g1.setIcon(new ImageIcon("..//image//game_image//seori_1_select.png"));
		JButton g2 = new JButton("");
		g2.setIcon(new ImageIcon("..//image//game_image//seori_2_select.png"));
		JButton g3 = new JButton("");
		g3.setIcon(new ImageIcon("..//image//game_image//seori_3_select.png"));
		getContentPane().add(p); //프레임에 판넬 붙이기
		p.setLayout(null);
		p.add(backbtn);
		p.add(g1);
		p.add(g2);
		p.add(g3);
		
		backbtn.setBounds(0, 0, 196, 57);
		g1.setBounds(150, 200, 300, 400);
		g2.setBounds(550, 200, 300, 400);
		g3.setBounds(950, 200, 300, 400);
		
		g1.setBorderPainted(false);
		g2.setBorderPainted(false);
		g3.setBorderPainted(false);
		backbtn.setBorderPainted(false);

		
		//1학년 캐릭터 선택 버튼
		g1.addActionListener( new ActionListener() { //c_btn을 누르면 동작하는 메서드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_1.gif"; //기본
				String cr2 = "..//image//game_image//seori_1_jump.png"; //점프
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //더블점프
				String cr4 = "..//image//game_image//seori_1_fall.png"; //낙하
				String cr5 = "..//image//game_image//seori_1_slide.png"; //슬라이드
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
				
			}
		});
		//2학년 캐릭터 선택 버튼
		g2.addActionListener( new ActionListener() { //c_btn을 누르면 동작하는 메서드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_2.gif"; //기본
				String cr2 = "..//image//game_image//seori_1_jump.png"; //점프
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //더블점프
				String cr4 = "..//image//game_image//seori_1_fall.png"; //낙하
				String cr5 = "..//image//game_image//seori_1_slide.png"; //슬라이드
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
			}
		});
		//3학년 캐릭터 선택 버튼
		g3.addActionListener( new ActionListener() { //c_btn을 누르면 동작하는 메서드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_3.gif"; //기본
				String cr2 = "..//image//game_image//seori_1_jump.png"; //점프
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //더블점프
				String cr4 = "..//image//game_image//seori_1_fall.png"; //낙하
				String cr5 = "..//image//game_image//seori_1_slide.png"; //슬라이드
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//back_image//Select_Characte_back.jpg"));
		lblNewLabel.setBounds(-12, 0, 1490, 806);
		p.add(lblNewLabel);
		
		setTitle("SchoolRun");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x를 누르면 닫히게 한다는 것(SWING은 이게 없어도 먹힘)
		setSize(1500,850);
		setVisible(true);
		setLocation(100,100);
		setResizable(false);
		
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Character(); //캐릭터, 테마 중에 무엇을 고를지 선택
			}
		});
	}
}