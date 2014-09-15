package atrem.connect4.console;

import atrem.connect4.game.GameController;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;

/*
 * Rysowanie GUI konsolowego
 * w tym: planszy i jej objaœnieñ
 */
public class GUIConsole {
	private GameController gameController;

	public GUIConsole(GameController gameController) {
		this.gameController = gameController;
	}

	public void askDecision() {
		System.out
				.println("\n\n\n Co teraz?\n0 - Nowa gra\n1 - Menu \n2 - Koniec");
	}

	public void displayGame() {
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

	/**
	 * Rysuje plansze w konsoli.
	 * 
	 * @param BoardTmp
	 */
	public void drawBoard(Board BoardTmp) {
		HoleState holeTmp;
		for (int j = 0; j < BoardTmp.getRows(); j++) {
			for (int i = 0; i < BoardTmp.getSlots(); i++) {
				holeTmp = BoardTmp.getHoleState(j, i);
				drawHole(holeTmp);
			}
			System.out.println("");
		}
	}

	private void drawHole(HoleState holeTmp) {
		switch (holeTmp) {
		case EMPTY:
			System.out.print("|O|");
			break;
		case PLAYER1:
			System.out.print("|1|");
			break;
		case PLAYER2:
			System.out.print("|2|");
			break;
		}
	}

	/**
	 * Rysuje sloty w konsoli.
	 * 
	 * @param slots
	 */
	private void drawSlots(int slots) {
		System.out.println("Numery slotow:");
		for (int i = 1; i <= slots; i++) {
			System.out.print("| " + i + " |");
		}
		System.out.println();
	}

	/**
	 * Wyœwietla obecnego gracza.
	 * 
	 * @param player
	 */
	private void writeCurrentPlayer(PlayerController player) {
		String name = player.getName();
		System.out.println("Obecny ruch wykonuje:  " + name + " ");
	}

	/**
	 * Wyœwietla **********
	 */
	private void displayParagraph() {
		System.out.println("\n");
		System.out.println("************************************");
	}

	public void writeFullSlots() {
		System.out.println("Slot jest pelen, podaj inny: ");
	}

	/**
	 * Wyœwietla wynik gry.
	 * 
	 * @param gameController
	 */
	public void displayResults(GameController gameController) {
		this.showResult(gameController);
		this.drawBoard(gameController.getBoard());
		this.displayParagraph();
	}

	/**
	 * Wywo³ane przez displayResults.
	 * 
	 * @param gameController
	 */
	public void showResult(GameController gameController) {
		switch (gameController.getResult()) {
		case DRAW:
			System.out.println("Gra bez rostrzygniecia \n Remis.");
			break;
		case PLAYER_1_WIN:
			System.out.println("	Wygral‚: "
					+ gameController.getPlayer1().getName());
			break;
		case PLAYER_2_WIN:
			System.out.println("Wygral‚ "
					+ gameController.getPlayer2().getName());
			break;
		default:
			break;
		}
	}
}
