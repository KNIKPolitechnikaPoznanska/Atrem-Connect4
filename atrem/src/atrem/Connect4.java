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
		player1 = new Player(im, HoleState.PLAYER1);
		System.out.println("Podaj imie drugiego zawodnika");
		im = in.next();
		player2 = new Player(im, HoleState.PLAYER2);

		for (int i = 0; i < 10; i++) {
			player1.go(in.nextInt(), board);
			gui.drawBoard(board);
			player2.go(in.nextInt(), board);
			gui.drawBoard(board);
		}
		// gui.drawBoard(board);

	}

}
