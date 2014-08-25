package atrem.Connect4.console;

import java.util.concurrent.Executor;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.Player;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole extends Player implements PlayerController {

	private KeyHandler keyHandler;
	private Executor executor;
	private int slots;

	public PlayerConsole(Board board, String name, HoleState playerId) {
		super(board, name, playerId);
		keyHandler = new KeyHandler(board);
	}

	@Override
	public int getSlotNumber() {
		executor.execute(new ReadSlotNumber());
		return 0;
	}

	@Override
	public final void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;
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