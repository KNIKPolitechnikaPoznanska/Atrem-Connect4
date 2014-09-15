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

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private GameController gameController;
	private Board board;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private PlayerId playerId;
	private Color playerColor, opponentColor;
	private int decision;

	public EasyPC(GameController gameController,
			PlayerAttributes playerAttributes, int playerPoints) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		board = gameController.getBoard();
		gameController.wakeUpGCr();
		this.playerColor = playerAttributes.getPlayerColor();
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
		decision = 0;
		if (resultGame == ResultState.PLAYER_1_WIN) {
			if (playerId == PlayerId.PLAYER1)
				playerAttributes.addPoints();
		}
		if (resultGame == ResultState.PLAYER_2_WIN) {
			if (playerId == PlayerId.PLAYER2)
				playerAttributes.addPoints();
		}

		makeDecision(decision);

	}

	public void makeDecision(int decision) {
		gameController.wakeUpGCr();

		playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);
		if (gameController.getGamestate() == GameState.END_INIT_ALL)
			gameController.analyseDecision();
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
		return playerColor;
	}

	@Override
	public Color getOppColor() {

		return opponentColor;
	}

	@Override
	public void setPlayerId(PlayerId playerId) {
		playerAttributes.setPlayerId(playerId);
		System.out.println("jestem w setId" + playerId);

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
