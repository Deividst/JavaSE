package outros;



public class Exercicio4 {
	
	
	public int retornaLinha (double[][] linhas){
		
		return linhas.length;
	}

	public static void main(String[] args) {
		
		
		double arrei[][] = new double[10][10];
		
		Exercicio4 ex = new Exercicio4();
		System.out.println(ex.retornaLinha(arrei));

		
		
	}

}
