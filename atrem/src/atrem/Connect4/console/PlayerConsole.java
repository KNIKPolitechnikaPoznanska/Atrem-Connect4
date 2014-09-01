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

	@Override
	public synchronized int loadSlotNumber() {

		System.out.println("test2");
		executor.execute(new Runnable() {
			@Override
			public void run() {
				int slot = PlayerConsole.this.keyHandler.getSlot();
				PlayerConsole.this.gamecontroller.move();
				PlayerConsole.this.gamecontroller.notifyAll();

			}
		});
		try {

			wait();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test1");
		// gamecontroller.setChoosedSlot(choosedTmp);
		return 0; // do zrobienia

	}

	public synchronized void done() {
		notifyAll();
	}

}
