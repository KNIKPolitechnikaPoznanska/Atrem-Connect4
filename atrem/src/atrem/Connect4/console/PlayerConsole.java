package atrem.Connect4.console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

/*
 *
 */
public class PlayerConsole implements PlayerController {

	private KeyHandler keyHandler;
	private int slots;
	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private int choosedTmp;
	private GUIConsole guiConsole;

	public PlayerConsole(GameController gameController, String name,
			PlayerId playerId) {
		this.gameController = gameController;
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(gameController.getBoard());
		// this.gamecontroller = game.getGameController();
		guiConsole = new GUIConsole();
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
		this.choosedTmp = choosedTmp;
	}

	private void makeMove() {
		int slot = keyHandler.getSlot();
		int emptySpot = gameController.move(slot);
	}

	private void displayGame() {
		guiConsole.displayGame(gameController);
	}

	@Override
	public void yourTurn() {
		System.out.println("test2");
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
