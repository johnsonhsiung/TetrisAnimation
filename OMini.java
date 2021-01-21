package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * A tetromini in the shape of an O.
 *
 * @author johnsonhsiung
 *
 */
public class OMini extends Tetromini
{
	/**
	 * Makes an object of OMini starting at a random location on the first row of
	 * the grid.
	 */
	public OMini()
	{

		generator = new Random();
		topLeftX = Grid.BLOCK_LENGTH * generator.nextInt(Grid.COLUMNS - 1);
		topLeftY = 0;

	}

	/**
	 * Draws the OMini based on its top left corner.
	 *
	 * @param g2 The graphics used to draw.
	 */
	@Override
	public void draw(Graphics2D g2)
	{
		// TODO Auto-generated method stub

		super.rect = new Rectangle2D[4];

		rect[0] = new Rectangle(topLeftX, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
		rect[1] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
		rect[2] = new Rectangle(topLeftX, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
		rect[3] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
				Grid.BLOCK_LENGTH);
		g2.setColor(getColor());
		g2.fill(rect[0]);
		g2.fill(rect[1]);
		g2.fill(rect[2]);
		g2.fill(rect[3]);
		g2.setColor(Color.DARK_GRAY.brighter());
		g2.draw(rect[0]);
		g2.draw(rect[1]);
		g2.draw(rect[2]);
		g2.draw(rect[3]);

	}

	@Override
	/**
	 * OMini's cannot rotate, so this method returns.
	 */
	public void rotate()
	{
		return;

	}

	/**
	 * Gets the color of this object.
	 *
	 * @return OMini's are always YELLOW, so it returns YELLOW.
	 */
	@Override
	public Color getColor()
	{
		return Color.YELLOW;
	}

}
