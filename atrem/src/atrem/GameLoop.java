package atrem;

public class GameLoop {
	Board board;
	Player player1, player2;
	private GUI gui = new GUI();

	GameLoop(Board board, Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
		while (true) { // g³ówna pêtla kolejek graczy
			gui.drawBoard(board);

		}
	}
}
