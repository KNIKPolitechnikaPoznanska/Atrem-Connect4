package RMITest;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import atrem.connect4.game.GameState;
import atrem.connect4.game.LastMove;
import atrem.connect4.game.Logic;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class RemoteGameControllerServer extends UnicastRemoteObject
		implements
			RemoteGameController {

	public RemoteGameControllerServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move(int slot) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startNewGame() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void wakeUpGCr() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void analyseDecision() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGameLoop() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void backToMenu() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void wakeUp() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public HoleState getHoleState(int rows, int slots) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(ResultState result) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerId getPlayerTurn() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getEmptySpot() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultState getResult() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getBoard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBoard(Board board) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerController getPlayer1() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer1(PlayerController player1) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerController getPlayer2() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer2(PlayerController player2) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public GameState getGamestate() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerController getCurrentPlayer() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LastMove getLastMove() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGamestate(GameState gamestate) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public Logic getLogic() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> getWinningCoordinates() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
