package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//캐릭터의 학년을 고르는 창

public class Select_Stage extends JFrame {
	User u1 = new User();
	Music introMusic = new Music("..//music//CHARACTER.MP3", true); 
	
	public Select_Stage() {
		introMusic.start();
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 250, 205));
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		JButton stage1btn = new JButton("");
		stage1btn.setIcon(new ImageIcon("..//image//btn_image//select_stage1.jpg"));
		JButton stage2btn = new JButton("");
		stage2btn.setIcon(new ImageIcon("..//image//btn_image//select_stage2.jpg"));
		JButton stage3btn = new JButton("");
		stage3btn.setIcon(new ImageIcon("..//image//btn_image//select_stage3.jpg"));
		getContentPane().add(p); //프레임에 판넬 붙이기
		p.setLayout(null);
		p.add(backbtn);
		p.add(stage1btn);
		p.add(stage2btn);
		p.add(stage3btn);
		
		backbtn.setBounds(0, 0, 196, 57);
		stage1btn.setBounds(150, 200, 300, 400);
		stage2btn.setBounds(550, 200, 300, 400);
		stage3btn.setBounds(950, 200, 300, 400);
		
		stage1btn.setBorderPainted(false);
		stage2btn.setBorderPainted(false);
		stage3btn.setBorderPainted(false);
		backbtn.setBorderPainted(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//grade_back.jpg"));
		lblNewLabel.setBounds(-12, -46, 1500, 850);
		p.add(lblNewLabel);
		
		setTitle("SchoolRun");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x를 누르면 닫히게 한다는 것(SWING은 이게 없어도 먹힘)
		setSize(1500,850);
		setVisible(true);
		
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Main_lobi();
			}
		});
		
		stage1btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 1;
				boolean check = u1.setplayStage(num);
				StageSetResult ss = new StageSetResult(check);
			}
		});
		
		stage2btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 2;
				boolean check = u1.setplayStage(num);
				StageSetResult ss = new StageSetResult(check);
			}
		});
		
		stage3btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 3;
				boolean check = u1.setplayStage(num);
				StageSetResult ss = new StageSetResult(check);
			}
		});
	}
}
