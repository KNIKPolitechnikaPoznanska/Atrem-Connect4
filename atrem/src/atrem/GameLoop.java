package atrem;

import java.util.Scanner;

public class GameLoop {
	Board board;
	private GUI gui = new GUI();
	Scanner in = new Scanner(System.in);
	private Logic logic;
	private Player player1, player2;
	private int playerTurn = 1;
	private int slot;

	GameLoop(Board board, Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
		Loop();
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	private void Loop() {
		while (true) { // g³ówna pêtla kolejek graczy
			gui.drawBoard(board);

			if (getPlayerTurn() == 1) {
				slot = in.nextInt();
				player1.go(slot, board);
				logic = new Logic(board, player1, player2);
				setPlayerTurn(2);
			} else {
				slot = in.nextInt();
				player2.go(slot, board);
				setPlayerTurn(1);
			}
			if (logic.checkIfWin())
				break;
		}

	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
}
