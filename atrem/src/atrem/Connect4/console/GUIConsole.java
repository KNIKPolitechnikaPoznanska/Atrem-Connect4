package atrem.Connect4.console;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Rysowanie GUI konsolowego
 * w tym: planszy i jej objaœnieñ
 */
public class GUIConsole {

	public void displayGame(Game game, GameController gamecontroller) {
		// GameController gamecontroller = game.getGameController();
		this.drawBoard(game.getBoard());
		this.drawSlots(game.getBoard().getSlots());
		if (gamecontroller.getPlayerTurn() == 1) {
			this.writeCurrentPlayer(game.getPlayer1());
		}
		if (gamecontroller.getPlayerTurn() == 2) {
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
		HoleState holeTmp;
		for (int j = 0; j < BoardTmp.getRows(); j++) {
			for (int i = 0; i < BoardTmp.getSlots(); i++) {

				holeTmp = BoardTmp.getHoleState(j, i);
				System.out.print("| " + holeTmp.getNumber() + " |");
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
		switch (game.getResult()) {
		case Draw:
			System.out.println("Gra bez rostrzygniecia \n Remis.");
			break;
		case Player1Win:
			System.out.println("	Wygrał: " + game.getNamePlayer1());
			break;
		case Player2Win:
			System.out.println("Wygrał " + game.getNamePlayer2());
			break;
		default:
			break;
		}
	}
}