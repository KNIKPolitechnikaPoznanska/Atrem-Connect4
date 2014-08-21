package atrem.Connect4.Console;

import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;
import atrem.Connect4.Game.PlayerController;

/*
 * Klasa obs³uguj¹ca gracza konsolowego
 */
public class PlayerConsole extends Player implements PlayerController {

	private CKeyHandler keyHandler;

	public PlayerConsole(int maxSlots, String name, HoleState playerId) {
		super(maxSlots, name, playerId);
		keyHandler = new CKeyHandler();
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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;
	}

}
