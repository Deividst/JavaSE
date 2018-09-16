package outros;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		
		double arrei[][] = new double[2][5];
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < arrei.length; i++) {
			for (int j = 0; j < arrei[i].length; j++) {
				arrei[i][j] = s.nextInt();
				System.out.print("Linha[" + i + "]" + "Coluna" + ",[" + j + "]" +   arrei[i][j] + " ");
			}
			System.out.println();
		}

	}

}
