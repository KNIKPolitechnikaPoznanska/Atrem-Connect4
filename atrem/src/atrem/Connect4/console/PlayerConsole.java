package atrem.Connect4.console;

import java.util.concurrent.Executor;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private Executor executor;
	private int slots;
	private PlayerAttributes playerAttributes;

	public PlayerConsole(Board board, String name, HoleState playerId) {
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(board);
	}

	@Override
	public int getSlotNumber() {
		executor.execute(new ReadSlotNumber());
		return 0;
	}

	@Override
	public final void setName(String name) {
		playerAttributes.setName(name);
	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public HoleState getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	// private void modyfikacjaGUII() {
	// SwingUtilities.invokeLater(new Runnable() {
	//
	// @Override
	// public void run() {
	// // tutaj modyfikacje
	//
	// }
	// });
	// }
}