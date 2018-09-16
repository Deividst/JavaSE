

public class Exercicio6 {
	
	public String retornaString(double[][] matriz ){
		
		String texto = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				texto += String.valueOf(matriz[i][j]);
			}
			
			texto += "\n";
		}
		
		
		return  texto;
		
	}

	public static void main(String[] args) {
		
		Exercicio6 ex = new Exercicio6();
		
		double[][] arrei = new double[10][10];
		
		ex.retornaString(arrei);

	}

}