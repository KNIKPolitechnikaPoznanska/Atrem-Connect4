package atrem.Connect4.Console;

import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;
import atrem.Connect4.Game.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole extends Player implements PlayerController {
	// private String name;
	private CKeyHandler keyHandler;
	private int maxSlots;

	public PlayerConsole(int slots, String name, HoleState playerId) {
		super(slots, name, playerId);
	}

	@Override
	public int getSlots(int slots) {
		slots = keyHandler.getSlot(maxSlots);
		return slots;
	}

	@Override
	public final void setName(String name) {
		super.setName(name);
	}

}
