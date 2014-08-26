package atrem.Connect4.Game;

import java.util.Random;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

/*
 * klasa przechowujaca dane gry
 */
public class Game {
	private Board board;
	private PlayerController player1;
	private PlayerController player2;
	private int playerTurn;
	private ResultState result;
	private Logic logic;
	private int doneMoves;
	private Random rnd = new Random();
	private GameController gameController;

	public Game(Board board) {
		this.board = board;
		setPlayerTurn(genFirstTurn());
		// logic = new Logic(this);

	}

	public void createLogic() {
		logic = new Logic(this);
	}

	public Logic getLogic() {
		return logic;
	}

	/**
	 * 
	 * @return gracz, ktory rozpoczyna gre
	 */
	private int genFirstTurn() {
		if (rnd.nextGaussian() < 0.0D) {
			return 1;
		} else {
			return 2;
		}
	}

	public Board getBoard() {
		return board;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public int getPlayerTurn() {
		return playerTurn;
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

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
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

	public ResultState getResult() {
		return result;
	}

	public void setResult(ResultState playerWin) {
		this.result = playerWin;
	}
}
