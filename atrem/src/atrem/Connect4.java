package atrem;

public class Connect4 {

	private static Player player1, player2;
	private static GameLoop gameloop;
	private static Board board;
	private static Menu menu;

	public static void main(String[] args) {
		menu = new Menu(board, player1, player2);
		board = menu.getBoard();
		player1 = menu.getPlayer1();
		player2 = menu.getPlayer2();
		gameloop = new GameLoop(board, player1, player2);

	}
}
