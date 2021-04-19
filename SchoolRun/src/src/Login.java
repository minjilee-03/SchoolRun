package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import java.awt.Font;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener{


	private JTextField id;
	private JLabel result;
	private JPasswordField pwd;
	private JButton button;
	private JButton button_1;
	private JButton htp;
	private JLabel lblNewLabel_2;
	JFrame frame;
	private JButton btn;
	private JLabel label;

	
	User u1 = new User(); // �α��� Ŭ����
	
	Music introMusic = new Music("..//music//LOGIN_BGM.MP3", true);//����

	public Login() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 850);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\uC544\uC774\uB514(*\uBAA8\uB4E0 \uC544\uC774\uB514\uB294 \uB2C9\uB124\uC784)");
		lblNewLabel.setBounds(530, 370, 316, 46);
		frame.getContentPane().add(lblNewLabel);

		id = new JTextField(); // ���̵� �ؽ�Ʈ�ʵ�
		id.setFont(new Font("�޸յձ�������", Font.PLAIN, 30));
		id.setBounds(530, 411, 286, 57);
		frame.getContentPane().add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("��й�ȣ"); // ��й�ȣ �ؽ�Ʈ�ʵ�
		lblNewLabel_1.setBounds(530, 468, 147, 21);
		frame.getContentPane().add(lblNewLabel_1);

		JButton login = new JButton(""); // �α��� ��ư
		login.setIcon(new ImageIcon("..//image//btn_image//login.jpg"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u_id = id.getText();
				String u_pw = String.valueOf(pwd.getPassword());

				if (u1.login(u_id, u_pw)==true) {
					introMusic.close();
					frame.setVisible(false);
					Main_lobi mb = new Main_lobi();
					mb.setVisible(true);
				} else {
					result.setText("���̵� �Ǵ� ��� ��ȣ�� ��ġ���� �ʽ��ϴ�.");
					result.setForeground(Color.red);
				}
			}
		});
		
		login.setBounds(831, 411, 136, 136);
		frame.getContentPane().add(login);

		pwd = new JPasswordField(); // ��й�ȣ
		pwd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		pwd.setBounds(530, 490, 286, 57);
		frame.getContentPane().add(pwd);

		button = new JButton("");
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon("..//image//btn_image//new_count.jpg"));
		button.setBounds(530, 562, 136, 34);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Join j = new Join();
				j.main(null);
			}
		});
		

		button_1 = new JButton(""); // �Խ�Ʈ���
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				frame.setVisible(false);
				Main_lobi mb = new Main_lobi();
				mb.setVisible(true);
			}
		});
		
		button_1.setIcon(new ImageIcon("..//image//btn_image//guest_bt.jpg"));
		button_1.setBounds(683, 562, 136, 34);
		frame.getContentPane().add(button_1);
		
		htp = new JButton("");
		htp.setFocusPainted(false);
		htp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				frame.setVisible(false);
				HowToPlay htp = new HowToPlay();
				htp.setVisible(true);
				
			}
		});
		htp.setIcon(new ImageIcon("..//image//btn_image//htp_btn.jpg"));
		htp.setBorderPainted(false);
		htp.setBounds(830, 562, 136, 34);
		frame.getContentPane().add(htp);

		result = new JLabel("\t\t\t\t\uB85C\uADF8\uC778\uC744 \uD574\uC8FC\uC138\uC694!"); // �α��ΰ��
		result.setForeground(Color.WHITE);
		result.setFont(new Font("�޸յձ�������", Font.BOLD, 13));
		result.setBounds(530, 611, 361, 34);
		frame.getContentPane().add(result);
		result.setOpaque(false);

		label = new JLabel("");
		label.setIcon(new ImageIcon("..//image//back_image//check_login_im.jpg"));
		label.setOpaque(true);
		label.setForeground(Color.RED);
		label.setFont(new Font("���� ���", Font.BOLD, 14));
		label.setBounds(530, 611, 361, 34);
		frame.getContentPane().add(label);

		lblNewLabel_2 = new JLabel(""); // ���
		lblNewLabel_2.setIcon(new ImageIcon("..//image//back_image//start_background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1478, 794);
		frame.getContentPane().add(lblNewLabel_2);
		
		btn = new JButton();
		btn.setOpaque(false);
		getContentPane().add(btn);
		btn.addActionListener(this);
		btn.doClick();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocation(100,100);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			introMusic.start();
		}
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login window = new Login();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
