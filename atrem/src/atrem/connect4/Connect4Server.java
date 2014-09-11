package atrem.connect4;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.factory.GameConfig;
import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameController;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemoteGameControllerImp;

/**
 * Urruchamia serwer gry.
 */
public class Connect4Server {
	private static int PORT = 1234;
	private static GameController gameController;
	private static RemoteGameController remoteGameController;
	private static GameConfig gameConfig;
	private static GameFactory gameFactory;

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

		System.out.println("Serwer Pre-Initializing");
		initServerGameController();

		System.out.println("Rows: " + gameController.getBoard().getRows()
				+ ", Slots: " + gameController.getBoard().getSlots());
		System.out.println("Server GameController Initializing.");

		Registry registry = LocateRegistry.createRegistry(PORT);
		InetAddress myHost = Inet4Address.getLocalHost();
		String myIP = myHost.getHostAddress();
		System.out.println("Adres serwera: " + myIP + ":" + PORT);
		registry.bind("RGC", remoteGameController);

		System.out.println("Server GameController Initialized.");

		waitForPlayersToInit();
		System.out.println("Starting Game ...");
		gameController.startGameLoop();
		System.out.println("Game should be started.");
	}

	public static void initServerGameController() throws RemoteException {
		gameConfig = new GameConfig();
		gameFactory = gameConfig.getGameFactory();
		gameConfig.setupServerGameFactory();
		gameFactory.createServerGameController();
		gameController = gameFactory.getGameController();
		remoteGameController = new RemoteGameControllerImp(gameController);
	}

	private static void waitForPlayersToInit() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}