package atrem.Connect4.Game;

import java.util.Random;

public class EasyPC extends AI implements PlayerController {

	public EasyPC(String name, HoleState playerId, Board board) {
		this.name = name;
		this.playerId = playerId;
		this.board = board;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;

	}

	@Override
	public int getSlotNumber() {
		int randomSlot;
		int choosenSlot;
		Random rand = new Random();
		do {
			randomSlot = rand.nextInt(board.getSlots());
			choosenSlot = board.findFreeSpot(randomSlot);
		} while (choosenSlot == -1);
		return choosenSlot;
	}

}
