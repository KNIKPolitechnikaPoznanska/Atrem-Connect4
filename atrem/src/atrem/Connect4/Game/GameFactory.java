package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.Game.player.ai.MediumPC;
import atrem.Connect4.console.Menu;
import atrem.Connect4.console.PlayerConsole;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {

	private Board board;
	private PlayerController player1, player2;
	private Game game;
	private Menu menu;
	// private SwingConfig swingconfig; // swing
	private String im2, im1;
	private String opponent;
	private int slot, row;

	public void createGame() {
		this.readInfoMenu();
		// this.readInfoConfig(); // swing

		this.game = new Game(this.board);
		this.createPlayerGame();
		this.board = new Board(row, slot);
		this.game.setBoard(board);
		this.game.setPlayer1(player1);
		this.game.setPlayer2(player2);
		this.game.setResult(ResultState.NoWin);
		this.game.createLogic();

	}

	public void readInfoMenu() {
		this.board = new Board(menu.getRows(), menu.getSlots());
		im1 = menu.getPlayer1name();
		im2 = menu.getPlayer2name();
		opponent = menu.getOpponent();
		slot = menu.getSlots();
		row = menu.getRows();
	}

	// public void readInfoConfig() { // swing
	// this.board = new Board(swingconfig.getRows(), swingconfig.getSlots());
	// im1 = swingconfig.getPlayer1name();
	// im2 = swingconfig.getPlayer2name();
	// opponent = swingconfig.getOpponent();
	// slot = swingconfig.getSlots();
	// row = swingconfig.getRows();
	// }

	public void createPlayerGame() {
		if (opponent.equalsIgnoreCase("K"))
			player2 = new MediumPC(im2, HoleState.PLAYER2, game);
		else
			player2 = new PlayerConsole(board, im2, HoleState.PLAYER2);
		player1 = new PlayerConsole(board, im1, HoleState.PLAYER1);
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public Game getGame() {
		return game;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	// //public SwingConfig getSwingconfig() { // swing
	// return swingconfig;
	// }
	//
	// //public void setSwingconfig(SwingConfig swingconfig) {
	// this.swingconfig = swingconfig;
	// }

}
