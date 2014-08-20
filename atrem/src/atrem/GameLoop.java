package atrem;

import java.util.Scanner;

public class GameLoop {
	private int playerTurn = 1;
	private Logic logic;
	private int slot;
	Scanner in = new Scanner(System.in);

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int kolejGracza) {
		this.playerTurn = kolejGracza;
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

			if (getPlayerTurn() == 1) {
				slot = in.nextInt();
				player1.go(slot, board);
				logic = new Logic(board);
				setPlayerTurn(2);
			} else {
				slot = in.nextInt();
				player1.go(slot, board);
				logic.checkIfWin();
				setPlayerTurn(1);
			}
		}
	}
}
