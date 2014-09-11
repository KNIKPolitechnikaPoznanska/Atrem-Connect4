package testy.game.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.console.Menu;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.RemoteGameFactory;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;

public class Player1 {

	private static RemoteGameFactory remoteGameFactory;
	private GameConfig config;
	private Menu menu;
	private static PlayerAttributes player1;

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {

		// TODO Auto-generated method stub

		// GameController Connect4 = (GameController) r.lookup("connect");
		// LocalPlayerController player = new LocalPlayerControlerImpl();
		/**
		 * connect
		 */

		RemotePlayerController player = new RemotePlayerControlerImpl();
		// Registry r = LocateRegistry.getRegistry("10.7.7.152", 80);
		// Registry r = LocateRegistry.getRegistry("10.7.7.155", 1234);
		Registry r = LocateRegistry.getRegistry(80);
		RemoteGameController connect = (RemoteGameController) r
				.lookup("connect");
		GameController gameController = new LocalGameController(connect);
		PlayerId playerId = connect.addPlayer(player);
		player.createPlayer(gameController, playerId);
		/**
		 * odpowiednik connect 4
		 */
		if (args.length > 0) {
			// gameFactory = new GameFactory();
			// menu = new Menu(gameFactory);
			// menu.runGame();
		} else {
			remoteGameFactory = new RemoteGameFactory();
			player1 = remoteGameFactory.getPlayer();
			// player1.getAtt;
			// config = new GameConfig(gameFactory);
			// config.setDBox();
		}
		/**
		 * tworzy remote board
		 */
		// GameController gameController = new LocalGameController(connect);
		// connect.addPlayer(player);
		// player.createPlayer(gameController);

	}
}
