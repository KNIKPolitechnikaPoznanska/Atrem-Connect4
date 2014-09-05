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
import atrem.Connect4.swing.DialogInformationBoxes;

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private DialogInformationBoxes informationBoxes;
	private Board board;
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public EasyPC(GameController gameController, String name, PlayerId playerId) {
		this.gameController = gameController;
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		board = gameController.getBoard();
		gameController.endInitPlayer();
		informationBoxes = new DialogInformationBoxes();
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
		board = gameController.getBoard();
		System.out.println("EASYPC");
		int randomSlot;
		Random rand = new Random();
		randomSlot = rand.nextInt(board.getSlots());
		return randomSlot;
	}

	@Override
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void yourTurn() {
		System.out.println("stara dobra metoda");
		executor.execute(new Runnable() {
			@Override
			public void run() {
				int emptySlot;
				do {
					emptySlot = gameController.move(randomSlotNumber());
					System.out.println("randomowo: " + emptySlot + "\n\n");
				} while (emptySlot == -1);
			}
		});

	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;

	}

	@Override
	public void endOfGame(ResultState resultGame) {
		if (resultGame == ResultState.Player1Win)
			informationBoxes.winMessage(playerAttributes.getName());
		if (resultGame == ResultState.Player2Win)
			informationBoxes.winMessage(gameController.getPlayer2().getName());
		if (resultGame == ResultState.Draw)
			informationBoxes.drawMessage();
	}

	@Override
	public int getPlayerPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}
