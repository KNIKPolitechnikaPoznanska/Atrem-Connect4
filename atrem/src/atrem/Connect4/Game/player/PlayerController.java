package atrem.Connect4.Game.player;

import atrem.Connect4.Game.board.HoleState;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract HoleState getPlayerId();

	public abstract void getSlotNumber();

}