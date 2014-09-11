package atrem.connect4.factory;

import java.util.Random;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerId;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {
	private Board board;
	private GameController gameController;
	private int slots, rows;
	private PlayerFactory playerFactory;

	public GameFactory() {
	}

	public GameFactory(PlayerFactory playerFactory) {
		this.playerFactory = playerFactory;
	}

	/**
	 * Generuje pierwsz¹ turê.
	 */
	public PlayerId randomFirstTurn() {
		Random rand = new Random();
		if (rand.nextInt() % 2 == 0)
			return PlayerId.PLAYER1;
		else
			return PlayerId.PLAYER2;
	}

	/**
	 * Tworzy GameController.
	 */
	public void createGameController() {
		gameController = new GameControllerImpl();
		gameController.setBoard(board);
		playerFactory.createPlayers(gameController);
		gameController.setPlayer1(playerFactory.getPlayer1());
		gameController.setPlayer2(playerFactory.getPlayer2());
		gameController.setPlayerTurn(randomFirstTurn());
	}

	public void createServerGameController() {
		gameController = new GameControllerImpl();
		gameController.setBoard(board);
		gameController.setPlayer1Attributes(playerFactory
				.getPlayer1Attributes());
		gameController.setPlayer2Attributes(playerFactory
				.getPlayer2Attributes());
	}

	public Board getBoard() {
		return board;
	}

	public GameController getGameController() {
		return gameController;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setBoard() {
		board = new Board(rows, slots);
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public PlayerFactory getPlayerFactory() {
		return playerFactory;
	}
}
