package atrem.Connect4.Game.player.ai;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private PlayerAttributes playerAtributes;
	private Board board;
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public EasyPC(GameController gameController, String name, PlayerId playerId) {
		this.gameController = gameController;
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.board = gameController.getBoard();
		gameController.endInitPlayer();
	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public void setName(String name) {
		playerAttributes.setName(name);
	}

	public int randomSlotNumber() {

		System.out.println("EASYPC");
		int randomSlot;
		int choosenRow;
		Random rand = new Random();
		do {

			randomSlot = rand.nextInt(board.getSlots());
			choosenRow = board.findFreeSpot(randomSlot);
		} while (choosenRow == -1);

		return randomSlot;
	}

	@Override
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void yourTurn() {
		executor.execute(new Runnable() {

			@Override
			public void run() {
				gameController.move(randomSlotNumber());
			}
		});

	}

	@Override
	public void refreshView(int row, int slot) {
		// nie potrzebne w kompie PAWEL
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;

	}

	@Override
	public void endOfGame(ResultState resultGame) {
		// TODO Auto-generated method stub

	}

}
