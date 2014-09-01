package atrem.Connect4.console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.GameController;

public class ConsolePresenter {
	private GUIConsole guiconsole;
	private PlayerConsole player;
	private GameController gameController;

	private KeyHandler keyHandler;
	private ExecutorService thread = Executors.newSingleThreadExecutor();

	public ConsolePresenter(PlayerConsole player) {
		this.player = player;
		keyHandler = new KeyHandler();
		guiconsole = new GUIConsole();

	}

	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;
	}

	public void mouveDone() {
		guiconsole.displayGame(gameController.getGame(), gameController);

	}

}
