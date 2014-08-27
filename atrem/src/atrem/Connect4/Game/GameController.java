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

	private int choosedSlot;
	private int PlayerTurn;

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
			if (getPlayerTurn() == 1) {
				board.go(player1);
				setPlayerTurn(2);
			} else if (getPlayerTurn() == 2) {
				board.go(player2);
				setPlayerTurn(1);
			}
			doneMoves++;
		}
		gui.displayResults(game);
	}

	public int getChoosedSlot() {
		return choosedSlot;
	}

	public void setChoosedSlot(int choosedSlot) {
		this.choosedSlot = choosedSlot;
	}

	public int getPlayerTurn() {
		return PlayerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		PlayerTurn = playerTurn;
	}
}
