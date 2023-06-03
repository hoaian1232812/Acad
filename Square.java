package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Square extends AShape {
	Point secondPoint;

	public Square(int x, int y, Color color) {
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
			g.drawRect(location.x, location.y, secondPoint.x - location.x, secondPoint.x - location.x);
		}
		if (secondPoint.x < location.x & secondPoint.y < location.y) {
			g.drawRect(secondPoint.x, secondPoint.y, location.x - secondPoint.x, location.x - secondPoint.x);
		}
		if (secondPoint.x < location.x & secondPoint.y > location.y) {
			g.drawRect(secondPoint.x, location.y, location.x - secondPoint.x, location.x - secondPoint.x);
		}
		if (secondPoint.x > location.x & secondPoint.y < location.y) {
			g.drawRect(location.x, secondPoint.y, secondPoint.x - location.x, secondPoint.x - location.x);
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
		g.fillOval(((secondPoint.x + location.x) - 5 ) / 2, ((secondPoint.y + location.y)-5) / 2, 10, 10);
		g.fillOval(location.x - 5, location.y - 5, 10, 10);
		g.fillOval(secondPoint.x - 5, secondPoint.y - 5, 10, 10);
	}

	@Override
	public boolean checkPointRange(int x, int y) {
		
		return false;
	}
	
	public void setX(int x) {
//		this.location.x += x;
	}
	public void setY(int y) {
//		this.location.y += y;
	}

	@Override
	public boolean checkPointSize(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSize(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
