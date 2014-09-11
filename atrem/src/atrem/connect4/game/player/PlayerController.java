package atrem.connect4.game.player;

import java.io.Serializable;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;

public interface PlayerController extends Serializable {

	public abstract String getName();

	public abstract void setName(String playerName);

	public abstract PlayerId getPlayerId();

	public abstract void yourTurn();

	// public abstract void refreshView(int row, int slot);

	public abstract void setGamecontroller(GameController gamecontroller);

	public abstract void endOfGame(ResultState resultGame);

	public abstract int getPlayerPoints();

	public abstract PlayerAttributes getPlayerAttributes();

}