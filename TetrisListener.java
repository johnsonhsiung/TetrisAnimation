package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * A listener to move the tetromini around given the grid, state, and timer.
 *
 * @author johnsonhsiung
 *
 */
public class TetrisListener implements ActionListener
{
	JLabel label;
	Tetromini mini;
	Timer t;
	TetroState state;
	Grid grid;
	Random generator;

	/**
	 * creates a TetrisListener with a random Tetris block that will move down the
	 * grid for each action performed.
	 *
	 * @param grid  The grid it will draw on.
	 * @param state The state of the blocks already drawn.
	 * @param t     The timer used to count down.
	 */
	public TetrisListener(Grid grid, TetroState state, Timer t)
	{
		this.grid = grid;
		this.state = state;
		this.t = t;
		generator = new Random();
		int whichTetro = generator.nextInt(6);

		switch (whichTetro)
		{
		case 0:
			this.mini = new TMini();
			break;
		case 1:
			this.mini = new IMini();
			break;
		case 2:
			this.mini = new JMini();
			break;
		case 3:
			this.mini = new ZMini();
			break;
		case 4:
			this.mini = new OMini();
			break;
		case 5:
			this.mini = new LMini();
			break;
		}

		ShapeIcon icon = new ShapeIcon(mini, 300, 660);

		this.label = new JLabel(icon);
		label.setBounds(0, 0, 300, 660);
		grid.add(label);

	}

	/**
	 * Translates the tetromini down by 1 pixel unit. Can rotate the block, move the
	 * block to the right or left 1 grid unit. Also checks to see if the game is
	 * over. If it is, then it stops. Uses a random generator
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		mini.translate(0, 1);

		int randomNumber = generator.nextInt(100);
		if (state.canRotate(mini) && randomNumber == ROTATE_NUMBER)
		{

			mini.rotate();
		}
		if (state.canTranslateLeft(mini) && randomNumber == TRANSLATE_LEFT_NUMBER)
		{
			mini.translate(Grid.getPixelUnit(-1), 0);

		}

		if (state.canTranslateRight(mini) && randomNumber == TRANSLATE_RIGHT_NUMBER)
		{
			mini.translate(Grid.getPixelUnit(1), 0);

		}

		label.repaint();

		if (state.shouldStop(mini))
		{
			state.addTetro(mini);
			state.repaint();
			if (state.isGameOver())
			{
				t.stop();
			} else
			{
				t.removeActionListener(this);
				t.addActionListener(new TetrisListener(this.grid, state, t));
			}

		}

	}

	private static final int ROTATE_NUMBER = 5;
	private static final int TRANSLATE_LEFT_NUMBER = 6;
	private static final int TRANSLATE_RIGHT_NUMBER = 7;

}
