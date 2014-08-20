package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;

public class GUI {

	public void displayGame(Game game) {
		this.drawBoard(game.getBoard());
		if (game.getPlayerTurn() == 1) {
			this.writeCurrentPlayer(game.getPlayer1());
		}
		if (game.getPlayerTurn() == 2) {
			this.writeCurrentPlayer(game.getPlayer2());
		}
		this.displayParagraph();
	}

	private void drawBoard(Board BoardTmp) {
		HoleState HoleTmp;
		for (int j = 0; j < BoardTmp.getRows(); j++) {
			for (int i = 0; i < BoardTmp.getSlots(); i++) {

				HoleTmp = BoardTmp.getHoleState(j, i);
				System.out.print("| " + HoleTmp.getNumber() + " |");
			}
			System.out.println("");
		}
		this.drawSlots(BoardTmp.getSlots());
	}

	private void drawSlots(int slots) {
		System.out.println("Numery slotów:");
		for (int i = 0; i < slots; i++) {
			System.out.print("| " + i + " |");
		}

	}

	private void writeCurrentPlayer(Player player) {
		String name = player.getName();
		System.out.println("Obecny ruch wykonuje:  " + name + " ");
	}

	private void displayParagraph() {
		System.out.println("\n");
		System.out.println("************************************");
	}

}
