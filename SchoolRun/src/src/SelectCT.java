package src;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//테마, 캐릭터 중 무엇을 고를지 선택하는 창

public class SelectCT extends JFrame{
	Music introMusic = new Music("..//music//CHARACTER.MP3", true );
	public SelectCT() {
		introMusic.start();
		JPanel p = new JPanel();
		JButton backbtn = new JButton(""); //메인화면으로 돌아가는 버튼
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); 
				Main_lobi m1 = new Main_lobi();
			}
		});
		JButton c_btn = new JButton("캐릭터 고르기"); //캐릭터 학년 고르는 창으로 가는 버튼
		c_btn.setIcon(new ImageIcon("..//image//btn_image//character_btn.jpg"));
		c_btn.setBorderPainted(false);
		JButton t_btn = new JButton("테마 고르기"); //테마 고르는 창으로 가는 버튼
		t_btn.setIcon(new ImageIcon("..//image//btn_image//Tm_btn.jpg"));
		t_btn.setBorderPainted(false);
		getContentPane().add(p); //프레임에 판넬 붙이기
		p.setLayout(null);
		p.add(backbtn);
		p.add(c_btn);
		p.add(t_btn);
		
		c_btn.setBorderPainted(false);
		t_btn.setBorderPainted(false);
		backbtn.setBorderPainted(false);
		
		backbtn.setBounds(0, 0, 196, 52);
		c_btn.setBounds(254, 163, 380, 475);
		t_btn.setBounds(799, 163, 380, 475);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//back_image//Select_Characte_back.jpg"));
		lblNewLabel.setBounds(-12, 0, 1490, 806);
		p.add(lblNewLabel);
		
		setTitle("SchoolRun~!");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x를 누르면 닫히게 한다는 것(SWING은 이게 없어도 먹힘)
		setSize(1500,850);
		setVisible(true);
		
		c_btn.addActionListener( new ActionListener() { //c_btn을 누르면 동작하는 메서드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); //이 창은 보이지 않게하고
				new Select_Character(); //SelectGrade창을 보이게 한다
			
			}
		});
	
		t_btn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); //이 창은 보이지 않게하고
				new Select_Thema();
			}
		});
	}
	
	public static void main(String[] args) {
		new SelectCT();
	}

}