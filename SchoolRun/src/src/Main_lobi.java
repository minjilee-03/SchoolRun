package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Game.Stage1;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;


//�׸� ����â
public class Main_lobi extends JFrame implements ActionListener {
	private JButton btn;
	Music introMusic = new Music("..\\music\\LOBI_BGM.MP3", true);//����
	User u1 = new User(); //��, ��ŷ ǥ�ø� ���� ����
	JLabel moneylabel;
	public Main_lobi() {
		u1.getAll();
		getContentPane().setLayout(null);
		JPanel p = new JPanel();
		p.setBounds(0, 0, 0, 0);
		
		//�ڷΰ��¹�ư?
		JButton backbtn = new JButton(""); 
		backbtn.setIcon(new ImageIcon("..//image//btn_image//back_btn.jpg"));
		getContentPane().add(p);
		p.setLayout(null);
		p.add(backbtn);
		backbtn.setBounds(0, 743, 196, 51); 
	
		//���۹�ư
		JButton startbtn = new JButton("");
		startbtn.setBorderPainted(false);
		startbtn.setIcon(new ImageIcon("..//image//btn_image//start_btm.jpg"));
		startbtn.setBounds(937, 580, 505, 128);
		getContentPane().add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				SelectItem si = new SelectItem();
			}
		});
		
		//�α׾ƿ���ư
		JButton logoutbtn = new JButton("");
		logoutbtn.setBorderPainted(false);
		logoutbtn.setOpaque(false);
		logoutbtn.setIcon(new ImageIcon("..//image//btn_image//logout.jpg"));
		logoutbtn.setBounds(0, 749, 184, 45);
		getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				introMusic.close();
				setVisible(false);
				Login l1 = new Login();
				l1.setVisible(true);
			}
		});
		
		//ĳ����, �׸� ���� ��ư
		JButton selectCTbtn = new JButton("");
		selectCTbtn.setBorderPainted(false);
		selectCTbtn.setIcon(new ImageIcon("..//image//btn_image//Character_select.jpg"));
		selectCTbtn.setBorderPainted(false);		
		selectCTbtn.setOpaque(false);
		selectCTbtn.setBounds(937, 60, 505, 180);
		getContentPane().add(selectCTbtn);
		selectCTbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new SelectCT();
			}
		});

		// �������� ���� ��ư
		JButton selectSbtn = new JButton("");
		selectSbtn.setIcon(new ImageIcon("..//image//btn_image//st_ch.jpg"));
		selectSbtn.setBorderPainted(false);
		selectSbtn.setBounds(937, 320, 505, 180);
		getContentPane().add(selectSbtn);
		selectSbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
				new Select_Stage();
			}
		});
		

		if(u1.user_id == null) {
			moneylabel = new JLabel("�Ӵ� : " + Integer.toString(u1.guest_money));
		} else {
			moneylabel = new JLabel("�Ӵ� : " + Integer.toString(u1.user_money));
		}
		moneylabel.setFont(new Font("����", Font.BOLD, 25));
		moneylabel.setBounds(937, 20, 300, 30);
		getContentPane().add(moneylabel);
		System.out.println(u1.user_money);
		
		
		u1.setRank();
		
		//��� ��
		JLabel rank1 = new JLabel("1��");
		rank1.setFont(new Font("����", Font.BOLD, 40));
		rank1.setBounds(130, 230, 80, 50);
		getContentPane().add(rank1);
		
		JLabel rank2 = new JLabel("2��");
		rank2.setFont(new Font("����", Font.BOLD, 40));
		rank2.setBounds(130, 330, 80, 50);
		getContentPane().add(rank2);
		
		JLabel rank3 = new JLabel("3��");
		rank3.setFont(new Font("����", Font.BOLD, 40));
		rank3.setBounds(130, 430, 80, 50);
		getContentPane().add(rank3);
		
		JLabel rank4 = new JLabel("4��");
		rank4.setFont(new Font("����", Font.BOLD, 40));
		rank4.setBounds(130, 530, 80, 50);
		getContentPane().add(rank4);
		
		JLabel rank5 = new JLabel("5��");
		rank5.setFont(new Font("����", Font.BOLD, 40));
		rank5.setBounds(130, 630, 80, 50);
		getContentPane().add(rank5);
		
		//�̸�
		JLabel rank1_name = new JLabel(u1.name[0]);
		rank1_name.setFont(new Font("����", Font.BOLD, 30));
		rank1_name.setBounds(275, 230, 350, 50);
		getContentPane().add(rank1_name);
		
		JLabel rank2_name = new JLabel(u1.name[1]);
		rank2_name.setFont(new Font("����", Font.BOLD, 30));
		rank2_name.setBounds(275, 330, 350, 50);
		getContentPane().add(rank2_name);
		
		JLabel rank3_name = new JLabel(u1.name[2]);
		rank3_name.setFont(new Font("����", Font.BOLD, 30));
		rank3_name.setBounds(275, 430, 350, 50);
		getContentPane().add(rank3_name);
		
		JLabel rank4_name = new JLabel(u1.name[3]);
		rank4_name.setFont(new Font("����", Font.BOLD, 30));
		rank4_name.setBounds(275, 530, 350, 50);
		getContentPane().add(rank4_name);
		
		JLabel rank5_name = new JLabel(u1.name[4]);
		rank5_name.setFont(new Font("����", Font.BOLD, 30));
		rank5_name.setBounds(275, 630, 350, 50);
		getContentPane().add(rank5_name);

		//����
		JLabel rank1_score = new JLabel(Integer.toString(u1.score[0]));
		rank1_score.setFont(new Font("����", Font.BOLD, 30));
		rank1_score.setBounds(580, 230, 200, 50);
		getContentPane().add(rank1_score);

		JLabel rank2_score = new JLabel(Integer.toString(u1.score[1]));
		rank2_score.setFont(new Font("����", Font.BOLD, 30));
		rank2_score.setBounds(580, 330, 200, 50);
		getContentPane().add(rank2_score);

		JLabel rank3_score = new JLabel(Integer.toString(u1.score[2]));
		rank3_score.setFont(new Font("����", Font.BOLD, 30));
		rank3_score.setBounds(580, 430, 200, 50);
		getContentPane().add(rank3_score);

		JLabel rank4_score = new JLabel(Integer.toString(u1.score[3]));
		rank4_score.setFont(new Font("����", Font.BOLD, 30));
		rank4_score.setBounds(580, 530, 200, 50);
		getContentPane().add(rank4_score);

		JLabel rank5_score = new JLabel(Integer.toString(u1.score[4]));
		rank5_score.setFont(new Font("����", Font.BOLD, 30));
		rank5_score.setBounds(580, 630, 620, 50);
		getContentPane().add(rank5_score);

		//���
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("..//image//back_image//main_back.jpg"));
		label_1.setBounds(0, 0, 1478, 794);
		getContentPane().add(label_1);

		//���� ��ư
		btn = new JButton();
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setBounds(0, 0, 9, 9);
		getContentPane().add(btn);
		btn.addActionListener(this);
		btn.doClick();
	
		setTitle("SchoolRun!");
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x�� ������ ������ �Ѵٴ� ��(SWING�� �̰� ��� ����)
		setSize(1500,850);
		setVisible(true);
		setResizable(false);
		setLocation(100,100);
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				introMusic.close();
				setVisible(false);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		introMusic.start();
	}
	
	public static void main(String args[]) {
		new Main_lobi();
	}
}