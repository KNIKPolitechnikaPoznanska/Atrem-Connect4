package atrem.Connect4.console;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Rysowanie GUI konsolowego
 * w tym: planszy i jej objaœnieñ
 */
public class GUI {

	public void displayGame(Game game) {
		this.drawBoard(game.getBoard());
		this.drawSlots(game.getBoard().getSlots());
		if (game.getPlayerTurn() == 1) {
			this.writeCurrentPlayer(game.getPlayer1());
		}
		if (game.getPlayerTurn() == 2) {
			this.writeCurrentPlayer(game.getPlayer2());
		}
		this.displayParagraph();
	}

	public void displayResults(Game game) {
		this.showResult(game);
		this.drawBoard(game.getBoard());
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

	}

	private void drawSlots(int slots) {
		System.out.println("Numery slotów:");
		for (int i = 1; i <= slots; i++) {
			System.out.print("| " + i + " |");
		}
		System.out.println();

	}

	private void writeCurrentPlayer(PlayerController player) {
		String name = player.getName();
		System.out.println("Obecny ruch wykonuje:  " + name + " ");
	}

	private void displayParagraph() {
		System.out.println("\n");
		System.out.println("************************************");
	}

	public void writeFullSlots() {
		System.out.println("Slot jest pelen, podaj inny: ");
	}

	public void showResult(Game game) {
		if (game.getResult() == ResultState.Player1Win) {
			System.out.println("	Wygrał: " + game.getNamePlayer1());
		} else if (game.getResult() == ResultState.Player2Win) {
			System.out.println("Wygrał " + game.getNamePlayer2());
		} else if (game.getResult() == ResultState.Draw) {
			System.out.println("Gra bez rostrzygniecia \n Remis.");
		}
	}
}