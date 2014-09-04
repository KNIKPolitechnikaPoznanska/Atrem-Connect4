package atrem.Connect4.Game.player;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract PlayerId getPlayerId();

	public abstract void yourTurn();

	// public abstract void refreshView(int row, int slot);

	public abstract void setGamecontroller(GameController gamecontroller);

	public abstract void endOfGame(ResultState resultGame);
}