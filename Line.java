package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Line extends AShape {
	Point secondPoint;
	Line line;
	double d, a;

	public Line(int x, int y, Color color) {
		super(x, y, color);
		secondPoint = new Point(x, y);
	}

	@Override
	public void setSecondPoint(int x, int y) {
		this.secondPoint.setLocation(x, y);
		;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(location.x, location.y, secondPoint.x, secondPoint.y);
	}

	@Override
	public boolean range(int x, int y) {
		double d = Math.abs(
				-(secondPoint.y - location.y) * (x - location.x) + (secondPoint.x - location.x) * (y - location.y));
		double a = Math.sqrt(-(secondPoint.y - location.y) * (-(secondPoint.y - location.y))
				+ (secondPoint.x - location.x) * (secondPoint.x - location.x));
		if ((d / a) <= 10) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(location.x - 5, location.y - 5, 10, 10);
		g.fillOval(secondPoint.x - 5, secondPoint.y - 5, 10, 10);
		g.fillOval(((secondPoint.x + location.x) - 5) / 2, ((secondPoint.y + location.y) - 5) / 2, 10, 10);
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
		d = (x - location.x) * (x - location.x) + (y - location.y) * (y - location.y);
		a = (x - secondPoint.x) * (x - secondPoint.x) + (y - secondPoint.y) * (y - secondPoint.y);
		if (d <= 25 || a <= 25) {
			return true;
		}
		return false;
	}

	@Override
	public void setSize(int x, int y) {
		if (d <= 25) {
			location.x += x;
			location.y += y;
		}
		if (a <= 25) {
			secondPoint.x += x;
			secondPoint.y += y;
		}

	}

}
