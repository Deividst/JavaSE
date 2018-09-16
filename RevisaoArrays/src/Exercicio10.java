

import java.util.Scanner;

public class Exercicio10 {
	
	public int[] devolveMatriz() {
		Scanner s = new Scanner(System.in);
		
		int[] arrei = new int[10];
		
		for (int i : arrei) {
			arrei[i] = s.nextInt();
		}
		
		return arrei;
		
	}

	public static void main(String[] args) {
		

	}

}
