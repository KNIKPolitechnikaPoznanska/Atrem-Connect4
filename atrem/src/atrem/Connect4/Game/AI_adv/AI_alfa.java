package atrem.Connect4.Game.AI_adv;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.PlayerController;

public class AI_alfa {

	private AI_alfa[][] gameBoard;
	private int slots;
	private int rows;
	private Logic logic;
	private Game game;
	private Board board;
	private PlayerController player1;
	private int[] lastBestMouve;
	private int playerTurn;

	public AI_alfa(Game game) {

		slots = game.getBoard().getSlots();
		rows = game.getBoard().getRows();
		this.game = game;
		this.board = game.getBoard();
		this.lastBestMouve = new int[board.getSlots()];
		this.playerTurn = game.getPlayerTurn();
		// this.evaluateNextMouve();

	}

	private Board nextMouve(Board board, int slot) {

		// this.go(board, player, slot);
		if (playerTurn == 1) {
			this.go(board, game.getPlayer1(), slot);
			playerTurn = 2;
		} else // (game.getPlayerTurn() == 2) {
		{
			this.go(board, game.getPlayer2(), slot);
			playerTurn = 1;
		}

		return nextBoard;
	}

	public int evaluateNextMouve(int depth, Game game, int slot) {

		if (depth == 0) {
			int ocena = 5;
			// ocenianie z zapisywanie slotu komputera
			return ocena;
		} else {
			Board boardTmp = game.getBoard();
			for (int slotTmp = 0; slotTmp < board.getSlots(); slotTmp++)// Ckeyhandler
			{
				if (board.findFreeSpot(slotTmp) != -1) {
					boardTmp = this.nextMouve(game, slotTmp);
					if (game.getPlayerTurn() == 2) {
						// zapisywanie numeru slotu
					}
					evaluateNextMouve(depth - 1, game, slot);
				}
			}

		}

		return 0;
	}

	private boolean go(Board board, PlayerController player, int slot) {// do
																		// gui
																		// lub
																		// do
		// gameloop
		int emptySlot;
		// int slot;
		do {
			// slot = player.getSlots(board.getSlots()); // = metoda
			// CKeyHandler.getSlot
			emptySlot = board.findFreeSpot(slot);
			if (emptySlot == -1) {
				return;
			}
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

	private boolean checkIfWin() {
		return this.logic.checkIfWin();
	}

}