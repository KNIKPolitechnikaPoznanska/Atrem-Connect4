package atrem.Connect4.Game.player.ai;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC extends AI implements PlayerController {

	public MediumPC(String name, HoleState playerId, Board board) {
		this.name = name;
		this.playerId = playerId;
		this.board = board;
	}

	@Override
	public String getName() {
		return name;
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

	}
}
