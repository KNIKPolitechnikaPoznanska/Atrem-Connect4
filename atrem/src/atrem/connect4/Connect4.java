package atrem.connect4;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atrem.connect4.console.Menu;
import atrem.connect4.factory.GameConfig;
import atrem.connect4.factory.GameFactory;
import atrem.connect4.factory.GameModeSelectionBox;
import atrem.connect4.game.GameController;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {
	private GameConfig config;
	private Connect4Client client;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		if (args.length > 0) {
			createConsoleGame();
		} else {
			GameModeSelectionBox gameMode = new GameModeSelectionBox();
			gameMode.setVisible(true);
		}
	}

	/**
	 * Otwiera grê w system bezokienkowych.
	 */
	private static void createConsoleGame() {
		Menu menu = new Menu();
		menu.runGame();
	}

	/**
	 * Otwiera okno ustawieñ Offline.
	 */
	public void createOfflineBox() {
		config = new GameConfig();
		config.showOfflineDBox();
	}

	/**
	 * Otwiera okno ustawieñ Online.
	 */
	public void createOnlineBox() throws RemoteException, NotBoundException {
		config = new GameConfig();
		config.showOnlineDBox();
	}

	/**
	 * Wywo³ane przez OfflineBox do stworzenia gry.
	 * 
	 * @param gameConfig
	 */
	public void createOfflineGame(GameConfig config) {
		GameFactory gameFactory = config.getGameFactory();
		config.setupGameFactory();
		gameFactory.createGameController();
		GameController gameController = gameFactory.getGameController();
		gameController.startGameLoop();
	}

	/**
	 * £aczy z serwerem RMI i uruchamia klienta.
	 * 
	 * @param gameConfig
	 */
	public void createOnlineClientGame(GameConfig gameConfig) {
		String adress = gameConfig.getAdress();
		String name = gameConfig.getPlayer1name();
		int port = gameConfig.getPort();
		Color color = gameConfig.getToken1Color();

		System.out.println("Tworzenie klienta ...");
		try {
			client = new Connect4Client();
			client.connect(adress, port);
			client.createPlayer(name, color);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}
}
