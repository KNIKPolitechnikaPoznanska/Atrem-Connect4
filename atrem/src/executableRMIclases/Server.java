package executableRMIclases;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.RemoteGameController;
import rmi.RemoteGameControllerImp;
import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerId;

public class Server {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		System.out.println("serwer start");
		GameController gameController;
		gameController = new GameControllerImpl();
		Board board = new Board(6, 7);
		gameController.setBoard(board);
		gameController.setPlayerTurn(PlayerId.PLAYER1);
		RemoteGameController remoteGameController = new RemoteGameControllerImp(
				gameController);
		Registry registry = LocateRegistry.createRegistry(80);
		registry.bind("gc", remoteGameController);

		System.out.println("wyj¹tek registru");

		while (true)
			;

	}
}
