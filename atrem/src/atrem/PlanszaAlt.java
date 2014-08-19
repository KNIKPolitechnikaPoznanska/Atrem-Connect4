package atrem;

public class PlanszaAlt {

	Hole[][] planszaGry;

	public PlanszaAlt() {
		planszaGry = new Hole[S][W]; // poprawic na zmienne
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < W; j++) {
				planszaGry[i][j] = new Hole();
			}
		}
	}

	public Hole[][] getPlanszaGry() {
		return planszaGry;
	}

	public void setPlanszaGry(Hole[][] planszaGry) {
		this.planszaGry = planszaGry;
	}

	public static final int W = 6, S = 7;

}
