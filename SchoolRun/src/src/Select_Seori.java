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
//ĳ������ �г��� ���� â

public class Select_Seori extends JFrame {
	CharacterInfo c1= new CharacterInfo(); //ĳ���� �̹��� �� �����ϴ� Ŭ����
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
		getContentPane().add(p); //�����ӿ� �ǳ� ���̱�
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

		
		//1�г� ĳ���� ���� ��ư
		g1.addActionListener( new ActionListener() { //c_btn�� ������ �����ϴ� �޼���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_1.gif"; //�⺻
				String cr2 = "..//image//game_image//seori_1_jump.png"; //����
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //��������
				String cr4 = "..//image//game_image//seori_1_fall.png"; //����
				String cr5 = "..//image//game_image//seori_1_slide.png"; //�����̵�
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
				
			}
		});
		//2�г� ĳ���� ���� ��ư
		g2.addActionListener( new ActionListener() { //c_btn�� ������ �����ϴ� �޼���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_2.gif"; //�⺻
				String cr2 = "..//image//game_image//seori_1_jump.png"; //����
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //��������
				String cr4 = "..//image//game_image//seori_1_fall.png"; //����
				String cr5 = "..//image//game_image//seori_1_slide.png"; //�����̵�
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
			}
		});
		//3�г� ĳ���� ���� ��ư
		g3.addActionListener( new ActionListener() { //c_btn�� ������ �����ϴ� �޼���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cr1 = "..//image//game_image//seori_3.gif"; //�⺻
				String cr2 = "..//image//game_image//seori_1_jump.png"; //����
				String cr3 = "..//image//game_image//seori_1_jump2.gif"; //��������
				String cr4 = "..//image//game_image//seori_1_fall.png"; //����
				String cr5 = "..//image//game_image//seori_1_slide.png"; //�����̵�
			
				c1.setCharacter(cr1, cr2, cr3, cr4, cr5);
				CharacterSetResult sr = new CharacterSetResult();
			}
		});
		
		
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
		
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Character(); //ĳ����, �׸� �߿� ������ ���� ����
			}
		});
	}
}