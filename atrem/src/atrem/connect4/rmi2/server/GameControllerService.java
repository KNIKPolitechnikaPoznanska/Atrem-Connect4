package atrem.connect4.rmi2.server;

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
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;

public class GameControllerService extends UnicastRemoteObject
		implements
			RemoteGameController {
	private GameController gameController;

	public GameControllerService(GameController gameController)
			throws RemoteException {
		super();
		this.gameController = gameController;
	}

	@Override
	public int move(int slot) throws RemoteException {
		return gameController.move(slot);
	}

	@Override
	public void startNewGame() throws RemoteException {
		gameController.startNewGame();
	}

	@Override
	public void connectPlayer() throws RemoteException {
		gameController.connectPlayer();
	}

	@Override
	public void startGameLoop() throws RemoteException {
		gameController.startGameLoop();
	}

	@Override
	public void addRemotePlayer(RemotePlayerController remotePlayer)
			throws RemoteException {
		PlayerController playerController = new PlayerControllerSender(
				remotePlayer);
		if (gameController.getPlayer1() == null)
			gameController.setPlayer1(playerController);
		else if (gameController.getPlayer2() == null)
			gameController.setPlayer2(playerController);
	}

	@Override
	public HoleState getHoleState(int rows, int slots) throws RemoteException {
		return gameController.getHoleState(rows, slots);
	}

	@Override
	public void setResult(ResultState result) throws RemoteException {
		gameController.setResult(result);
	}

	@Override
	public PlayerId getPlayerTurn() throws RemoteException {
		return gameController.getPlayerTurn();
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) throws RemoteException {
		gameController.setPlayerTurn(playerTurn);
	}

	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;
	}

	@Override
	public int getEmptySpot() throws RemoteException {
		return gameController.getEmptySpot();
	}

	@Override
	public ResultState getResult() throws RemoteException {
		return gameController.getResult();
	}

	@Override
	public Board getBoard() throws RemoteException {
		return gameController.getBoard();
	}

	@Override
	public PlayerController getPlayer1() throws RemoteException {
		return gameController.getPlayer1();
	}

	@Override
	public void setPlayer1(PlayerController player1) throws RemoteException {
		gameController.setPlayer1(player1);
	}

	@Override
	public PlayerController getPlayer2() throws RemoteException {
		return gameController.getPlayer2();
	}

	@Override
	public void setPlayer2(PlayerController player2) throws RemoteException {
		gameController.setPlayer2(player2);
	}

	@Override
	public GameState getGamestate() throws RemoteException {
		return gameController.getGamestate();
	}

	@Override
	public PlayerController getCurrentPlayer() throws RemoteException {
		return gameController.getCurrentPlayer();
	}

	@Override
	public LastMove getLastMove() throws RemoteException {
		return gameController.getLastMove();
	}

	@Override
	public void setGamestate(GameState gamestate) throws RemoteException {
		gameController.setGamestate(gamestate);
	}

	@Override
	public List<Point> getWinningCoordinates() throws RemoteException {
		return gameController.getWinningCoordinates();
	}

	public GameController getGamecontroller() {
		return gameController;
	}

	@Override
	public void setPlayer1Attributes(PlayerAttributes player1Attributes)
			throws RemoteException {
		gameController.setPlayer1Attributes(player1Attributes);

	}

	@Override
	public void setPlayer2Attributes(PlayerAttributes player2Attributes)
			throws RemoteException {
		gameController.setPlayer2Attributes(player2Attributes);

	}

	@Override
	public PlayerAttributes getPlayer1Attributes() throws RemoteException {
		return gameController.getPlayer1Attributes();
	}

	@Override
	public PlayerAttributes getPlayer2Attributes() throws RemoteException {
		return gameController.getPlayer2Attributes();
	}
}
