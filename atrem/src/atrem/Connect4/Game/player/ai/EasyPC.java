package atrem.Connect4.Game.player.ai;

import java.util.Random;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

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
		System.out.println(choosenSlot);

		return choosenSlot;
	}

}
