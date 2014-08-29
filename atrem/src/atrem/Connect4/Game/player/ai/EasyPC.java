package atrem.Connect4.Game.player.ai;

import java.util.Random;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class EasyPC implements PlayerController {

	private PlayerAttributes playerAttributes;
	private Board board;
	private Game game;
	private GameController gamecontroller;

	public EasyPC(String name, HoleState playerId, Game game) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.game = game;
		this.board = game.getBoard();
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
	public void setGamecontroller(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
	}

	@Override
	public int loadSlotNumber() {
		System.out.println("EASYPC");
		int randomSlot;
		int choosenRow;
		Random rand = new Random();
		do {

			randomSlot = rand.nextInt(board.getSlots());
			choosenRow = board.findFreeSpot(randomSlot);
		} while (choosenRow == -1);

		return randomSlot;
	}

}
