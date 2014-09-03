package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import atrem.Connect4.Game.LastMove;
import atrem.Connect4.Game.PlayerId;

public class BetterLogicTest {

	BoardGenerator bg = new BoardGenerator();
	LastMove lm = new LastMove();

	BetterLogic bl = new BetterLogic(bg.getBoard(), lm);

	@Test
	public void test() {
		lm.saveLastMove(0, 0, PlayerId.Player1);
		BetterLogic bl = new BetterLogic(bg.getBoard(), lm);
		bg.setVerticalOrHorizontalWinningFour(0, 0, 0, 4);
		assertEquals(4, bl.targetPoint());
	}
}
