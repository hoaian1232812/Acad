package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends AShape {
	Point secondPoint;
	double d, a, s, f, g, h, j, k;

	public Rectangle(int x, int y, Color color) {
		super(x, y, color);
		this.secondPoint = new Point(x, y);
	}

	@Override
	public void setSecondPoint(int x, int y) {
		this.secondPoint.setLocation(x, y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		if (secondPoint.x > location.x & secondPoint.y > location.y) {
			g.drawRect(location.x, location.y, secondPoint.x - location.x, secondPoint.y - location.y);
		}
		if (secondPoint.x < location.x & secondPoint.y < location.y) {
			g.drawRect(secondPoint.x, secondPoint.y, location.x - secondPoint.x, location.y - secondPoint.y);
		}
		if (secondPoint.x < location.x & secondPoint.y > location.y) {
			g.drawRect(secondPoint.x, location.y, location.x - secondPoint.x, secondPoint.y - location.y);
		}
		if (secondPoint.x > location.x & secondPoint.y < location.y) {
			g.drawRect(location.x, secondPoint.y, secondPoint.x - location.x, location.y - secondPoint.y);
		}

	}

	@Override
	public boolean range(int x, int y) {
		int maxX = (location.x > secondPoint.x) ? location.x : secondPoint.x;
		int maxY = (location.y > secondPoint.y) ? location.y : secondPoint.y;
		int minX = (location.x < secondPoint.x) ? location.x : secondPoint.x;
		int minY = (location.y < secondPoint.y) ? location.y : secondPoint.y;

		if (x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}

		return false;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(((secondPoint.x + location.x) - 5) / 2, ((secondPoint.y + location.y) - 5) / 2, 10, 10);
		g.fillOval(secondPoint.x - 5, ((secondPoint.y + location.y) - 5) / 2, 10, 10);
		g.fillOval(location.x - 5, ((secondPoint.y + location.y) - 5) / 2, 10, 10);
		g.fillOval(((secondPoint.x + location.x) - 5) / 2, location.y - 5, 10, 10);
		g.fillOval(((secondPoint.x + location.x) - 5) / 2, secondPoint.y - 5, 10, 10);
		g.fillOval(location.x - 5, location.y - 5, 10, 10);
		g.fillOval(secondPoint.x - 5, secondPoint.y - 5, 10, 10);
		g.fillOval(location.x - 5, secondPoint.y - 5, 10, 10);
		g.fillOval(secondPoint.x - 5, location.y - 5, 10, 10);

	}

	@Override
	public boolean checkPointRange(int x, int y) {
		double d = (x - (((secondPoint.x + location.x)) / 2)) * (x - (((secondPoint.x + location.x)) / 2))
				+ (y - (((secondPoint.y + location.y)) / 2)) * (y - (((secondPoint.y + location.y)) / 2));
		if (d <= 25) {
			return true;
		}
		return false;
	}

	public void setX(int x) {
		this.location.x += x;
		this.secondPoint.x += x;
	}

	public void setY(int y) {
		this.location.y += y;
		this.secondPoint.y += y;
	}

	@Override
	public boolean checkPointSize(int x, int y) {
		d = (x - secondPoint.x) * (x - secondPoint.x)
				+ (y - ((secondPoint.y + location.y) / 2)) * (y - ((secondPoint.y + location.y) / 2));
		a = (x - location.x) * (x - location.x)
				+ (y - ((secondPoint.y + location.y) / 2)) * (y - ((secondPoint.y + location.y) / 2));
		s = (x - ((secondPoint.x + location.x) / 2)) * (x - ((secondPoint.x + location.x) / 2))
				+ (y - location.y) * (y - location.y);
		f = (x - ((secondPoint.x + location.x) / 2)) * (x - ((secondPoint.x + location.x) / 2))
				+ (y - secondPoint.y) * (y - secondPoint.y);
		g = (x - location.x) * (x - location.x) + (y - location.y) * (y - location.y);
		h = (x - secondPoint.x) * (x - secondPoint.x) + (y - secondPoint.y) * (y - secondPoint.y);
		j = (x - location.x) * (x - location.x) + (y - secondPoint.y) * (y - secondPoint.y);
		k = (x - secondPoint.x) * (x - secondPoint.x) + (y - location.y) * (y - location.y);

		if (d <= 25 || a <= 25 || s <= 25 || f <= 25 || g <= 25 || h <= 25 || j <= 25 || k <= 25) {
			return true;
		}
		return false;
	}

	@Override
	public void setSize(int x, int y) {
		if (d <= 25) {
			secondPoint.x += x;
		}
		if (a <= 25) {
			location.x += x;
		}

		if (s <= 25) {
			location.y += y;
		}
		if (f <= 25) {
			secondPoint.y += y;
		}
		if (g <= 25) {
			location.x += x;
			location.y += y;
		}
		if (h <= 25) {
			secondPoint.x += x;
			secondPoint.y += y;
		}
		if (j <= 25) {
			location.x += x;
			secondPoint.y += y;
		}
		if (k <= 25) {
			secondPoint.x += x;
			location.y += y;
		}

	}

}
