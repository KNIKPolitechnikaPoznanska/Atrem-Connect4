package atrem.connect4.game.player;

import java.awt.Color;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String playerName);

	public abstract PlayerId getPlayerId();

	public abstract void yourTurn();

	// public abstract void refreshView(int row, int slot);

	public abstract void setGamecontroller(GameController gamecontroller);

	public abstract void endOfGame(ResultState resultGame);

	public abstract int getPlayerPoints();

	public abstract PlayerAttributes getPlayerAttributes();

	public Color getColor();

	public Color getOppColor();

	public void setPlayerId(PlayerId playerId);

	public void opponentConnected();
}