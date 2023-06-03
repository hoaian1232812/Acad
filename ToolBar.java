package acad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ToolBar extends JPanel {
	DrawingPanel drawingPanel;
	ColorFrame colorFrame;
	JButton button, BGColor, drawColor;
	JToggleButton focus;

	public ToolBar(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		this.colorFrame = colorFrame;

		setLayout(new FlowLayout(FlowLayout.LEFT));
		colorFrame = new ColorFrame();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String com = e.getActionCommand();
				drawingPanel.setShapeType(com);
			}
		};

		button = new JButton(new ImageIcon("D:/line.png"));
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(action);
		button.setActionCommand("L");
		add(button);
		button = new JButton(new ImageIcon("D:/circle.png"));
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(action);
		button.setActionCommand("C");
		add(button);
		button = new JButton(new ImageIcon("D:/rectangle.png"));
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(action);
		button.setActionCommand("R");
		add(button);
		button = new JButton(new ImageIcon("D:/elip.png"));
		button.setPreferredSize(new Dimension(20, 20));
		button.addActionListener(action);
		button.setActionCommand("S");
		add(button);

		button.setMaximumSize(new Dimension(20, 20));

		focus = new JToggleButton("Selection");
		focus.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					drawingPanel.text = "tool";
				} else {
					drawingPanel.text = "";
					Graphics g = drawingPanel.getGraphics();
					drawingPanel.update(g);
				}
			}
		});
		add(focus);

		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.tool = "delete";

			}
		});
		add(button);

		ActionListener colorAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "BG":
					drawingPanel.Bcolor = colorFrame.color;
					Graphics g = drawingPanel.getGraphics();
					drawingPanel.update(g);
					break;
				case "Draw":
					drawingPanel.color = colorFrame.color;
					break;
				}

			}
		};

		BGColor = new JButton("BG");
		BGColor.setPreferredSize(new Dimension(40, 50));
		BGColor.setBorder(BorderFactory.createTitledBorder("CL"));
		BGColor.addActionListener(colorAction);
		add(BGColor);
		drawColor = new JButton("Draw");
		drawColor.setPreferredSize(new Dimension(40, 50));
		drawColor.setBorder(BorderFactory.createTitledBorder("CL"));
		drawColor.addActionListener(colorAction);
		add(drawColor);
		colorFrame = new ColorFrame();
		add(colorFrame);
	}
}