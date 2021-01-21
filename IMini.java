package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * A tetromini in the shape of an I.
 *
 * @author johnsonhsiung
 *
 */
public class IMini extends Tetromini
{
	/**
	 * Makes an object of IMini starting at a random location on the first row of
	 * the grid.
	 */
	public IMini()
	{

		generator = new Random();
		topLeftX = Grid.BLOCK_LENGTH * generator.nextInt(Grid.COLUMNS - 4) + Grid.BLOCK_LENGTH;
		topLeftY = 0;

	}

	/**
	 * Draws the IMini based on its top left corner.
	 *
	 * @param g2 The graphics used to draw.
	 */
	@Override
	public void draw(Graphics2D g2)
	{
		// TODO Auto-generated method stub
		super.rect = new Rectangle2D[4];
		if (rotationNumber == 0)
		{

			rect[0] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[1] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
			rect[2] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + 2 * Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
			rect[3] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + 3 * Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
		} else
		{
			rect[0] = new Rectangle(topLeftX, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[1] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[2] = new Rectangle(topLeftX + 2 * Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[3] = new Rectangle(topLeftX + 3 * Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
		}
		g2.setColor(this.getColor());
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

	/**
	 * Changes the rotationNumber of this object, so draw() can draw the correct
	 * rotation.
	 */
	@Override
	public void rotate()
	{

		rotationNumber = generator.nextInt(3);

	}

	/**
	 * Gets the color of this object.
	 *
	 * @return IMini's are always CYAN, so it returns CYAN.
	 */
	@Override
	public Color getColor()
	{

		return Color.CYAN;
	}

	/**
	 * Gets the range of rotation.
	 *
	 * @return IMini's have a range of 4.
	 */
	@Override
	public int getRotationRange()
	{
		return 4;
	}

}
