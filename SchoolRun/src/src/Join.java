package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Join extends JFrame {
	//��������
	private JFrame frame;
	private JTextField textID;
	private JButton checkIDbtn;
	private JTextField textPW;
	private JTextField textPW_2;
	private JButton joinbtn;
	private JLabel label_PW;
	private JLabel label_PW2;
	private JButton closeBtn;
	private JLabel backImg;
	private JLabel message;
	User u1 = new User();
	int checkId = 0; //0�̸� �ߺ� Ȯ�� ����, 1�̸� ��� ����, 2�� �ߺ�
	//Music introMusic = new Music("..\\music\\LOGIN_BGM.MP3",true);//����s

	//���θ޼���
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join window = new Join();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//������
	public Join() {
		initialize();
	}
	//GUI ����޼���
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//���̵� �Է�
		textID = new JTextField(); 
		textID.setFont(new Font("�޸յձ�������", Font.PLAIN, 30));
		textID.setBounds(112, 268, 352, 59);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		//�ߺ�Ȯ�� ��ư
		checkIDbtn = new JButton(""); 
		checkIDbtn.setIcon(new ImageIcon("..\\image\\btn_image\\double_check.jpg"));
		checkIDbtn.setBounds(481, 268, 124, 51);
		frame.getContentPane().add(checkIDbtn);

		
		//��й�ȣ �Է�
		textPW = new JTextField(); 
		textPW.setFont(new Font("�޸յձ�������", Font.PLAIN, 30));
		textPW.setBounds(112, 360, 352, 59);
		frame.getContentPane().add(textPW);
		textPW.setColumns(10);
		//��й�ȣ Ȯ��
		textPW_2 = new JTextField(); 
		textPW_2.setFont(new Font("�޸յձ�������", Font.PLAIN, 30));
		textPW_2.setBounds(112, 448, 352, 59);
		frame.getContentPane().add(textPW_2);
		textPW_2.setColumns(10);
		//���� ��ư
		joinbtn = new JButton(""); 
		joinbtn.setIcon(new ImageIcon("..\\image\\btn_image\\create_account_cp.jpg"));
		joinbtn.setBounds(257, 558, 223, 59);
		joinbtn.setBorderPainted(false);
		frame.getContentPane().add(joinbtn);
		//"�г���"
		JLabel label_ID = new JLabel("\uB2C9\uB124\uC784 "); 
		label_ID.setForeground(Color.WHITE);
		label_ID.setFont(new Font("HY�ٴ�M", Font.BOLD, 20));
		label_ID.setBounds(112, 245, 82, 21);
		frame.getContentPane().add(label_ID);
		//"��й�ȣ"
		label_PW = new JLabel("\uBE44\uBC00\uBC88\uD638"); 
		label_PW.setForeground(Color.WHITE);
		label_PW.setFont(new Font("HY�ٴ�M", Font.BOLD, 20));
		label_PW.setFont(new Font("HY�ٴ�M", Font.BOLD, 20));
		label_PW.setBounds(112, 339, 124, 21);
		frame.getContentPane().add(label_PW);
		//"��й�ȣ Ȯ��"
		label_PW2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uD655\uC778");
		label_PW2.setForeground(Color.WHITE);
		label_PW2.setFont(new Font("HY�ٴ�M", Font.BOLD, 20));
		label_PW2.setFont(new Font("HY�ٴ�M", Font.BOLD, 20));
		label_PW2.setBounds(112, 426, 230, 21);
		frame.getContentPane().add(label_PW2);
		//�ݴ� ��ư
		closeBtn = new JButton("");
		closeBtn.setIcon(new ImageIcon("..\\image\\btn_image\\close.jpg"));
		closeBtn.setBounds(652, 0, 43, 43);
		closeBtn.setBorderPainted(false);
		frame.getContentPane().add(closeBtn);
		
		//���̵�� 8�� �̳�
		message = new JLabel("���̵�� 8�� �̳����� �մϴ�.");
		message.setBounds(180, 245, 284, 20);
		frame.getContentPane().add(message);
		
		//��� �̹���
		backImg = new JLabel(""); 
		backImg.setIcon(new ImageIcon("..\\image\\back_image\\new_acount.jpg"));
		backImg.setBounds(0, 0, 695, 682);
		frame.getContentPane().add(backImg);
		
		//introMusic.start();
		
		
			
//===============================================================================

		
		//�ߺ�Ȯ�ι�ư ��� ����
		checkIDbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newId = textID.getText();
				int num = u1.checkId(newId);//���⼭ ���� ������
				if(num==1&&newId.length()<=8&&newId.length()>0) {
					System.out.println("��� ����");
					message.setText("����Ͻ� �� �ֽ��ϴ�.");
					checkId = 1;
				} else if(num==2){
					System.out.println("��� �Ұ�");
					message.setText("�ߺ��Ǵ� ���̵��Դϴ�.");
					checkId = 2;
				}
				else if(num==1&&newId.length()>8||newId.length()>0) {
					System.out.println("��� �Ұ�");
					message.setText("���̵� 8�ڰ� �Ѿ�ϴ�.");
					checkId = 2;

				}
				else if(num==1&&newId.length()==0) {
					System.out.println("��� �Ұ�");
					message.setText("���̵� �Է����ּ���");
					checkId = 2;
				}
				else {
					System.out.println("��� �Ұ�");
					message.setText("�ߺ��Ǵ� ���̵�ų�  8�ڰ� �Ѿ�ϴ�.");
					checkId = 2;
				}
			}
		});

		
		//ȸ�� ���Թ�ư ��� ����
		joinbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newId = textID.getText();
				String newPw = textPW.getText();
				String newPw_2 = textPW_2.getText();
				///introMusic.close();
				if(checkId==1&&newPw.equals(newPw_2)) {
					u1.join(newId, newPw);
					frame.setVisible(false);
				}
				else if(checkId==2) {
					System.out.println("���Ұ�");
					message.setText("���̵� �ٽ� Ȯ�����ּ���");
					message.setForeground(Color.red);
				}
				else if(checkId==0) {
					message.setText("���̵� �ߺ�Ȯ���� ���ּ���");
					message.setForeground(Color.red);
					System.out.println("�ߺ�Ȯ��plz");
				}
				else {
					message.setText("��й�ȣ�� ��ġ�����ʽ��ϴ�");
					message.setForeground(Color.red);
					System.out.println("��ġ X");
				}
			}
		});
		
	
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//introMusic.close();
				frame.setVisible(false);
				frame.setResizable(false);
				frame.setLocation(100,100);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			}
		});		
	}
}