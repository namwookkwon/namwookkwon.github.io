package guiproject;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomerAPP {

	private JFrame frame;
	private JTextField id;
	private JPasswordField passwordField;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField rid;
	private JTextField rps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAPP window = new CustomerAPP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerAPP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/user/new-workspace/Algorithm/img/bird.jpeg").getImage());
		welcomePanel.setBounds(0, -18, 595, 375);
		frame.setSize(607,390);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(369, 22, 119, 98);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		welcomePanel.add(lblNewLabel);

		id = new JTextField();
		id.setBounds(225, 134, 296, 41);
		id.setFont(new Font("굴림", Font.BOLD, 26));
		id.setToolTipText("EnterID");
		welcomePanel.add(id);
		id.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(223, 185, 298, 41);
		welcomePanel.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(134, 135, 65, 41);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		welcomePanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PS:");
		lblNewLabel_1_1.setBounds(134, 185, 65, 41);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		welcomePanel.add(lblNewLabel_1_1);



		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 595, 321);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);


		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(123, 234, 398, 31);
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBManager mysql = new DBManager();
				List<Map<String, Object>> samples = mysql.selectSample("SELECT * FROM userinfo;");

				boolean isValid = false;
				for (Map<String, Object> info : samples) {

					if(info.get("id").equals(id.getText()) &&
							String.valueOf(passwordField.getPassword()).equals(info.get("ps"))) {
						isValid = true;
					}
				}

				if(isValid){
					System.out.println("성공");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);

				}
				else {
					JOptionPane.showMessageDialog(null, "fail");
				}
			}
		});

		//				DBManager mysql = new DBManager();
		//				List<Map<String, Object>> samples = mysql.selectSample("SELECT * FROM userinfo;");
		//		
		//				boolean doesExist = false;
		//				for (Map<String, Object> info : samples) {
		//					if(info.get("id").equals(id.getText())) {
		//						doesExist = true;
		//					}
		//				}
		//				
		//				if(doesExist) {
		//					JOptionPane.showMessageDialog(null, "fail");
		//				}
		//				else {
		//					mysql.insertUserInfo(id.getText(), String.valueOf(passwordField.getPassword()));
		//				}

		btnNewButton.setFont(new Font("굴림", Font.BOLD, 26));
		welcomePanel.add(btnNewButton);

		JPanel register = new JPanel();
		register.setBounds(0, 0, 485, 321);
		frame.getContentPane().add(register);
		register.setLayout(null);
		register.setVisible(false);

		JButton newcustom = new JButton("register");   //회원가입 들어가는 버튼
		newcustom.setFont(new Font("굴림", Font.BOLD, 25));
		newcustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				mainPanel.setVisible(false);
				register.setVisible(true);
			}
		});


		newcustom.setBounds(123, 288, 398, 31);
		welcomePanel.add(newcustom);

		JLabel lblNewLabel_2 = new JLabel("Welcome main");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2.setBounds(46, 23, 200, 82);
		mainPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3.setBounds(12, 101, 129, 37);
		mainPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3_1.setBounds(12, 148, 129, 49);
		mainPanel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Gender");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3_1_1.setBounds(12, 201, 129, 49);
		mainPanel.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_2 = new JLabel("Phone");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3_1_2.setBounds(298, 95, 129, 49);
		mainPanel.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_3_1_3 = new JLabel("Birthday");
		lblNewLabel_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_3.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3_1_3.setBounds(298, 148, 129, 49);
		mainPanel.add(lblNewLabel_3_1_3);

		JLabel lblNewLabel_3_1_4 = new JLabel("Note");
		lblNewLabel_3_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_4.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3_1_4.setBounds(298, 201, 129, 49);
		mainPanel.add(lblNewLabel_3_1_4);

		name = new JTextField();
		name.setFont(new Font("굴림", Font.BOLD, 19));
		name.setBounds(138, 101, 126, 37);
		mainPanel.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setFont(new Font("굴림", Font.BOLD, 19));
		age.setColumns(10);
		age.setBounds(138, 154, 126, 37);
		mainPanel.add(age);

		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.BOLD, 19));
		phone.setColumns(10);
		phone.setBounds(411, 101, 126, 37);
		mainPanel.add(phone);

		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.BOLD, 19));
		birthday.setColumns(10);
		birthday.setBounds(411, 154, 126, 37);
		mainPanel.add(birthday);

		JComboBox gender = new JComboBox(new String [] {"Male" , "Female"});
		gender.setBounds(138, 210, 126, 34);
		mainPanel.add(gender);

		JTextArea note = new JTextArea();
		note.setBounds(411, 215, 113, 37);
		mainPanel.add(note);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void	actionPerformed(ActionEvent argo) {
				String nameText = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt  = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();

			}
		});

		btnNewButton_1.setBounds(199, 267, 147, 44);
		mainPanel.add(btnNewButton_1);


		JLabel lblNewLabel_4 = new JLabel("회원가입 부탁드립니다");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_4.setBounds(78, 22, 281, 89);
		register.add(lblNewLabel_4);

		JButton submit = new JButton("회원가입");   //회원가입 하는 버튼
		submit.setBounds(123, 254, 117, 36);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBManager mysql = new DBManager();
				List<Map<String, Object>> samples = mysql.selectSample("SELECT * FROM userinfo;");

				boolean doesExist = false;
				for (Map<String, Object> info : samples) {
					if(info.get("id").equals(rid.getText())) {
						doesExist = true;
					}

				} if(doesExist) {
					JOptionPane.showMessageDialog(null, "이미존재하는 id");
				}
				else {
					mysql.insertUserInfo(rid.getText(), String.valueOf(rps.getText()));
				}
			}
		});

		register.add(submit);

		JLabel lblNewLabel_5 = new JLabel("PS:");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel_5.setBounds(61, 171, 50, 36);
		register.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel_6.setBounds(61, 108, 50, 37);
		register.add(lblNewLabel_6);

		rid = new JTextField();
		rid.setToolTipText("EnterID");
		rid.setFont(new Font("굴림", Font.BOLD, 26));
		rid.setColumns(10);
		rid.setBounds(123, 106, 216, 41);
		register.add(rid);

		rps = new JTextField();
		rps.setToolTipText("EnterID");
		rps.setFont(new Font("굴림", Font.BOLD, 26));
		rps.setColumns(10);
		rps.setBounds(123, 169, 216, 41);
		register.add(rps);

		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(true);
				mainPanel.setVisible(false);
				register.setVisible(false);	
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_2.setBounds(376, 56, 97, 23);
		register.add(btnNewButton_2);



		frame.setResizable(false);
		frame.setJMenuBar(menuBar());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");

		bar.add(fileMenu);
		bar.add(aboutMenu);

		JMenuItem openfile  = new JMenuItem("open");
		JMenuItem exit =  new JMenuItem("Exit");
		fileMenu.add(openfile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		return bar;
	}
}


class ImagePanel extends JPanel{
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0, null);
	}
}

