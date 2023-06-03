package acad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ColorFrame extends JPanel {
	JButton button;
	Color color = null;

	public ColorFrame() {
		setLayout(new GridLayout(2, 6));

		button = new JButton();
		button.setBackground(Color.BLACK);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.BLACK;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.GRAY;
				
			}
		});
		button.setPreferredSize(new Dimension(20, 20));
		add(button);
		button = new JButton();
		button.setBackground(Color.RED);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.RED;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.ORANGE);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.ORANGE;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.YELLOW);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.YELLOW;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.BLUE);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.BLUE;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.WHITE);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.WHITE;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.lightGray);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.lightGray;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.GREEN);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.GREEN;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.PINK);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.PINK;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.MAGENTA);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.MAGENTA;
				
			}
		});
		add(button);
		button = new JButton();
		button.setBackground(Color.CYAN);
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.CYAN;
				
			}
		});
		add(button);
		button.setMaximumSize(new Dimension(20, 20));
	}

}
