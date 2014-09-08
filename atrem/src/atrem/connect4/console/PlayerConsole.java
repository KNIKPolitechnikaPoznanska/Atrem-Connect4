package atrem.connect4.console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.connect4.game.GameController;
import atrem.connect4.game.PlayerId;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;

/*
 *
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private GUIConsole guiConsole;
	private int emptySpot;
	private int slot;
	private int playerPoints;

	@Override
	public int getPlayerPoints() {
		return playerPoints;
	}

	public PlayerConsole(GameController gameController, String name,
			PlayerId playerId) {
		this.gameController = gameController;
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(gameController.getBoard());
		// this.gamecontroller = game.getGameController();
		guiConsole = new GUIConsole(gameController);
		gameController.endInitPlayer();
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
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;
	}

	public void setChoosedTmp(int choosedTmp) {
	}

	private void makeMove() {
		slot = keyHandler.getSlot();
		emptySpot = gameController.move(slot);
	}

	private void displayGame() {
		guiConsole.displayGame();
	}

	@Override
	public void yourTurn() {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				displayGame();
				makeMove();
				displayGame();
			}
		});

	}

	public void refreshView(int row, int slot) {
		displayGame();
	}

	@Override
	public void endOfGame(ResultState resultGame) {
		guiConsole.showResult(gameController);
	}

}
