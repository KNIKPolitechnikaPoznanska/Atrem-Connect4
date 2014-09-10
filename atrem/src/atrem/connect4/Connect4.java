package atrem.connect4;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import multiplayer.IConnect4Server;
import atrem.connect4.console.Menu;
import atrem.connect4.factory.GameFactory;
import atrem.connect4.factory.GameModeSelectionBox;
import atrem.connect4.game.GameConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4hhh
 */
public class Connect4 {

	private static IConnect4Server connect4Server;
	private static GameConfig config;
	private static GameFactory gameFactory;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		if (args.length > 0) {
			GameFactory gameFactory = new GameFactory();
			Menu menu = new Menu(gameFactory);
			menu.runGame();
		} else {
			GameModeSelectionBox gameMode = new GameModeSelectionBox();
		}
	}

	public static void createOffline() throws RemoteException,
			NotBoundException {
		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);
		config.showOfflineDBox();
	}
	public static void createOnline() throws RemoteException, NotBoundException {
		Connect4Client client = new Connect4Client();
		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);
		config.showOnlineDBox();
	}
}
