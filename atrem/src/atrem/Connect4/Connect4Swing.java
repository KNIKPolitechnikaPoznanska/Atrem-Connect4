package atrem.Connect4;

import java.awt.EventQueue;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.GameFrame;
import atrem.Connect4.swing.SwingConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4Swing {
	private static GameFactory gamefactory;
	private static SwingConfig config;
	private static Game game;
	private static GameController gameController;

	public static void main(String[] args) {
		gamefactory = new GameFactory();
		config = new SwingConfig();
		gamefactory.setSwingconfig(config);
		gamefactory.createGame("swing");
		game = gamefactory.getGame();
		gameController = new GameController();
		gameController.loadGameController(game);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame(game);
					frame.setTitle("Connect 4");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
