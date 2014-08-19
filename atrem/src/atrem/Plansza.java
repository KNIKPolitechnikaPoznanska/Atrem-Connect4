package atrem;

public class Plansza {
	public static int S = 3;
	public static int W = 3;

	public static void main(String[] args) {

		Dziura[][] planszaGry = new Dziura[S][W];
		System.out.println("lool");
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < W; j++) {
				planszaGry[i][j].setStanDziury(0);

				System.out.print(planszaGry[i][j].getStanDziury() + " ");
			}
			System.out.println();
		}

	}
}
