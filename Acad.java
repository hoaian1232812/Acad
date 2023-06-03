package acad;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Acad extends JFrame {
	ToolBar toolBar;
	DrawingPanel drawingPanel;
	StatusBar statusBar;
	MenuBar menuBar;

	public Acad() {
		super("My Painter");

		statusBar = new StatusBar();
		drawingPanel = new DrawingPanel(statusBar);
		toolBar = new ToolBar(drawingPanel);

		getContentPane().add(toolBar, BorderLayout.NORTH);
		getContentPane().add(drawingPanel, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);

		menuBar = new MenuBar(drawingPanel);
		setJMenuBar(menuBar);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Acad();

	}

}
