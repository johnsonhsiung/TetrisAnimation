package animation;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Tests the tetris program. Increase delay to slow down falling speed.
 *
 * @author johnsonhsiung
 *
 */
public class TetrisTester
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Tetris Animation");
		frame.setSize(300, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);

		Grid grid = new Grid();

		TetroState state = new TetroState();
		grid.setLayout(null);

		state.setBounds(0, 0, 300, 660);

		frame.add(grid);
		grid.add(state);

		frame.setVisible(true);

		final int DELAY = 15;

		Timer t = new Timer(DELAY, null);

		t.addActionListener(new TetrisListener(grid, state, t));

		t.start();

	}
}
