package atrem.Connect4.Game.player;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract PlayerId getPlayerId();

	public abstract void yourTurn();

	public abstract void goView(int row, int slot);

	public abstract void setGamecontroller(GameController gamecontroller);

}