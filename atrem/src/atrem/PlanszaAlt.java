package atrem;

public class PlanszaAlt {

	Dziura[][] planszaGry;

	public PlanszaAlt() {
		planszaGry = new Dziura[S][W]; // poprawic na zmienne
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < W; j++) {
				planszaGry[i][j] = new Dziura();
			}
		}
	}

	public Dziura[][] getPlanszaGry() {
		return planszaGry;
	}

	public void setPlanszaGry(Dziura[][] planszaGry) {
		this.planszaGry = planszaGry;
	}

	public static final int W = 6, S = 7;

}
