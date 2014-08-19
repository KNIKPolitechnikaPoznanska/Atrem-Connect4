package atrem;

public class Connect4 {

	public static void main(String[] args) {
		PlanszaAlt planszaGry = new PlanszaAlt();
		GUI.rysuj(planszaGry.getPlanszaGry());
		planszaGry.getPlanszaGry()[2][2].setStanDziury(1);
		GUI.rysuj(planszaGry.getPlanszaGry());
	}
}
