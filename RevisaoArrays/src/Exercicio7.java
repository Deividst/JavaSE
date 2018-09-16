

public class Exercicio7 {
	
	public double retornaMaior(double[][] arrei) {
			
		double maior = 0;
		for (int i = 0; i < arrei.length; i++) {
			for (int j = 0; j < arrei[i].length; j++) {
				if(maior < arrei[i][j]) {
					maior = arrei[i][j];
				}
			}
		}
		
		return maior;
		
		}
		

	public static void main(String[] args) {
	
		Exercicio7 ex = new Exercicio7();
		
		double[][] arrei = new double[10][10];
		
		ex.retornaMaior(arrei);
		
	}

}
