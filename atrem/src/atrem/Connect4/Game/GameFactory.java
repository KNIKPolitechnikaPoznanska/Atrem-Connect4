package atrem.Connect4.Game;

/*
 * Klasa tworz�ca plansz� (Board)
 */
public class GameFactory {

	private Board board;
	private PlayerController player1, player2;

	public void setGameFactory(Game game, int rows, int slots, String im1,
			String im2, String opponent) {
		board = new Board(rows, slots);
		player1 = new Player(board.getSlots(), im1, HoleState.PLAYER1);
		player2 = new Player(board.getSlots(), im2, HoleState.PLAYER2);
		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
	}

}
