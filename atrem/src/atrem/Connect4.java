package atrem;


public class Connect4 {

	private static Player player1, player2;
	private static GameLoop gameloop;
	private static Board board;
	private static Menu menu;
	private static GUI gui = new GUI();

	public static void main(String[] args) {

		menu = new Menu(board, player1, player2);
		board = menu.getBoard();
		player1 = menu.getPlayer1();
		player2 = menu.getPlayer2();
		gameloop = new GameLoop(board, player1, player2);

		// Board board;
		/*
		 * @SuppressWarnings("resource") Scanner in = new Scanner(System.in);
		 * System.out.println("Witamy w grze connect 4");
		 * System.out.println("Podaj liczbe wierszy"); int a = in.nextInt();
		 * System.out.println("Podaj liczbe slotow"); int b = in.nextInt();
		 * board = new Board(a, b);
		 * 
		 * System.out.println("Podaj imie pierwszego zawodnika"); String im =
		 * in.next(); player1 = new Player(im, HoleState.PLAYER1);
		 * System.out.println("Podaj imie drugiego zawodnika"); im = in.next();
		 * player2 = new Player(im, HoleState.PLAYER2); for (int i = 0; i < 10;
		 * i++) { player1.go(in.nextInt(), board); gui.drawBoard(board);
		 * player2.go(in.nextInt(), board); gui.drawBoard(board); }
		 */
	}
}
