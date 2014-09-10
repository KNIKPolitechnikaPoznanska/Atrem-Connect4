package atrem.connect4;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atrem.connect4.console.Menu;
import atrem.connect4.factory.GameFactory;
import atrem.connect4.factory.GameModeSelectionBox;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameController;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {
	private static GameConfig config;
	private static GameFactory gameFactory;
	private static GameController gameController;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		if (args.length > 0) {
			createConsoleGame();
		} else {
			config = new GameConfig();
			GameModeSelectionBox gameMode = new GameModeSelectionBox();
			gameMode.setVisible(true);
		}
	}

	private static void createConsoleGame() {
		Menu menu = new Menu();
		menu.runGame();
	}

	/**
	 * Otwiera okno ustawieñ Offline.
	 */
	public void createOffline() {
		config.showOfflineDBox();
	}

	/**
	 * Otwiera okno ustawieñ Online.
	 */
	public void createOnline() throws RemoteException, NotBoundException {
		config.showOnlineDBox();

	}

	/**
	 * Wywo³ane przez OfflineBox do stworzenia gry.
	 * 
	 * @param gameConfig
	 * @param gameFactory
	 */
	public void createOfflineGame(GameConfig config) {
		this.config = config;
		this.gameFactory = config.getGameFactory();
		this.config.setupGameFactory();
		this.gameFactory.createGameController();
		this.gameController = gameFactory.getGameController();
		this.gameController.startGameLoop();
	}

	public void connectToServer(GameConfig gameConfig) {
		String adress = gameConfig.getAdress();
		String name = gameConfig.getPlayer1name();
		Color color = gameConfig.getToken1Color();
		System.out.println("Tworzenie klienta ...");
	}
}
