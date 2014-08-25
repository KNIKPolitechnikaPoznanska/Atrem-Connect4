package atrem.Connect4.Game.player.ai;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC implements PlayerController {

	private Logic logic;

	private PlayerAttributes playerAttributes;
	private Game game;

	public MediumPC(String name, HoleState playerId, Game game) {
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.game = game;
		this.logic = new Logic(game);
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

		int emptySpot = game.getBoard().findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		}
		return emptySpot;

	}

	@Override
	public int getSlotNumber() {

		int simulatedRow;
		for (int i = 0; i < game.getBoard().getSlots(); i++) {
			simulatedRow = simulatedGo(i);
			if (simulatedRow == -1)
				continue;
			else {
				// board.setHoleState(simulatedRow, i, HoleState.PLAYER1);

			}

		}
	}
}
