

public class Exercicio9 {
	
	public double mediaLinha(int[][] arrei, int linha) {
		
		int coluna = 0;
		double result = 0;
		for (; coluna < arrei.length; coluna++) {
			result += arrei[linha][coluna];
		}
		
		return result/coluna;
		
	}

	public static void main(String[] args) {
		

	}

}
