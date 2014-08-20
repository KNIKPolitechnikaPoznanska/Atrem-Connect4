package atrem;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rows = 5;
		int slots = 7;

		int[][] tablica = new int[rows][slots];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < slots; j++) {
				tablica[i][j] = 0;
			}

		}

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < slots; j++) {
				tablica[0][j] = 1;
			}

		}
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < slots; j++) {
				System.out.print(tablica[i][j]);

			}
			System.out.println();

		}

	}

}
