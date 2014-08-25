package atrem.Connect4.Game.player.ai;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC extends AI implements PlayerController {

	private Logic logic;

	public MediumPC(String name, HoleState playerId, Game game) {
		this.name = name;
		this.playerId = playerId;
		this.game = game;
		this.logic = new Logic(game);
	}

	@Override
	public String getName() {
		return name;
	}

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		}
		return emptySpot;

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;

	}

	@Override
	public int getSlotNumber() {
		int simulatedRow;
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);
			if (simulatedRow == -1)
				continue;
			else {
				// board.setHoleState(simulatedRow, i, HoleState.PLAYER1);

			}

		}
	}
}
