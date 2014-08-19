package atrem;

public class Board {
	public static int Slots = 4;
	public static int Rows = 4;
	public static Hole[][] planszaGry = new Hole[Slots][Rows];

	public static void main(String[] args) {

		System.out.println("lool");
		for (int i = 0; i < Slots; i++) {
			for (int j = 0; j < Rows; j++) {
				planszaGry[i][j] = new Hole();

				System.out.print(planszaGry[i][j].getStanDziury() + " ");
			}
			System.out.println();
		}

	}

	public Hole[][] getPlanszaGry() {
		return planszaGry;
	}

	public void setPlanszaGry(Hole[][] planszaGry) {
		Board.planszaGry = planszaGry;
	}
}
