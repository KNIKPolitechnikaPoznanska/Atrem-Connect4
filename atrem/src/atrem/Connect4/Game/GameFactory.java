package atrem.Connect4.Game;

public class GameFactory {
	private int rows;
	private int slots;
	private Board board;
	private Game game;
	private Player player1, player2;

	public GameFactory(int rows, int slots) {
		this.rows = rows;
		this.slots = slots;
		board = new Board(rows, slots);
		player1 game = new Game();

	}

}
