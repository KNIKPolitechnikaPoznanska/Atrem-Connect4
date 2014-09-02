package atrem.Connect4.console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

/*
 *
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private int slots;
	private PlayerAttributes playerAttributes;
	private GameController gamecontroller;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private int choosedTmp;
	private GUIConsole guiConsole;

	public PlayerConsole(GameController gamecontroller, String name,
			HoleState playerId) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(gamecontroller.getBoard());
		// this.gamecontroller = game.getGameController();
		guiConsole = new GUIConsole();

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

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
	}

	public void setChoosedTmp(int choosedTmp) {
		this.choosedTmp = choosedTmp;
	}

	private void makeMove() {
		int slot = keyHandler.getSlot();
		int emptySpot = gamecontroller.move(slot);
	}

	private void displayGame() {
		guiConsole.displayGame(gamecontroller);
	}

	@Override
	public void yourTurn() {
		System.out.println("test2");
		executor.execute(new Runnable() {
			@Override
			public void run() {
				makeMove();
				displayGame();
			}
		});

	}

	@Override
	public void goView(int row, int slot) {
		displayGame();
	}
}
