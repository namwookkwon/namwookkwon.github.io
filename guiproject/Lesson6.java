package guiproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson6 window = new Lesson6();
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
	public Lesson6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson06");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 788, 567);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnnext = new JButton("go to next");
		btnnext.setBounds(90, 82, 216, 319);
		startPage.add(btnnext);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 788, 567);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnbefore = new JButton("go to Last");
		btnbefore.setBounds(436, 66, 268, 257);
		btnbefore.setFont(new Font("Tahoma", Font.PLAIN, 13));
		endPage.add(btnbefore);
		
		endPage.setVisible(false);
		btnnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		
		
		btnbefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startPage.setVisible(true);
				endPage.setVisible(false);
				
			}
		});
	}
	
}
