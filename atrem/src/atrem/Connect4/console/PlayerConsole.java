package atrem.Connect4.console;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
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
	private GameController gamecontroller;
	private ConsolePresenter consolePresenter;
	private ExecutorService thread = Executors.newSingleThreadExecutor();
	private int choosedTmp;

	public PlayerConsole(Game game, String name, HoleState playerId) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		keyHandler = new KeyHandler(game.getBoard());
		// this.gamecontroller = game.getGameController();
		consolePresenter = new ConsolePresenter(this);

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

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
		consolePresenter.setGamecontroller(gamecontroller);
	}

	public void setChoosedTmp(int choosedTmp) {
		this.choosedTmp = choosedTmp;
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
	public synchronized int loadSlotNumber() {

		System.out.println("test2");
		thread.execute(new Runnable() { // bla
			@Override
			public void run() {
				PlayerConsole.this.choosedTmp = PlayerConsole.this.keyHandler
						.getSlot();
				PlayerConsole.this.done();
			}
		});
		try {

			wait();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test1");
		gamecontroller.setChoosedSlot(choosedTmp);
		return 0; // do zrobienia

	}

	public void tokenPlaced() {
		consolePresenter.mouveDone();

	}

	public synchronized void done() {
		notifyAll();
	}

}
