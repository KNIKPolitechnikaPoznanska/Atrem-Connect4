package atrem.Connect4.Game;

import java.util.Random;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;

/*
 * klasa przechowujaca dane gry
 */
public class Game {
	private Board board;
	private PlayerController player1;
	private PlayerController player2;

	private int doneMoves;
	private Random rnd = new Random();

	// private GameController gameController;

	public Game(Board board) {
		this.board = board;
		// setPlayerTurn(genFirstTurn()); // grzebanei z watkiem
		// logic = new Logic(this);

	}

	/**
	 * 
	 * @return gracz, ktory rozpoczyna gre
	 */
	// private int genFirstTurn() { // grzebanie z watkiem
	// if (rnd.nextGaussian() < 0.0D) {
	// return 1;
	// } else {
	// return 2;
	// }
	// }
	// public GameController getGameController() {
	// return gameController;
	// }
	//
	// public void setGameController(GameController gameController) {
	// this.gameController = gameController;
	// }

	public Board getBoard() {
		return board;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPlayer1(PlayerController player1) {
		this.player1 = player1;
	}

	public void setPlayer2(PlayerController player2) {
		this.player2 = player2;
	}

	public int getBoardSlots() {
		return this.board.getSlots();
	}

	public int getBoardRows() {
		return this.board.getRows();
	}

	public String getNamePlayer1() {
		return this.player1.getName();
	}

	public String getNamePlayer2() {
		return this.player2.getName();
	}

}
