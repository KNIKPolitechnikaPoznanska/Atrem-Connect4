package atrem.connect4;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multiplayer.IConnect4Server;
import atrem.connect4.console.Menu;
import atrem.connect4.game.GameFactory;
import atrem.connect4.swing.GameModeSelectionBox;

/*
 * Klasa main uruchamiaj¹ca grê Connect4hhh
 */
public class Connect4 {

	private static IConnect4Server connect4Server;
	private static ExecutorService executor;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		if (args.length > 0) {
			GameFactory gameFactory = new GameFactory();
			Menu menu = new Menu(gameFactory);
			menu.runGame();
		} else {
			executor = Executors.newCachedThreadPool();
			GameModeSelectionBox gameMode = new GameModeSelectionBox();
			gameMode.setVisible(true);
			createOffline();
		}
	}

	public static void createOffline() throws RemoteException,
			NotBoundException {
		Runnable serverThread = new Connect4Server();
		executor.execute(serverThread);

		Registry r = LocateRegistry.getRegistry(1234);
		connect4Server = (IConnect4Server) r.lookup("connect4LocalServer");
		new Connect4Client().runOnLocal();
	}

	public static void createOnline() throws RemoteException, NotBoundException {
		Connect4Client client = new Connect4Client();
	}
}
