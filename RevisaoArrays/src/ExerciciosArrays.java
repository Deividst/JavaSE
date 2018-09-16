
public class ExerciciosArrays {

	int[][] arrei;

	public ExerciciosArrays(int linha, int coluna) {
		arrei = new int[linha][coluna];
	}

	public void imprimeArray(int[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

	public void imprimeArray(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i]);
		}
	}

	public void imprimeLinhaArray(int[][] m, int lin) {
		for (int i = 0; i < m[lin].length; i++) {
			System.out.print(m[lin][i]);
		}
	}

	public void imprimeColunaArray(int[][] m, int col) {
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i][col]);
		}
	}

	public int somaDiagonal(int[][] m) {

		int soma = 0;
		try {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {

					if (m.length == m[i].length) {
						if (i == j) {
							soma += m[i][i];
						}
					} else {
						MinhaExcecao e = new MinhaExcecao("Numero de linhas e colunas são diferentes");
						throw e;
					}
				}

			}

		} catch (MinhaExcecao e) {
			System.out.println(e.toString());
		}

		return soma;

	}
	
	public int[] retornaPares(int[][] m) {
		
		int cont = 0;
		int[] pares = new int[m.length * m[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j] % 2 == 0 ) {
					pares[cont] = m[i][j];
					cont++;
				}
			}
		}
		
		return pares;
	}
	
	public int[] encontrarPrimos(int[][] m) {
		int cont = 0;
		int[] primos = new int[m.length * m[0].length];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				for(int x = 1; x <= i; x++) {
					if(m[i][j] % 1 == 0 && m[i][j] == m[i][j] &&  m[i][j] % x != 0) {
						primos[cont] = m[i][j]; 
						cont++;
					}
				}
			}
		}
		
		return primos;
	}
	
	public double calculaMedia(int[][] m) {
		int cont = 0;
		int total = 0;
		double media;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				cont++;
				total += m[i][j];
			}
		}
		
		return media = total / cont;
		
	}
	
	public double[] calculaMediaLinhas(int[][] m) {
		
		int nrLinha = m.length;
		double arrei[] = new double[nrLinha];
		int cont = 0;
		int soma = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				cont++;
				soma += m[i][j];
			}
			arrei[i] = soma /cont;
			cont = 0;
		}
		
		return arrei;
	}
	
	public double[] calculaMediaColunas(int[][] m) {
		
		int coluna = m[0].length;
		int soma = 0;
		int cont = 0;
		double[] arrei = new double[coluna];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				soma += m[j][i];
				cont++;
			}
			
			arrei[i] = soma / cont;
			cont = 0;
		}
		
		return arrei;
		
	}
	
	public double calculaMedia(int[][] m, int[][] y) {
		
		int cont = 0;
		int soma = 0;
		double media;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				cont++;
				soma += m[i][j];
			}
		}
		
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y[i].length; j++) {
				cont++;
				soma += y[i][j];
			}
		}
		
		return media = soma / cont;
		
	}
	
public int somaArrays(int[][] a, int[][] b) {
		
		int soma = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				soma += a[i][j];
			}
		}
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				soma += b[i][j];
			}
		}
		
		return  soma ;
		
	}
	
	
	
	

}
