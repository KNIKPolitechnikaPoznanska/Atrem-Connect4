package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.console.GUIConsole;

public class GameController {
	// public void wykonalemRuch(HoleState playerId, int slot);\
	private Game game;
	private Logic logic;
	private Board board;
	private int doneMoves;
	private GUIConsole gui;

	public void setGameController(Game game, Logic logic, Board board) {
		this.game = game;
		this.logic = logic;
		this.board = board;
	}

	public void Loop() { // wywalic z konsoli
		doneMoves = 0;
		while (!logic.checkResult(doneMoves)) {
			// gui.displayGame(game);
			if (game.getPlayerTurn() == 1) {
				board.go(player1);
				game.setPlayerTurn(2);
			} else if (game.getPlayerTurn() == 2) {
				board.go(player2);
				game.setPlayerTurn(1);
			}
			doneMoves++;
		}
		// gui.displayResults(game);
	}
}
