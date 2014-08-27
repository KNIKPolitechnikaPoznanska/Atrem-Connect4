package atrem.Connect4.console;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

/*
 *
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private Executor executor;
	private int slots;
	private PlayerAttributes playerAttributes;
	private int currentSlot;

	private ExecutorService thread = Executors.newSingleThreadExecutor();

	public PlayerConsole(Board board, String name, HoleState playerId) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(board);
	}

	// @Override
	// public int getSlotNumber() {
	// return keyHandler.getSlot();
	// }
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

	@Override
	public synchronized int getSlotNumber() {
		System.out.println("watek w");
		currentSlot = keyHandler.getSlot();
		// return keyHandler.getSlot();
		return currentSlot;

	}

	public int getCurrentSlot() {
		return currentSlot;
	}

}
