package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.Game.player.ai.MediumPC;
import atrem.Connect4.console.Menu;
import atrem.Connect4.swing.SwingConfig;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {

	private Board board;
	private PlayerController player1, player2;
	private Menu menu; // console opt
	private SwingConfig swingconfig; // swing opt
	private String player2name, player1name;
	private String opponent;
	private int slots, rows;
	private GameController gameController;

	public void createGame(String gameType) {
		if (gameType == "console")
			this.readInfoMenu(); // niejasna nazwa PAWE£
	}

	public void loadGameController() {
		gameController = new GameController();
		createPlayerGame();
		gameController.setBoard(board);
		gameController.setPlayer1(player1);
		gameController.setPlayer2(player2);
		gameController.setPlayerTurn(PlayerId.Player1); // narazie niech tak
														// jest PAWEL

	}

	public Board getBoard() {
		return board;
	}

	public void setBoard() {
		board = new Board(rows, slots);
	}

	public void readInfoMenu() {
		this.board = new Board(menu.getRows(), menu.getSlots());
		player1name = menu.getPlayer1name();
		player2name = menu.getPlayer2name();
		opponent = menu.getOpponent();
		slots = menu.getSlots();
		rows = menu.getRows();
	}

	public String getPlayer2Name() {
		return player2name;
	}

	public void setPlayer2Name(String player2Name) {
		this.player2name = player2Name;
	}

	public String getPlayer1Name() {
		return player1name;
	}

	public void setPlayer1Name(String player1Name) {
		this.player1name = player1Name;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public String getOpponent() {
		return opponent;
	}

	public void createPlayerGame() {

		if (opponent.equalsIgnoreCase("K")) // pytanie czy jak to dizala i czy
											// dziala z DialogBoxem MIELOCH
			player2 = new MediumPC(player2name, HoleState.PLAYER2,
					gameController, gameController.getLogic());
		else
			player2 = new SwingPresenter(swingconfig.getPlayer2name(),
					HoleState.PLAYER2);
		player1 = new SwingPresenter(swingconfig.getPlayer1name(),
				HoleState.PLAYER1);
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public GameController getGame() { // niejasna nazwa PAWE£
		return gameController;
	}

	public GameController getGameController() { // po co drugi getter do
												// powyzej?
		return gameController;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public SwingConfig getSwingconfig() {
		return swingconfig;
	}

	public void setSwingconfig(SwingConfig swingconfig) {
		this.swingconfig = swingconfig;
	}

}
