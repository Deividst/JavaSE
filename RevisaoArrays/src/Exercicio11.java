

public class Exercicio11 {

	public void substitui(int[] arrei) {
		for (int i : arrei) {
			if (arrei[i] % 2 == 0) {
				arrei[i] = 1;
			} else if( arrei[i] % 2 != 0) {
				arrei[i] = -1;
			}
		}
		
	}
		
	public static void main(String[] args) {
	
	}

}
