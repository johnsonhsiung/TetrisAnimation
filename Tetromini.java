package animation;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public abstract class Tetromini implements MoveableShape
{

	/**
	 * Gets the maximum Y grid unit of a rectangle in this tetromini.
	 * 
	 * @param rectNum the rectangle number of tetromini.
	 * @return the grid unit of the maximum y.
	 */
	public int getGridMaxYOfRect(int rectNum)
	{
		return getGridUnit((int) rect[rectNum].getMaxY());

	}

	/**
	 * Gets the X grid unit of a rectangle in this tetromini.
	 * 
	 * @param rectNum rectNum the rectangle number of tetromini.
	 * @return the grid unit of the x.
	 */

	public int getGridXOfRect(int rectNum)
	{
		return getGridUnit((int) rect[rectNum].getMinX());
	}

	/**
	 * Gets the Y grid unit of a rectangle in this tetromini.
	 * 
	 * @param rectNum the rectangle number of tetromini.
	 * @return the grid unit of the y.
	 */
	public int getGridYOfRect(int rectNum)
	{
		return getGridUnit((int) rect[rectNum].getMinY());
	}

	/**
	 * Gets the rotation range of this tetromini. Default is 3.
	 * 
	 * @return The rotation range of the tetromini.
	 */
	public int getRotationRange()
	{
		return 3;
	}

	/**
	 * Translates the tetromini.
	 * 
	 * @param dx x translation.
	 * @param dy y translation.
	 */
	@Override
	public void translate(int dx, int dy)
	{
		// TODO Auto-generated method stub
		topLeftY += dy;
		topLeftX += dx;

	}

	/**
	 * Gets the rectangles that makes up this tetromini.
	 * 
	 * @return The rectangles that make up this tetromini.
	 */
	public Rectangle2D[] getRectangles()
	{
		return rect;
	}

	/**
	 * Gets the color of this tetromini.
	 * 
	 * @return The color.
	 */
	public abstract Color getColor();

	/**
	 * Gets the unrounded (truncated) grid unit of a pixel
	 * 
	 * @param pixel the pixel to convert
	 * @return the unrounded grid unit.
	 */
	public static int getGridUnit(int pixel)
	{
		return pixel / Grid.BLOCK_LENGTH;
	}

	public abstract void rotate();

	protected Rectangle2D[] rect;
	protected int topLeftX;
	protected int topLeftY;
	protected int rotationNumber;
	protected Random generator;

}
