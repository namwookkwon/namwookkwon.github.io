package guiproject;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;

import javax.swing.*;

public class Lesson7 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Table prac");
		JPanel panel = new JPanel();
		String[] headings = new String[] {"Id" , "Name", "Country"};

		Object [][] data = new Object[][]{ 
			{"1" , "Danial", "Korea"},
			{"2", "Sunny", " France"},
			{"3", "John", "Japan"}
		};

		JTable table = new JTable(data,headings);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		
		panel.add(new JScrollPane(table));
		
		
		
		frame.add(panel);

		frame.setVisible(true);
		frame.setSize(800,640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
