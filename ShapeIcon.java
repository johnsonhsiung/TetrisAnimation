package animation;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * Credited to Chapter 4 of oodp. An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
	public ShapeIcon(MoveableShape shape, int width, int height)
	{
		this.shape = shape;
		this.width = width;
		this.height = height;
	}

	@Override
	public int getIconWidth()
	{
		return width;
	}

	@Override
	public int getIconHeight()
	{
		return height;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{

		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);

	}

	private int width;
	private int height;
	private MoveableShape shape;
}
