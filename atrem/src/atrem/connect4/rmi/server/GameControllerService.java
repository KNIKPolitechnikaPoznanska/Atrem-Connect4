package atrem.connect4.rmi.server;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.LastMove;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.rmi.client.PlayerControllerClient;

public class GameControllerService extends UnicastRemoteObject
		implements
			RemoteGameController {
	private GameController gamecontroller;

	public GameControllerService(GameController gameController)
			throws RemoteException {
		super();
		this.gamecontroller = gameController;
	}

	public void setGamecontroller(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
	}

	@Override
	public int move(int slot) throws RemoteException {
		return gamecontroller.move(slot);
	}

	@Override
	public void startNewGame() throws RemoteException {
		gamecontroller.startNewGame();
	}

	@Override
	public void connectPlayer() throws RemoteException {
		gamecontroller.addPlayer();
	}

	@Override
	public void analyseDecision() throws RemoteException {
		gamecontroller.analyseDecision();
	}

	@Override
	public void startGameLoop() throws RemoteException {
		gamecontroller.startGameLoop();
	}

	@Override
	public void backToMenu() throws RemoteException {
		gamecontroller.backToMenu();
	}

	@Override
	public void addRemotePlayer(RemotePlayerController remotePlayer)
			throws RemoteException {
		PlayerController playerController = new PlayerControllerClient(
				remotePlayer);
		if (gamecontroller.getPlayer1() == null)
			gamecontroller.setPlayer1(playerController);
		else if (gamecontroller.getPlayer2() == null)
			gamecontroller.setPlayer2(playerController);
	}

	@Override
	public HoleState getHoleState(int rows, int slots) throws RemoteException {
		return gamecontroller.getHoleState(rows, slots);
	}

	@Override
	public void setResult(ResultState result) throws RemoteException {
		gamecontroller.setResult(result);
	}

	@Override
	public PlayerId getPlayerTurn() throws RemoteException {
		return gamecontroller.getPlayerTurn();
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) throws RemoteException {
		gamecontroller.setPlayerTurn(playerTurn);
	}

	@Override
	public int getEmptySpot() throws RemoteException {
		return gamecontroller.getEmptySpot();
	}

	@Override
	public ResultState getResult() throws RemoteException {
		return gamecontroller.getResult();
	}

	@Override
	public Board getBoard() throws RemoteException {
		return gamecontroller.getBoard();
	}

	@Override
	public PlayerController getPlayer1() throws RemoteException {
		return gamecontroller.getPlayer1();
	}

	@Override
	public void setPlayer1(PlayerController player1) throws RemoteException {
		gamecontroller.setPlayer1(player1);
	}

	@Override
	public PlayerController getPlayer2() throws RemoteException {
		return gamecontroller.getPlayer2();
	}

	@Override
	public void setPlayer2(PlayerController player2) throws RemoteException {
		gamecontroller.setPlayer2(player2);
	}

	@Override
	public GameState getGamestate() throws RemoteException {
		return gamecontroller.getGamestate();
	}

	@Override
	public PlayerController getCurrentPlayer() throws RemoteException {
		return gamecontroller.getCurrentPlayer();
	}

	@Override
	public LastMove getLastMove() throws RemoteException {
		return gamecontroller.getLastMove();
	}

	@Override
	public void setGamestate(GameState gamestate) throws RemoteException {
		gamecontroller.setGamestate(gamestate);
	}

	@Override
	public List<Point> getWinningCoordinates() throws RemoteException {
		return gamecontroller.getWinningCoordinates();
	}

	public GameController getGamecontroller() {
		return gamecontroller;
	}
}
