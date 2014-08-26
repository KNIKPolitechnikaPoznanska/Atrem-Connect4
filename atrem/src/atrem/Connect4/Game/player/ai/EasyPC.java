package atrem.Connect4.Game.player.ai;

import java.util.Random;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private Board board;

	public EasyPC(String name, HoleState playerId, Board board) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.board = board;
	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public void setName(String name) {
		playerAttributes.setName(name);
	}

	@Override
	public HoleState getPlayerId() {
		return playerAttributes.getPlayerId();

	}

	@Override
	public int getSlotNumber() {
		System.out.println("EASYPC");
		int randomSlot;
		int choosenSlot;
		Random rand = new Random();
		do {

			randomSlot = rand.nextInt(board.getSlots());
			choosenSlot = board.findFreeSpot(randomSlot);
		} while (choosenSlot == -1);
		System.out.println(choosenSlot);

		return choosenSlot;
	}

}
