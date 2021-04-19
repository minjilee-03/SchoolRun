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

class StageSetResult extends JFrame{
	JPanel p;
	JLabel result;
	JButton okbtn;
	CharacterInfo info = new CharacterInfo();
	User u1 = new User();
	boolean check;
	
	public  StageSetResult(boolean c) {
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
		this.check = c;
		

		if (this.check == true) {
			if (u1.play_stage == 1) {
				result = new JLabel("스테이지 1입니다.");
			} else if (u1.play_stage == 2) {
				result = new JLabel("스테이지 2입니다.");
			} else if (u1.play_stage == 3) {
				result = new JLabel("스테이지 3입니다.");
			}
		} else {
			result = new JLabel("레벨이 안됨");
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