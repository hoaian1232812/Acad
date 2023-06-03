package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends AShape {
	int radius;
	Circle circle;
	double d, a;

	public Circle(int x, int y, Color color) {
		super(x, y, color);
		radius = 1;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
	}

	@Override
	public void setSecondPoint(int x, int y) {
		radius = (int) Math.sqrt((location.x - x) * (location.x - x) + (location.y - y) * (location.y - y));
	}

	@Override
	public boolean range(int x, int y) {
		int a = ((x - location.x) * (x - location.x) + (y - location.y) * (y - location.y));
		int d = radius * radius;
		if (a <= d) {
			return true;
		}
			return false;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(location.x - 5, location.y - 5, 10, 10);
		g.fillOval(location.x - 5 + radius, location.y - 5, 10, 10);
		g.fillOval(location.x - 5 - radius, location.y - 5, 10, 10);
	}

	@Override
	public boolean checkPointRange(int x, int y) {
		double d = (x - location.x) * (x - location.x) + (y - location.y) * (y - location.y);
		if (d <= 25) {
			return true;
		}
		return false;
	}

	public boolean checkPointSize(int x, int y) {
		d = (x - (location.x + radius)) * (x - (location.x + radius)) + (y - (location.y)) * (y - (location.y));

		a = (x - (location.x - radius)) * (x - (location.x - radius)) + (y - (location.y)) * (y - (location.y));
		if (d <= 25 || a <= 25) {
			return true;
		}
		return false;
	}

	public void setX(int x) {
		this.location.x += x;
	}

	public void setY(int y) {
		this.location.y += y;
	}

	@Override
	public void setSize(int x, int y) {
		if (d <= 25) {
			radius += x;
		}
		if (a <= 25) {
			radius -= x;
		}

	}

}
