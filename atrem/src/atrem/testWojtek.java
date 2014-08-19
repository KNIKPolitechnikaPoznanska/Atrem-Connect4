package atrem;

import java.util.Scanner;

public class testWojtek {
	private static Board board;
	private static Player player1, player2;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Witamy w grze connect 4");
		int a = in.nextInt();
		int b = in.nextInt();
		board = new Board(a, b);
		System.out.println(a);
		System.out.println(b);
		String im = in.next();
		player1 = new Player(im);
		im = in.next();
		player2 = new Player(im);

	}

}
