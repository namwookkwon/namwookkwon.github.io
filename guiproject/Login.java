package guiproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID :  ");
		JLabel pswrd = new JLabel("Password :  ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtpass = new JPasswordField(10);
		JButton logBtn = new JButton("login");
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtpass);
		panel.add(logBtn);

		logBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id  ="권남욱";
				String pass ="1234";

				if(id.equals(txtID.getText()) && pass.equals(txtpass.getPassword())){
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
				}
				else{
					JOptionPane.showMessageDialog(null, "fail");
				}
			}
		});

		add(panel);  //앞에서 추가한 패널 요소 들을 마지막 에 프레임 에 넣는 과정
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);  //중간에 나오는 거
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Login();
	}

}

