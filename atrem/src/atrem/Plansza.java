package atrem;

public class Plansza {
	public static int Slots = 4;
	public static int Rows = 4;
	public static Dziura[][] planszaGry = new Dziura[Slots][Rows];

	public static void main(String[] args) {

		System.out.println("lool");
		for (int i = 0; i < Slots; i++) {
			for (int j = 0; j < Rows; j++) {
				planszaGry[i][j] = new Dziura();

				System.out.print(planszaGry[i][j].getStanDziury() + " ");
			}
			System.out.println();
		}

	}

	public Dziura[][] getPlanszaGry() {
		return planszaGry;
	}

	public void setPlanszaGry(Dziura[][] planszaGry) {
		Plansza.planszaGry = planszaGry;
	}
}
