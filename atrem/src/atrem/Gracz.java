package atrem;

public class Gracz {
	private String imie;
	private static int idStat = 1;
	private int id;

	public Gracz(String imie) {
		this.imie = imie;
		this.id = idStat;
		this.idStat++;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
