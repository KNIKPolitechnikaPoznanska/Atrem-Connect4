package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.console.PlayerConsole;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {
	private Board board;
	private PlayerController player1, player2;
	private String player2name, player1name;
	private String opponent;
	private int slots, rows;
	private GameController gameController;
	private String gamePl1Type, gamePl2Type;

	/**
	 * £aduje GameController (all settings)
	 */
	public void createGameController() {
		gameController = new GameController();
		gameController.setBoard(board);

		createPlayerGame();
		gameController.setPlayer1(player1);
		gameController.setPlayer2(player2);
		gameController.setPlayerTurn(PlayerId.Player1);
	}

	/**
	 * Tworzy dla ka¿dego gracza w³asnego prezentera
	 */
	public void createPlayerGame() {
		switch (gamePl1Type) {
		case "console":
			player1 = new PlayerConsole(gameController, player1name,
					PlayerId.Player1);
			break;
		case "swing":
			player1 = new SwingPresenter(player1name, PlayerId.Player1,
					gameController, true);
			break;
		}
		if (opponent.equalsIgnoreCase("C"))
			switch (gamePl2Type) {
			case "console":
				player2 = new PlayerConsole(gameController, player2name,
						PlayerId.Player2);
				break;
			case "swing":
				player2 = new SwingPresenter(player2name, PlayerId.Player2,
						gameController, false);
				break;
			}
		else if (opponent.equalsIgnoreCase("K"))
			System.out.println("Brak cpu jeszcze! I chuj");
		// player2 = new MediumPC(player2name, HoleState.PLAYER2,gameController,
		// gameController.getLogic());
	}

	public Board getBoard() {
		return board;
	}

	public GameController getGameController() {
		return gameController;
	}

	public String getOpponent() {
		return opponent;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public String getPlayer1Name() {
		return player1name;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public String getPlayer2Name() {
		return player2name;
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

	public void setGamePl1Type(String gamePl1Type) {
		this.gamePl1Type = gamePl1Type;
	}

	public void setGamePl2Type(String gamePl2Type) {
		this.gamePl2Type = gamePl2Type;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public void setPlayer1Name(String player1Name) {
		this.player1name = player1Name;
	}

	public void setPlayer2Name(String player2Name) {
		this.player2name = player2Name;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
}
