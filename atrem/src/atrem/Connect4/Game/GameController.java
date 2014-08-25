package atrem.Connect4.Game;

import atrem.Connect4.Game.board.HoleState;

public interface GameController {
	public void wykonalemRuch(HoleState playerId, int slot);
}
