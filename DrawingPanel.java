package acad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawingPanel extends JPanel {
	StatusBar statusBar;
	String shapeType = "";
	Color color = Color.WHITE;
	Color Bcolor = Color.BLACK;
	AShape lastShape;
	List<AShape> shapes;
	String text = "";
	String tool = "";
	int x, y;

	public DrawingPanel(StatusBar statusBar) {
		this.statusBar = statusBar;
		shapes = new ArrayList<AShape>();

		setPreferredSize(new Dimension(600, 400));
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (text.equals("")) {
					switch (shapeType) {

					case "C":
						lastShape = new Circle(e.getX(), e.getY(), color);
						shapes.add(lastShape);
						break;
					case "L":
						lastShape = new Line(e.getX(), e.getY(), color);
						shapes.add(lastShape);
						break;
					case "R":
						lastShape = new Rectangle(e.getX(), e.getY(), color);
						shapes.add(lastShape);
						break;
					case "S":
						lastShape = new Square(e.getX(), e.getY(), color);
						shapes.add(lastShape);
						break;
					}

				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (text.equals("")) {
					lastShape.setSecondPoint(e.getX(), e.getY());
				}
				repaint();
			}
		};

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		MouseAdapter t = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (text.equals("tool")) {
					x = e.getX();
					y = e.getY();
					for (int i = 0; i < shapes.size(); i++) {
						AShape s = shapes.get(i);
						if (s.range(x, y)) {
							s.fill(getGraphics());
						}
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (text.equals("tool")) {
					x = e.getX();
					y = e.getY();
				}
				if (tool.equals("delete")) {
					for (int i = 0; i < shapes.size(); i++) {
						if (shapes.get(i).range(x, y)) {
							shapes.remove(i);
							Graphics g = getGraphics();
							update(g);
						}
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				tool = "";
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (text.equals("tool")) {
					int dx = e.getX() - x;
					int dy = e.getY() - y;
					for (int i = 0; i < shapes.size(); i++) {
						if (shapes.get(i).checkPointRange(x, y)) {
							shapes.get(i).setX(dx);
							shapes.get(i).setY(dy);
							repaint();
						}
						if (shapes.get(i).checkPointSize(x, y)) {
							shapes.get(i).setSize(dx, dy);
						}
					}
					x += dx;
					y += dy;
				}
			}
		};
		addMouseListener(t);
		addMouseMotionListener(t);
	}

	@Override
	public void paintComponent(Graphics g) {
		setBackground(Bcolor);
		super.paintComponent(g);
		for (AShape sh : shapes)
			sh.draw(g);
	}

	public void setShapeType(String type) {
		this.shapeType = type;

		switch (type) {
		case "L":
			this.statusBar.setMessage("Line");
			break;
		case "C":
			this.statusBar.setMessage("Circle");
			break;
		case "R":
			this.statusBar.setMessage("Ractangle");
			break;
		case "S":
			this.statusBar.setMessage("Square");
			break;
		}
	}
}
