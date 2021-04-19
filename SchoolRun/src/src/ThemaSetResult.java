package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.CharacterInfo;
import Game.MapInfo;

class ThemaSetResult extends JFrame{
	JPanel p;
	JLabel result;
	JButton okbtn;
	MapInfo info = new MapInfo();
	private JLabel lblNewLabel;

	
	public  ThemaSetResult() {
		p = new JPanel();
		p.setBounds(0, 0, 394, 30);
		okbtn = new JButton("");
		okbtn.setBorderPainted(false);
		okbtn.setBounds(276, 0, 69, 30);
		okbtn.setIcon(new ImageIcon("..\\image\\btn_image\\select_check.jpg"));
		okbtn.setPreferredSize(new Dimension(69, 30));
		okbtn.setBorderPainted(false);
		result = new JLabel(""); // 배경
		result.setBounds(180, 9, 0, 0);
		p.setBackground(new Color(255, 250, 205));
		
		if(info.backStr.equals("..//image//game_image//stage1_back.jpg")){
			result = new JLabel("스테이지 1 테마입니다.");
		} else if(info.backStr.equals("..//image//game_image//stage2_back.jpg")) {
			result = new JLabel("스테이지 2 테마입니다.");
		} else if(info.backStr.equals("..//image//game_image//stage3_back.jpg")) {
			result = new JLabel("스테이지 3 테마입니다.");
		} else if(info.backStr.equals("..//image//game_image//Christmas_back.jpg")) {
			result = new JLabel("크리스마스 테마입니다.");
		} else if(info.backStr.equals("..//image//game_image//Halloween_back.jpg")) {
			result = new JLabel("할로윈 테마입니다.");
		} 
	
		
		p.add(result);
		p.add(okbtn);
		
		
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		

		setResizable(false);
		getContentPane().add(p);
		setSize(400, 70);
		setLocation(570,550);
		setVisible(true);
		
	}
}