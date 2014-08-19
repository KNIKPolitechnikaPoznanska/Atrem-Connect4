package atrem;

import java.util.Scanner;

public class Connect4 {

	private static Player player1, player2; // dlaczego static?
	private static GUI gui = new GUI();

	public static void main(String[] args) {
		Board board;
		Scanner in = new Scanner(System.in);
		System.out.println("Witamy w grze connect 4");
		System.out.println("Podaj liczbe wierszy");
		int a = in.nextInt();
		System.out.println("Podaj liczbe slotow");
		int b = in.nextInt();
		board = new Board(a, b);

		System.out.println("Podaj imie pierwszego zawodnika");
		String im = in.next();
		player1 = new Player(im);
		System.out.println("Podaj imie drugiego zawodnika");
		im = in.next();
		player2 = new Player(im);
		player1.go(1, board);
		player1.go(3, board);
		player1.go(4, board);
		player1.go(4, board);
		player1.go(1, board);
		gui.drawBoard(board);

	}

}
