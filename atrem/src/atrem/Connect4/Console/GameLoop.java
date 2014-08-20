package atrem.Connect4.Console;

import java.util.Scanner;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.Player;

public class GameLoop {
	Board board;
	private GUI gui = new GUI();
	Scanner in = new Scanner(System.in);
	private Logic logic;
	private Player player1, player2;
	private int playerTurn = 1;

	GameLoop(Board board, Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
		loop();
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	private void loop() { // public!n
		while (true) { // g³ówna pêtla kolejek graczy
			gui.drawBoard(board);

			if (getPlayerTurn() == 1) {
				// slot = in.nextInt();
				player1.go(board);

				setPlayerTurn(2);
			} else {
				// slot = in.nextInt();
				player2.go(board);
				setPlayerTurn(1); // ma byc private
			}
			if (logic.checkIfWin())
				return;
		}

	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
}
