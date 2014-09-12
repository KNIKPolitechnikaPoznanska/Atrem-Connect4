package executableRMIclases;

import java.rmi.AccessException;
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

	public Server() {
		System.out.println("serwer start");
		GameController gameController;
		gameController = new GameControllerImpl();
		Board board = new Board(6, 7);
		gameController.setBoard(board);
		gameController.setPlayerTurn(PlayerId.PLAYER2);
		RemoteGameController remoteGameController = null;
		try {
			remoteGameController = new RemoteGameControllerImp(gameController);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(80);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			registry.bind("gc", remoteGameController);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		gameController.startGameLoop();

	}
}
