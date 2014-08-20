package atrem.Connect4.Game;

public class GameFactory {

	private Board board;
	private Game game;
	private Player player1, player2;

	public GameFactory(int rows, int slots, String im1) {

		board = new Board(rows, slots);
		player1 = new Player(im1, HoleState.PLAYER1);

	}

}
