package src;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//�׸�, ĳ���� �� ������ ���� �����ϴ� â

public class SelectCT extends JFrame{
	Music introMusic = new Music("..//music//CHARACTER.MP3", true );
	public SelectCT() {
		introMusic.start();
		JPanel p = new JPanel();
		JButton backbtn = new JButton(""); //����ȭ������ ���ư��� ��ư
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); 
				Main_lobi m1 = new Main_lobi();
			}
		});
		JButton c_btn = new JButton("ĳ���� ����"); //ĳ���� �г� ���� â���� ���� ��ư
		c_btn.setIcon(new ImageIcon("..//image//btn_image//character_btn.jpg"));
		c_btn.setBorderPainted(false);
		JButton t_btn = new JButton("�׸� ����"); //�׸� ���� â���� ���� ��ư
		t_btn.setIcon(new ImageIcon("..//image//btn_image//Tm_btn.jpg"));
		t_btn.setBorderPainted(false);
		getContentPane().add(p); //�����ӿ� �ǳ� ���̱�
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
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x�� ������ ������ �Ѵٴ� ��(SWING�� �̰� ��� ����)
		setSize(1500,850);
		setVisible(true);
		
		c_btn.addActionListener( new ActionListener() { //c_btn�� ������ �����ϴ� �޼���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); //�� â�� ������ �ʰ��ϰ�
				new Select_Character(); //SelectGradeâ�� ���̰� �Ѵ�
			
			}
		});
	
		t_btn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false); //�� â�� ������ �ʰ��ϰ�
				new Select_Thema();
			}
		});
	}
	
	public static void main(String[] args) {
		new SelectCT();
	}

}