package atrem.Connect4.Game.player.ai;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.player.PlayerController;

public class MediumPC extends AI implements PlayerController {

	private Logic logic;

	public MediumPC(String name, HoleState playerId, Game game) {
		this.name = name;
		this.playerId = playerId;
		this.board = game.getBoard();
		this.game = game;
		logic = new Logic(game);

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
		for(int i=0; i<board.getSlots(); i++)
			

	}
}
