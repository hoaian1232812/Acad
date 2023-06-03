package acad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AShape {
	protected Point location;
	protected Color color;

	public AShape(int x, int y, Color color) {
		this.location = new Point(x, y);
		this.color = color;
	}

	public abstract void setSecondPoint(int x, int y);

	public abstract void draw(Graphics g);
	
	public abstract boolean range(int x, int y);
	
	public abstract void fill(Graphics g);
	
	public abstract boolean checkPointRange(int x, int y);
	
	public abstract void setX(int x);
	
	public abstract void setY(int y);
	
	public abstract boolean checkPointSize(int x, int y);
	
	public abstract void setSize(int x, int y);
}

