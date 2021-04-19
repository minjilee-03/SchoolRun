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

public class HowToPlay extends JFrame implements ActionListener{
	JFrame frame;
	User u1 = new User(); // 로그인 클래스
	private JButton btn;
	Music introMusic = new Music("..//music//HOWTOPLAY_BGM.MP3", true);//뮤직

	public HowToPlay() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton closebtn = new JButton("");
		closebtn.setBorderPainted(false);
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				frame.setVisible(false);
				frame.setResizable(false);
				frame.setLocation(100,100);
				Login l1 = new Login();
				l1.setVisible(true);
					
			}
		});
		closebtn.setIcon(new ImageIcon("..//image//btn_image//close.jpg"));
		closebtn.setBounds(1435, 0, 43, 43);
		frame.getContentPane().add(closebtn);
		
		btn = new JButton();
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setBounds(0, 0, 9, 9);
		getContentPane().add(btn);
		btn.addActionListener(this);
		btn.doClick();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..//image//back_image//howtoplay_back.jpg"));
		lblNewLabel.setBounds(0, 0, 1478, 794);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		frame.setLocation(100,100);
		frame.setResizable(false);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			introMusic.start();
		}
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						HowToPlay window = new HowToPlay();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}