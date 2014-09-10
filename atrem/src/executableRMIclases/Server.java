package executableRMIclases;

import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.RemoteGameController;
import rmi.RemoteGameControllerImp;
import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerController;

public class Server {

	private PlayerController player1, player2;
	private PlayerController playerControllerService;

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		System.out.println("serwer start");
		GameController gameController;
		gameController = new GameControllerImpl();
		Board board = new Board(6, 7);
		gameController.setBoard(board);
		RemoteGameController remoteGameController = new RemoteGameControllerImp(
				gameController);
		Registry registry = LocateRegistry.createRegistry(6969);
		try {
			registry.bind("GC", remoteGameController);
		} catch (java.rmi.AlreadyBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("wyj¹tek registru");
		}

	}

}
