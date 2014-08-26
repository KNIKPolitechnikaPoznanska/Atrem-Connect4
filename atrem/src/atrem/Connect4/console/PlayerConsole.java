package atrem.Connect4.console;

import java.util.concurrent.ExecutorService;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private ExecutorService watek;
	private int slots;
	private PlayerAttributes playerAttributes;
	private int currentSlot;

	public PlayerConsole(Board board, String name, HoleState playerId) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(board);

	}

	@Override
	public int getSlotNumber() {
		return keyHandler.getSlot();
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

	// public int getSlotNumber() {
	// ExecutorService thread = Executors.newSingleThreadExecutor();
	// thread.execute(new Runnable() {
	//
	// @Override
	// public void run() {
	// currentSlot = keyHandler.getSlot();
	// System.out.println("watek");
	// }
	// });
	// thread.shutdown();
	// return currentSlot;
	// }

}
