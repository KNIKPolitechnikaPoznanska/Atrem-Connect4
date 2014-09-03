package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.console.Menu;
import atrem.Connect4.console.PlayerConsole;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {
	private Board board;
	private PlayerController player1, player2;
	private String player2name, player1name;
	private Menu menu;
	private String opponent;
	private int slots, rows;
	private GameController gameController;

	/**
	 * Tworzy dla ka¿dego gracza w³asnego prezentera
	 */
	public void createPlayerGame() {
		player1 = new SwingPresenter(player1name, PlayerId.Player1,
				gameController);
		// player2 = new SwingPresenter(player2name, PlayerId.Player2,
		// gameController);
		player2 = new PlayerConsole(gameController, player2name,
				PlayerId.Player2);

		// if (opponent.equalsIgnoreCase("K"))
		// player2 = new MediumPC(player2name, HoleState.PLAYER2,gameController,
		// gameController.getLogic());
		// else
		// player2 = new SwingPresenter(player2name, PlayerId.Player2,
		// gameController);
		// narazie bez CPU Lukas
	}

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

		// player1.setSettings();
		// player2.setSettings();
		// narazie niech tak

		// jest PAWEL
	}

	@Deprecated
	public void readInfoMenu() {
		slots = menu.getSlots();
		rows = menu.getRows();
		this.board = new Board(rows, slots);
		player1name = menu.getPlayer1name();
		player2name = menu.getPlayer2name();
		opponent = menu.getOpponent();
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

	@Deprecated
	public void setMenu(Menu menu) {
		this.menu = menu;
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
