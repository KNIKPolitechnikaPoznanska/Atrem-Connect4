package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4Swing implements Runnable {
	private static GameFactory gameFactory;
	private static SwingConfig config;
	private static GameController gameController;
<<<<<<< HEAD
=======
	private static SwingPresenter swingPresenter1, swingPresenter2; // po co
																	// skoro nie
																	// ma new
																	// PAWE£
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		InitializeConfig();
	}

<<<<<<< HEAD
	private static void runGame() {
=======
	private static synchronized void runGame() { // po co synchronized? PAWE£
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
		gameFactory.setSwingconfig(config);
		gameFactory.createGame("swing");
<<<<<<< HEAD
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		// try {
		// GameFrame frame = new GameFrame();
		// frame.setVisible(true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// // gameController.gameLoop();
=======
		gameFactory.loadGameController(); // tu gdzies powinno byc wywolane
											// createPlayerGAME() PAWE£
		gameController = gameFactory.getGameController(); // po co tutaj
															// gamecontroler?
															// PAWE£
		try {
			GameFrame frame = new GameFrame(); // tutej sie tworzy GameFrame
												// ktory nie ma
												// zaimplementowanej komunikacji
												// z modelem PAWE£
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// gameController.gameLoop();
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
	}

	private static void InitializeConfig() {

		config = new SwingConfig();

		config.setDBox();
	}

	@Override
	public void run() { //
		runGame();
		// runRunGame();
		// runRunRunGame();
		// runRunRunRunGame();
		// brum brum brum GAME
		// PAWEL
	}
}
