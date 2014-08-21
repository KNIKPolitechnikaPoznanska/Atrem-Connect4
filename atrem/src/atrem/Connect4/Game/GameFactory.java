package atrem.Connect4.Game;

import atrem.Connect4.Console.PlayerConsole;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {

	private Board board;
	private PlayerController player1, player2;

	public void setGameFactory(Game game, int rows, int slots, String im1,
			String im2, String opponent) {
		board = new Board(rows, slots);
		if (opponent.equalsIgnoreCase("K"))
			player2 = new AI(board.getSlots(), im2, HoleState.PLAYER2);
		else
			player2 = new PlayerConsole(board, im1, HoleState.PLAYER2);
		player1 = new PlayerConsole(board.getSlots(), im1, HoleState.PLAYER1);
		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
	}

}
