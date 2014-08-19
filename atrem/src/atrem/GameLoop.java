package atrem;

import java.util.Scanner;

public class GameLoop {
	private int kolejGracza = 1;
	private Logic logic;
	private int slot;
	Scanner in = new Scanner(System.in);

	public int getKolejGracza() {
		return kolejGracza;
	}

	public void setKolejGracza(int kolejGracza) {
		this.kolejGracza = kolejGracza;
	}

	Board board;
	Player player1, player2;
	private GUI gui = new GUI();

	GameLoop(Board board, Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
		while (true) { // g³ówna pêtla kolejek graczy
			gui.drawBoard(board);

			if (getKolejGracza() == 1) {
				slot = in.nextInt();
				player1.go(slot, board);
				logic = new Logic(board);
				setKolejGracza(2);
			} else {
				slot = in.nextInt();
				player1.go(slot, board);
				logic.checkIfWin();
				setKolejGracza(1);
			}
		}
	}
}
