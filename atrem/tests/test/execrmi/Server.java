package test.execrmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemoteGameControllerImp;

public class Server {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		System.out.println("Serwer Pre-Initializing");
		GameController gameController;
		gameController = new GameControllerImpl();
		Board board = new Board(6, 7);
		gameController.setBoard(board);
		gameController.setPlayerTurn(PlayerId.PLAYER1);
		RemoteGameController remoteGameController = new RemoteGameControllerImp(
				gameController);
		Registry registry = LocateRegistry.createRegistry(1234);
		registry.bind("gc", remoteGameController);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameController.startGameLoop();

	}
}
