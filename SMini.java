package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * A tetromini in the shape of an S.
 *
 * @author johnsonhsiung
 *
 */
public class SMini extends Tetromini
{
	/**
	 * Makes an object of SMini starting at a random location on the first row of
	 * the grid.
	 */

	public SMini()
	{
		generator = new Random();
		topLeftX = Grid.BLOCK_LENGTH * generator.nextInt(Grid.COLUMNS - 2);
		topLeftY = 0;
	}

	/**
	 * Draws the SMini based on its top left corner.
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

			rect[0] = new Rectangle(topLeftX + 2 * Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[1] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[2] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
			rect[3] = new Rectangle(topLeftX, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
		} else
		{
			rect[0] = new Rectangle(topLeftX, topLeftY, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[1] = new Rectangle(topLeftX, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH);
			rect[2] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
			rect[3] = new Rectangle(topLeftX + Grid.BLOCK_LENGTH, topLeftY + 2 * Grid.BLOCK_LENGTH, Grid.BLOCK_LENGTH,
					Grid.BLOCK_LENGTH);
		}
		g2.setColor(this.getColor());
		g2.fill(rect[0]);
		g2.fill(rect[1]);
		g2.fill(rect[2]);
		g2.fill(rect[3]);
		g2.setColor(Color.GRAY.brighter());
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
		rotationNumber = generator.nextInt(2);
	}

	/**
	 * Gets the color of this object.
	 *
	 * @return SMini's are always GREEN, so it returns GREEN.
	 */
	@Override
	public Color getColor()
	{
		return Color.GREEN;
	}

}
