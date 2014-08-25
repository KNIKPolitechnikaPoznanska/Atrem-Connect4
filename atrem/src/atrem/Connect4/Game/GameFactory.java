package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.Game.player.ai.EasyPC;
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
	private String im2, im1;
	private String opponent;

	public void createGame() {
		this.readInfoMenu();
		this.setGameOpponent();
		this.game = new Game();
		this.game.setBoard(board);
		this.game.setPlayer1(player1);
		this.game.setPlayer2(player2);
		this.game.setResult(ResultState.NoWin);
	}

	public void readInfoMenu() {
		this.board = new Board(menu.getRows(), menu.getSlots());
		im1 = menu.getPlayer1name();
		im2 = menu.getPlayer2name();
		opponent = menu.getOpponent();

	}

	public void setGameOpponent() {
		if (opponent.equalsIgnoreCase("K"))
			player2 = new EasyPC(im2, HoleState.PLAYER2, board);
		else
			player2 = new PlayerConsole(board, im2, HoleState.PLAYER2);
		player1 = new PlayerConsole(board, im1, HoleState.PLAYER1);

	}

	public Game getGame() {
		return game;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
