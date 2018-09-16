

public class Exercicios {

	public static void main(String[] args) {
		
		int arrei[][] = new int[3][10];
		int arreiQuadrado[][] = new int[5][10];
		int arreiLinha[][] = new int[6][6];
		int arreiUltimo[][] = new int[9][6];
		
		
		for (int i = 0; i < arrei.length; i++) {
			for (int j = 0; j < arrei[i].length; j++) {
				arrei[i][j] = j;
				System.out.print(arrei[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("Arrei Quadrado");
		
		for (int i = 0; i < arreiQuadrado.length; i++) {
			for (int j = 0; j < arreiQuadrado[i].length; j++) {
				arreiQuadrado[i][j]= (int) Math.pow(j, 2);
				System.out.print(arreiQuadrado[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Arrei = Linha");
		
		for (int i = 0; i < arreiLinha.length; i++) {
			for (int j = 0; j < arreiLinha[i].length; j++) {
				arreiLinha[i][j] = i;
				System.out.print(arreiLinha[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Arrei Ultimo");
		
		for (int i = 0; i < arreiUltimo.length; i++) {
			for (int j = 0; j < arreiUltimo[i].length; j++) {
				if( i % 2 == 0){
					arreiUltimo[i][j] = -1;
				}else {
					arreiUltimo[i][j] = 0;
				}
				
				System.out.print(arreiUltimo[i][j] + " ");
			}
			System.out.println();
		}
	}

}
