package atrem.connect4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.server.GameControllerService;

/**
 * Urruchamia serwer gry.
 */
public class Connect4Server {
	private static GameController gameController;
	private static RemoteGameController gameCService;
	private static GameConfig gameConfig;
	private static GameFactory gameFactory;

	/**
	 * Uruchamia tylko serwer.
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(1234);

		initServerGameController();

		gameCService = new GameControllerService(gameController);

		registry.bind("RGCS", gameCService);

	}

	public static void initServerGameController() {
		gameConfig = new GameConfig();
		gameFactory = gameConfig.getGameFactory();
		gameConfig.setupServerGameFactory();
		gameFactory.createServerGameController();
		gameController = gameFactory.getGameController();
		System.out.println("Rows: " + gameController.getBoard().getRows()
				+ ", Slots: " + gameController.getBoard().getSlots());
		gameController.setPlayerTurn(PlayerId.PLAYER1);
		System.out.println("Server GameController Initialized.");
	}
}