package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.console.GUIConsole;

public class GameController {
	// public void wykonalemRuch(HoleState playerId, int slot);\
	private Game game;
	private Logic logic;
	private Board board;
	private int doneMoves;
	private GUIConsole gui;
	private PlayerController player1, player2;

	public void setGameController(Game game) {
		this.game = game;
		this.logic = game.getLogic();
		this.board = game.getBoard();
		this.player1 = game.getPlayer1();
		this.player2 = game.getPlayer2();
		gui = new GUIConsole();

	}

	public void Loop() { // wywalic z konsoli
		doneMoves = 0;
		while (!logic.checkResult(doneMoves)) {
			gui.displayGame(game);
			if (game.getPlayerTurn() == 1) {
				board.go(player1);
				game.setPlayerTurn(2);
			} else if (game.getPlayerTurn() == 2) {
				board.go(player2);
				game.setPlayerTurn(1);
			}
			doneMoves++;
		}
		gui.displayResults(game);
	}
}
