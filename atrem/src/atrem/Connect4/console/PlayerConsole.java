package atrem.Connect4.console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.player.Player;
import atrem.Connect4.Game.player.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole extends Player implements PlayerController {

	private KeyHandler keyHandler;
	private int slots;

	public PlayerConsole(Board board, String name, HoleState playerId) {
		super(board, name, playerId);
		keyHandler = new KeyHandler(board);
	}

	@Override
	public int getSlotNumber() {
		slots = keyHandler.getSlot();
		return slots;
	}

	@Override
	public final void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;
	}

}