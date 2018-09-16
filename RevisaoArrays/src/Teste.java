
public class Teste {

	public static void main(String[] args) {
		
		ExerciciosArrays ex = new ExerciciosArrays(10, 10);
		
		ex.arrei[0][0] = 2;
		ex.arrei[4][4] = 10;
		
		System.out.println(ex.somaDiagonal(ex.arrei));
		
		System.out.println(ex.encontrarPrimos(ex.arrei));

		
	}

}
