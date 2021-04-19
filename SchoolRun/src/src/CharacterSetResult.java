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

class CharacterSetResult extends JFrame{
	JPanel p;
	JLabel result;
	JButton okbtn;
	CharacterInfo info = new CharacterInfo();
	private JLabel label;
	
	public CharacterSetResult() {
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
		
		if(info.runStr.equals("..//image//game_image//bong_1.gif")) {
			result = new JLabel("봉식이 1학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//bong_2.gif")) {
			result = new JLabel("봉식이 2학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//bong_3.gif")) {
			result = new JLabel("봉식이 3학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//seori_1.gif")) {
			result = new JLabel("서리 1학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//seori_2.gif")) {
			result = new JLabel("서리 2학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//seori_3.gif")) {
			result = new JLabel("서리 3학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//nari_1.gif")) {
			result = new JLabel("나리 1학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//nari_2.gif")) {
			result = new JLabel("나리 2학년 캐릭터를 선택했습니다.");
		} else if(info.runStr.equals("..//image//game_image//nari_3.gif")) {
			result = new JLabel("나리 3학년 캐릭터를 선택했습니다.");
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