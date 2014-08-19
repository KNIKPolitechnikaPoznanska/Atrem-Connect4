package atrem;

public class GUI {

	public static void rysuj(Hole[][] planszaGry) {
		for (int i = 0; i < planszaGry.length; i++) {
			for (int j = 0; j < planszaGry[i].length; j++) {
				if (planszaGry[i][j].getStanDziury() == HoleState.EMPTY)
					System.out.print("x");
				else if (planszaGry[i][j].getStanDziury() == HoleState.PLAYER1)
					System.out.print("1");
				else if (planszaGry[i][j].getStanDziury() == HoleState.PLAYER2)
					System.out.print("2");
			}
			System.out.println("");

		}
	}

}
