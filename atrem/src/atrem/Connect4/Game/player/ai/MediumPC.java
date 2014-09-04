package atrem.Connect4.Game.player.ai;

import java.util.Random;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC implements PlayerController {

	private Logic logic;

	private PlayerAttributes playerAttributes;

	private Board board;
	private Random rand;
	private GameController gameController;

	public MediumPC(GameController gameController, String name,
			PlayerId playerId, Logic logic) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.gameController = gameController;
		this.logic = logic;
		board = gameController.getBoard();
		rand = new Random();
		gameController.endInitPlayer();
	}

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		} else
			return emptySpot;

	}

	public int findSlotToMove() {

		int simulatedRow;
		HoleState opp;
		if (board.playerIdtoHoleState(playerAttributes.getPlayerId()) == HoleState.PLAYER1)
			opp = HoleState.PLAYER2;
		else
			opp = HoleState.PLAYER1;
		// wywakic ^^
		for (int i = 0; i < board.getSlots(); i++) {// tu mamy x
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			else {

				board.setHoleState(simulatedRow, i,
						playerAttributes.getPlayerId());

				if (logic.checkIfWinPC() == true) {// wiem ze mozna lepiej
					board.cleanSpot(simulatedRow, i);

					return i;
				} else {
					board.cleanSpot(simulatedRow, i);

				}
			}

		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			else {
				board.setHoleState(simulatedRow, i, opp);
				if (logic.checkIfWinPC() == true) {// wiem ze mozna lepiej
					board.cleanSpot(simulatedRow, i);
					return i;
				} else
					board.cleanSpot(simulatedRow, i);
			}

		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			if (simulatedRow == board.getLastRow() // sprawdzanei ten sam level
					&& (i == board.getLastSlot() - 1 || i == board
							.getLastSlot() + 1)) {
				return i;
			}

		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			if (i == board.getLastSlot() - 1 || i == board.getLastSlot() + 1) {
				return i;

			}

		}
		int randomSlot;
		int choosenSpot;
		do {

			randomSlot = rand.nextInt(board.getSlots());
			choosenSpot = board.findFreeSpot(randomSlot);
		} while (choosenSpot == -1);
		return randomSlot;
	}

	@Override
	public void yourTurn() {
		gameController.move(findSlotToMove());

	}

	@Override
	public void endOfGame(ResultState resultGame) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public void setName(String name) {
		playerAttributes.setName(name);
	}

	@Override
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;
	}
}