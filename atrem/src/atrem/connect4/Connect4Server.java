package atrem.connect4;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameController;
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
	private static List<GameController> gControllers;

	/**
	 * Uruchamia tylko serwer.
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException, UnknownHostException {
		Registry registry = LocateRegistry.createRegistry(1234);
		InetAddress myHost = Inet4Address.getLocalHost();
		String myIP = myHost.getHostAddress();
		gControllers = new ArrayList<GameController>();

		for (int i = 0; i < 5; i++) {

			RemoteGameController rgController = initServerGameController();

			System.out.println("Rows: " + gameController.getBoard().getRows()
					+ ", Slots: " + gameController.getBoard().getSlots());
			System.out.println("Server GameController Initialized.");
			System.out.println("Adres serwera: " + myIP);
			registry.bind("RGCS", gameCService);

			gameController.startGameLoop();
		}
	}

	public static RemoteGameController initServerGameController()
			throws RemoteException {
		gameConfig = new GameConfig();
		gameFactory = gameConfig.getGameFactory();
		gameConfig.setupServerGameFactory();
		gameFactory.createServerGameController();
		GameController listedGameController = gameFactory.getGameController();
		gameCService = new GameControllerService(listedGameController);
		return gameCService;
	}
}