package atrem.connect4s.Games.player;

import atrem.connect4s.Games.GameController;
import atrem.connect4s.Games.PlayerId;
import atrem.connect4s.Games.ResultState;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract PlayerId getPlayerId();

	public abstract void yourTurn();

	// public abstract void refreshView(int row, int slot);

	public abstract void setGamecontroller(GameController gamecontroller);

	public abstract void endOfGame(ResultState resultGame);

	public abstract int getPlayerPoints();

}