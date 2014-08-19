package atrem;

public class GUI {

	public static void rysuj(Hole[][] planszaGry) {
		for (int i = 0; i < planszaGry.length; i++) {
			for (int j = 0; j < planszaGry[i].length; j++) {
				if (planszaGry[i][j].getStanDziury() == Hole.PUSTY)
					System.out.print("x");
				else if (planszaGry[i][j].getStanDziury() == Hole.GRACZ_1)
					System.out.print("1");
				else if (planszaGry[i][j].getStanDziury() == Hole.GRACZ_2)
					System.out.print("2");
			}
			System.out.println("");

		}
	}

}
