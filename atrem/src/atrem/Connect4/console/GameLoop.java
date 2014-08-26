package atrem.Connect4.console;

import java.util.Random;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;

/*
 * G³ówna pêtla gry
 * wykorzystywana tylko w konsoli
 * obs³uguj¹ca kolejki graczy
 */
public class GameLoop {// to ju� nie jest potrzebne
	private int doneMoves;
	private Game game;
	private GUIConsole gui = new GUIConsole();
	private Logic logic;
	private Random rnd = new Random();

	public GameLoop(Game game) {
		this.game = game;
		// logic = new Logic(game);
		game.setPlayerTurn(genFirstTurn());
	}

	/**
	 * 
	 * @return gracz, ktory rozpoczyna gre
	 */
	private int genFirstTurn() {
		if (rnd.nextGaussian() < 0.0D) {
			return 1;
		} else {
			return 2;
		}
	}

}
