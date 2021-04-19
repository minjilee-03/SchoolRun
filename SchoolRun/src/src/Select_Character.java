package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//ĳ������ �г��� ���� â

public class Select_Character extends JFrame {
	Music introMusic = new Music("..//music//CHARACTER.MP3",true);
	
	public Select_Character() {
		introMusic.start();
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 250, 205));
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		JButton bongbtn = new JButton("");
		bongbtn.setIcon(new ImageIcon("..//image//game_image//bong_select.gif"));
		JButton seoribtn = new JButton("");
		seoribtn.setIcon(new ImageIcon("..//image//game_image//seori_select.gif"));
		JButton naribtn = new JButton("");
		naribtn.setIcon(new ImageIcon("..//image//game_image//nari_select.gif"));
		getContentPane().add(p); //�����ӿ� �ǳ� ���̱�
		p.setLayout(null);
		p.add(backbtn);
		p.add(bongbtn);
		p.add(seoribtn);
		p.add(naribtn);
		
		backbtn.setBorderPainted(false);
		bongbtn.setBorderPainted(false);
		seoribtn.setBorderPainted(false);
		naribtn.setBorderPainted(false);
		
		backbtn.setBounds(0, 0, 196, 57);
		bongbtn.setBounds(150, 200, 300, 400);
		seoribtn.setBounds(550, 200, 300, 400);
		naribtn.setBounds(950, 200, 300, 400);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//back_image//Select_Characte_back.jpg"));
		lblNewLabel.setBounds(-12, 0, 1490, 806);
		p.add(lblNewLabel);
		
		setTitle("SchoolRun");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x�� ������ ������ �Ѵٴ� ��(SWING�� �̰� ��� ����)
		setSize(1500,850);
		setVisible(true);
		setLocation(100,100);
		setResizable(false);
		bongbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Bong(); //���� 1,2,3 �ϳ� �� ���� Ŭ����
			}
		});
		
		seoribtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Seori(); //���� 1,2,3 �ϳ� �� ���� Ŭ����
			}
		});
		
		naribtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Nari(); //���� 1,2,3 �ϳ� �� ���� Ŭ����
			}
		});
		
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new SelectCT();
			}
			
		});
		
	}
}