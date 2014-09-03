package atrem.Connect4.Game.player.ai;

import java.util.Random;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC implements PlayerController {

	private Logic logic;

	private PlayerAttributes playerAttributes;

	private Board board;
	private Random rand;
	private GameController gamecontroller;

	public MediumPC(String name, HoleState playerId,
			GameController gameController, Logic logic) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);

		this.logic = logic;
		board = gamecontroller.getBoard();
		rand = new Random();
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
	public HoleState getPlayerId() {
		return playerAttributes.getPlayerId();

	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
	}

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		} else
			return emptySpot;

	}

	@Override
	public int loadSlotNumber() {

		int simulatedRow;
		HoleState opp;
		if (playerAttributes.getPlayerId() == HoleState.PLAYER1)
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
		int choosenSlot;
		do {

			randomSlot = rand.nextInt(board.getSlots());
			choosenSlot = board.findFreeSpot(randomSlot);
		} while (choosenSlot == -1);
		return 0;
	}

	@Override
	public PlayerId getPlayerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yourTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshView(int row, int slot) {
		// TODO Auto-generated method stub

	}
}