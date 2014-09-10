package rmi;

import java.awt.Point;
import java.rmi.RemoteException;
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

public class GameControllerService implements GameController {
	RemoteGameController remoteGameController;

	public GameControllerService(RemoteGameController remoteGameController) {
		this.remoteGameController = remoteGameController;
	}

	@Override
	public int move(int slot) {
		try {
			return remoteGameController.move(slot);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
		return 0;
	}

	@Override
	public void startNewGame() {
		try {
			remoteGameController.startNewGame();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void wakeUpGCr() {
		try {
			remoteGameController.wakeUpGCr();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public void analyseDecision() {

	}

	@Override
	public void run() {

	}

	@Override
	public void startGameLoop() {
		try {
			remoteGameController.startGameLoop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public void backToMenu() {

	}

	@Override
	public void wakeUp() {
		try {
			remoteGameController.wakeUp();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public HoleState getHoleState(int rows, int slots) {
		try {
			return remoteGameController.getHoleState(rows, slots);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setResult(ResultState result) {

	}

	@Override
	public PlayerId getPlayerTurn() {
		return remoteGameController.getPlayerTurn();
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
