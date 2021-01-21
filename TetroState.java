package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

/**
 * Keeps the state of the fallen tetrominis.
 *
 * @author johnsonhsiung
 *
 */
public class TetroState extends JLabel
{

	/**
	 * Initializes an array of the rectangles of the grid with the color of what it
	 * should be drawn as.
	 */

	public TetroState()
	{
		fallenShapes = new Rectangle2D[10][22];
		colorOfBlocks = new Color[10][22];
	}

	/**
	 * Paints the state of the tetris animation.
	 *
	 * @param g The graphical context.
	 */
	@Override
	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 22; j++)
			{
				if (fallenShapes[i][j] != null)
				{
					g2.setColor(colorOfBlocks[i][j]);
					g2.fill(fallenShapes[i][j]);
					g2.setColor(Color.BLACK);
					g2.draw(fallenShapes[i][j]);

				}

			}
		}

	}

	/**
	 * Adds the tetromini to the state of the tetris animation.
	 *
	 * @param tetro The tetromini to be added.
	 */
	public void addTetro(Tetromini tetro)
	{
		Rectangle2D[] tetroRectangles = new Rectangle2D[4];
		tetroRectangles = tetro.getRectangles();
		Color currentColor = tetro.getColor();
		for (int i = 0; i < 4; i++)
		{
			Rectangle2D currentRect = tetroRectangles[i];
			int currentGridX = Grid.getGridUnitRounded((int) currentRect.getX());
			int currentGridY = Grid.getGridUnitRounded((int) currentRect.getY());
			if (fallenShapes[currentGridX][currentGridY] == null)
			{
				fallenShapes[currentGridX][currentGridY] = currentRect;
				colorOfBlocks[currentGridX][currentGridY] = currentColor;
			} else
			{
				break;
			}
		}

	}

	/**
	 * Checks to see if the tetromini should stop given the current state.
	 *
	 * @param mini the mini to be checked.
	 * @return True if it should stop, false if it should not.
	 */

	public boolean shouldStop(Tetromini mini)
	{

		if (mini.rect[3].getMaxY() >= Grid.getPixelUnit(Grid.ROWS))
		{
			return true;
		}

		int maxYOfBlock;
		int xOfBlock;

		for (int i = 0; i < 4; i++)
		{
			maxYOfBlock = mini.getGridMaxYOfRect(i);
			xOfBlock = mini.getGridXOfRect(i);
			if (fallenShapes[xOfBlock][maxYOfBlock] != null)
			{
				return true;
			}

		}
		return false;
	}

	/**
	 * Checks if the mini can rotate given the current state.
	 *
	 * @param mini The mini to check.
	 * @return True if mini can rotate. False otherwise.
	 */
	public boolean canRotate(Tetromini mini)
	{
		if (Grid.getGridUnitRounded(mini.topLeftY) > Grid.ROWS - 4)
		{

			return false;

		}
		int xStart = Grid.getGridUnitRounded(mini.topLeftX);
		int yStart = Grid.getGridUnitRounded(mini.topLeftY);
		int range = mini.getRotationRange();
		for (int i = xStart; i < xStart + range && i < Grid.COLUMNS; i++)
		{
			for (int j = yStart; j < yStart + range && j < Grid.ROWS; j++)
			{
				if (fallenShapes[i][j] != null || i >= Grid.COLUMNS - range)
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the mini can translate left given the current state.
	 *
	 * @param mini The tetromini to check.
	 * @return True if it can translate left, false otherwise.
	 */
	public boolean canTranslateLeft(Tetromini mini)
	{
		if (mini.topLeftX == 0)
		{
			return false;
		}

		int xTranslateBoundary;
		int yTranslateBoundary;
		for (int i = 0; i < 4; i++)
		{
			xTranslateBoundary = mini.getGridXOfRect(i);
			yTranslateBoundary = mini.getGridYOfRect(i);

			if (yTranslateBoundary < 0)
			{
				yTranslateBoundary = 0;
			}
			if (yTranslateBoundary > 18)
			{
				yTranslateBoundary = 19;
			}
			if (fallenShapes[xTranslateBoundary - 1][yTranslateBoundary] != null
					|| fallenShapes[xTranslateBoundary - 1][yTranslateBoundary + 1] != null
					|| fallenShapes[xTranslateBoundary - 1][yTranslateBoundary + 2] != null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the mini can translate right given the current state.
	 *
	 * @param mini The mini to be checked.
	 * @return True if mini can translate right, false otherwise.
	 */
	public boolean canTranslateRight(Tetromini mini)
	{

		if (Grid.getGridUnitRounded(mini.topLeftX) >= Grid.COLUMNS - mini.getRotationRange())
		{

			return false;
		}

		int xTranslateBoundary;
		int yTranslateBoundary;
		for (int i = 0; i < 4; i++)
		{
			xTranslateBoundary = mini.getGridXOfRect(i) + 1;
			yTranslateBoundary = mini.getGridYOfRect(i);

			if (yTranslateBoundary < 0)
			{
				yTranslateBoundary = 0;
			}
			if (yTranslateBoundary > Grid.ROWS - 4)
			{
				yTranslateBoundary = Grid.ROWS - 3;
			}
			if (xTranslateBoundary >= Grid.COLUMNS)
			{
				xTranslateBoundary = Grid.COLUMNS - 1;
			}
			if (fallenShapes[xTranslateBoundary][yTranslateBoundary] != null
					|| fallenShapes[xTranslateBoundary][yTranslateBoundary + 1] != null
					|| fallenShapes[xTranslateBoundary][yTranslateBoundary + 2] != null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the game is over.
	 *
	 * @return True if game is over, false otherwise.
	 */

	public boolean isGameOver()
	{
		for (int i = 0; i < Grid.COLUMNS; i++)
		{
			if (fallenShapes[i][0] != null)
			{
				return true;
			}
		}
		return false;
	}

	private Rectangle2D[][] fallenShapes;
	private Color[][] colorOfBlocks;

}
