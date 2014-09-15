package atrem.connect4.console;

import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerDecision;
import atrem.connect4.game.player.PlayerId;

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
	private int slot, decision;
	private int playerPoints;
	private PlayerId playerId;
	private Color playerColor;

	public PlayerConsole(GameController gameController,
			PlayerAttributes playerAttributes) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		this.playerColor = playerAttributes.getPlayerColor();

		keyHandler = new KeyHandler(gameController.getBoard());
		guiConsole = new GUIConsole(gameController);
		gameController.wakeUpGCr();
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
		guiConsole.askDecision();
		decision = keyHandler.getDecision();
		System.out.println(decision + " decision");
		makeDecision(decision);
	}

	public void makeDecision(int decision) {
		gameController.wakeUpGCr();
		if (decision == 1) {
			playerAttributes.setPlayerDecision(PlayerDecision.MENU);

		}
		if (decision == 0) { // tak gram dalej
			playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);

		}
		if (decision == 2) {// zamknij
			playerAttributes.setPlayerDecision(PlayerDecision.END_GAME);

			return;
		}
		if (gameController.getGamestate() == GameState.END_INIT_ALL)
			gameController.analyseDecision();
	}

	@Override
	public int getPlayerPoints() {
		return playerPoints;
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
	}

	@Override
	public Color getColor() {
		return playerColor;
	}

	@Override
	public Color getOppColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerId(PlayerId playerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOppColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOppName(String name) {
		// TODO Auto-generated method stub

	}

}
