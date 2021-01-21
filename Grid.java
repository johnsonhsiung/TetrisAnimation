package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * A black and white tetris grid. Each block is 30 x 30 and is a 10 by 22 grid.
 *
 * @author johnsonhsiung
 *
 */
public class Grid extends JPanel
{

	/**
	 * Paints the 10 by 22 grid.
	 *
	 * @param g The graphics component used to paint.
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		super.setOpaque(true);
		super.setBackground(Color.BLACK);

		g2.setColor(Color.WHITE);

		for (int w = 0; w < COLUMNS; w++)
		{
			for (int h = 0; h < ROWS; h++)
			{
				g2.drawRect(getPixelUnit(w), getPixelUnit(h), BLOCK_LENGTH, BLOCK_LENGTH);
			}
		}

	}

	/**
	 * Static method to get the block x or y index grid given pixels.
	 *
	 * @param pixel The pixel to convert
	 * @return The grid unit of the pixel
	 */
	public static int getGridUnitRounded(int pixel)
	{
		return (pixel + BLOCK_LENGTH - 1) / BLOCK_LENGTH;
	}

	/**
	 * Static method to get the pixel unit given grid unit
	 *
	 * @param gridUnit The grid unit to convert
	 * @return the pixels
	 */
	public static int getPixelUnit(int gridUnit)
	{
		return gridUnit * BLOCK_LENGTH;
	}

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 660;
	public static final int ROWS = 22;
	public static final int COLUMNS = 10;
	public static final int BLOCK_LENGTH = WIDTH / COLUMNS;

}
