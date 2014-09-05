package atrem.Connect4.console;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Rysowanie GUI konsolowego
 * w tym: planszy i jej obja≈ìnie√±
 */
public class GUIConsole {

	public void displayGame(GameController gameController) {
		drawBoard(gameController.getBoard());
		drawSlots(gameController.getBoard().getSlots());
		switch (gameController.getPlayerTurn()) {
		case PLAYER1:
			this.writeCurrentPlayer(gameController.getPlayer1());
			break;
		case PLAYER2:
			this.writeCurrentPlayer(gameController.getPlayer2());
			break;
		default:
			this.displayParagraph();
		}

	}

	public void displayResults(GameController gameController) {
		this.showResult(gameController);
		this.drawBoard(gameController.getBoard());
		this.displayParagraph();
	}

	public void drawBoard(Board BoardTmp) {
		HoleState holeTmp;
		for (int j = 0; j < BoardTmp.getRows(); j++) {
			for (int i = 0; i < BoardTmp.getSlots(); i++) {

				holeTmp = BoardTmp.getHoleState(j, i);
				System.out.print("| " + holeTmp + " |");
			}
			System.out.println("");
		}

	}

	private void drawSlots(int slots) {
		System.out.println("Numery slotow:");
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

	public void showResult(GameController gameController) {
		switch (gameController.getResult()) {
		case Draw:
			System.out.println("Gra bez rostrzygniecia \n Remis.");
			break;
		case Player1Win:
			System.out.println("	WygralÇ: "
					+ gameController.getPlayer1().getName());
			break;
		case Player2Win:
			System.out.println("WygralÇ "
					+ gameController.getPlayer2().getName());
			break;
		default:
			break;
		}
	}
}