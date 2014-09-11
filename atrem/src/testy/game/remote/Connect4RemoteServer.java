package testy.game.remote;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerId;

public class Connect4RemoteServer {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		// TODO Auto-generated method stub
		// GameController Connect4 = new GameControllerImpl();
		// r.bind("Connect4", r);
		/**
		 * establish connection
		 */
		GameController gameController = new GameControllerImpl();
		Board board = new Board(7, 6);
		gameController.setBoard(board);
		gameController.setPlayerTurn(PlayerId.PLAYER1);

		RemoteGameController connect = new RemoteGameControllerImpl(
				gameController);

		Registry r = LocateRegistry.createRegistry(1234);

		r.bind("connect", connect);
		/**
 * 
 */
		gameController.startGameLoop();
	}
}
