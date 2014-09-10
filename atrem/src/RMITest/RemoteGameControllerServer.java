package RMITest;

import java.awt.Point;
import java.util.List;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.LastMove;
import atrem.connect4.game.Logic;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class RemoteGameControllerServer implements GameController {

	@Override
	public int move(int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startNewGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wakeUpGCr() {
		// TODO Auto-generated method stub

	}

	@Override
	public void analyseDecision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGameLoop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backToMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wakeUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public HoleState getHoleState(int rows, int slots) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(ResultState result) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerId getPlayerTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getEmptySpot() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultState getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerController getPlayer1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer1(PlayerController player1) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerController getPlayer2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer2(PlayerController player2) {
		// TODO Auto-generated method stub

	}

	@Override
	public GameState getGamestate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerController getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LastMove getLastMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGamestate(GameState gamestate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Logic getLogic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> getWinningCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

}
