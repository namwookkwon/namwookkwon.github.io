package guiproject;


import java.awt.*;
import java.io.File;

import javax.swing.*;


class ImagePanel extends JPanel{
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0, null);
	}
}

public class Lesson8 {
	public static void main(String[]args) {
		JFrame frame = new JFrame("Lesson8");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./img/bird.jpeg").getImage());
		frame.add(panel);
		frame.pack();
		File f = new File("./image/bird.jpeg");
		System.out.println(f.exists()?"Exists":"exist");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
