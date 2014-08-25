package atrem.Connect4.Game.player.ai;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC implements PlayerController {

	private Logic logic;

	private PlayerAttributes playerAttributes;
	private Game game;
	private Board board;

	public MediumPC(String name, HoleState playerId, Game game) {
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.game = game;
		this.logic = new Logic(game);
		board = game.getBoard();
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

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		}
		return emptySpot;

	}

	@Override
	public int getSlotNumber() {

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
				if (logic.checkIfWin() == true) {// wiem ze mozna lepiej
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
			else {
				board.setHoleState(simulatedRow, i, opp);
				if (logic.checkIfWin() == true) {// wiem ze mozna lepiej
					board.cleanSpot(simulatedRow, i);
					return i;
				} else
					board.cleanSpot(simulatedRow, i);
			}

		}

	}
}