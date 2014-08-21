package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;
import atrem.Connect4.Game.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole extends Player implements PlayerController {

	private CKeyHandler keyHandler;
	private int slots;

	public PlayerConsole(Board board, String name, HoleState playerId) {
		super(board, name, playerId);
		keyHandler = new CKeyHandler(board);
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
