package atrem.connect4.game.player.ai;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerDecision;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.DialogInformationBoxes;

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private DialogInformationBoxes informationBoxes;
	private Board board;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private PlayerId playerId;

	public EasyPC(GameController gameController,
			PlayerAttributes playerAttributes, int playerPoints) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		board = gameController.getBoard();
		gameController.connectPlayer();
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
		gameController.connectPlayer();
		if (resultGame == ResultState.PLAYER_1_WIN) {
			if (playerId == PlayerId.PLAYER1)
				playerAttributes.addPoints();
		}
		if (resultGame == ResultState.PLAYER_2_WIN) {
			if (playerId == PlayerId.PLAYER2)
				playerAttributes.addPoints();
		}
		playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);
		if (gameController.getGameState() == GameState.PL2_INITED) {
			gameController.analyseDecision();
			gameController.connectPlayer();
		}
	}

	@Override
	public int getPlayerPoints() {
		return playerAttributes.getPlayerPoints();
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {

		return playerAttributes;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
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
	public void opponentConnected() {
		// TODO Auto-generated method stub

	}

}
