package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	StatusBar statusBar;
	DrawingPanel drawingPanel;
	JMenu file, draw;
	JMenuItem button, itemNew, itemExit;

	public MenuBar(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String com = e.getActionCommand();
				switch (com) {
				case "L":
					drawingPanel.setShapeType(com);
					break;
				case "C":
					drawingPanel.setShapeType(com);
					break;
				case "R":
					drawingPanel.setShapeType(com);
					break;
				case "New":
					drawingPanel.shapes.removeAll(drawingPanel.shapes);
					drawingPanel.Bcolor = Color.BLACK;
					drawingPanel.color = Color.WHITE;
					Graphics g = drawingPanel.getGraphics();
					drawingPanel.update(g);
					break;
				case "Exit":
					System.exit(0);
					break;
				}

			}
		};
		file = new JMenu("File");
		add(file);
		itemNew = new JMenuItem("New", KeyEvent.VK_N);
		itemNew.setIcon(new ImageIcon("D:/button_new.gif"));
		itemNew.addActionListener(action);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		file.add(itemNew);
		itemExit = new JMenuItem("Exit");
		itemExit.setIcon(new ImageIcon("D:/button_stop.gif"));
		itemExit.addActionListener(action);
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		file.add(itemExit);

		draw = new JMenu("Draw");
		add(draw);
		button = new JMenuItem("Line");
		button.addActionListener(action);
		button.setActionCommand("L");
		draw.add(button);
		button = new JMenuItem("Cỉcle");
		button.addActionListener(action);
		button.setActionCommand("C");
		draw.add(button);
		button = new JMenuItem("Rectangle");
		button.addActionListener(action);
		button.setActionCommand("R");
		draw.add(button);
	}

}
