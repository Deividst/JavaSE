
public class ExerciciosPublucPrivate {
	
	
	private static int exponencialRecursivo(int m, int n) {
		
		if(n  == 0) {
			return 1;
		}else {
			int aux = exponencialRecursivo(m, n/2);
			if(n % 2 == 0) {
				return aux * aux;
				
			}else {
				return aux * aux  * m;
			}
		}
	}
	
	public static int exponencial(int m, int n) {
		if( n == 0) {
			return 1;
		}
		
		return exponencialRecursivo(m, n);
	}
	
	private static void inverteArray(double[] array, int i, int f) {

		if(i < f){
			double aux;
			aux = array[i];
			array[i] = array[f];
			array[f] = aux;
			inverteArray(array, i+1, f-1);
			
		}
	}
	
	public static void inverteArray(double[] array) {
		if( array != null) {
			inverteArray(array, 0, array.length);
		}
	}
	
	private static void imprimeChar(char[][] c, int i, int j) {
		if(i < c.length) {
			if(j >= c[i].length) {
				System.out.println();
				imprimeChar(c, i+1, 0);
			}else {
				System.out.print("[" + c[i][j] + "]");
				imprimeChar(c, i, j+1);
			}
		}
	}
	
	public static void imprimeChar(char[][] c) {
		if(c != null) {
			imprimeChar(c, 0, 0);
		}
	}
	
	
	private static int qtdAlunosReprovados(Aluno[][] alunos, int i, int j, int qtd) {
		
		if(i < alunos.length) {
			if(j >= alunos[i].length) {
				return qtdAlunosReprovados(alunos, i+1, 0, qtd);
			}else {
				if(alunos[i][j].getNotafinal() < 6) {
					qtd += 1;
				}
				return qtdAlunosReprovados(alunos, i, j+1, qtd);
			}
		}
		return qtd;
	}
	
	public static int qtdAlunosReprovados(Aluno[][] alunos) {
		if(alunos == null) {
			return 0;
		}
		
		return qtdAlunosReprovados(alunos, 0, 0, 0);
	}
	
	
	private static void padovan(int n,int i, int primeiro, int segundo,int terceiro,int proximo) {
		
		if(i <= n -3) {
			proximo = primeiro + segundo;
			System.out.println(proximo);
			padovan(n, i+1, segundo, terceiro, proximo, proximo);
		}
	}
	
	public static void padovan(int n) {
		if(n != 0) {
			padovan(n, 0, 1, 1, 1, 0);
		}
	}
	private static boolean isPalindromo(String n, int i, int j, char[] c, boolean is) {
		if( i < j) {
			if(c[i] == c[j]) {
				is = true;
				return isPalindromo(n, i+1, j-1, c, is);
			}else {
				return false;
			}
		}
		
		return is;
	}
	
	public static boolean isPalindromo(String n) {
		char[] c;
		if(n == null) {
			return false;
		}
		c = n.toCharArray();
		return isPalindromo(n, 0, c.length -1, c, true);
	}
	
	private static int menorInteiro(int[] array, int i, int menor) {
		if(i < array.length) {
			if(array[i] <= menor ) {
				menor = array[i];
				return menorInteiro(array, i+1, menor);
			}
		}
		
		return menor;
	}
	
	public static int menorInteiro(int[] array) {
		int menor = array[0];
		if(array == null ) {
			return -1;
		}
		
		return menorInteiro(array, 0, menor);
	}
	
	
	private static int menorBidimencional(int[][] array, int i, int j, int menor) {
		if(i < array.length) {
			if(j >= array[i].length) {
				return menorBidimencional(array, i+1, 0, menor);
			}else {
				if(array[i][j] <= menor) {
					menor = array[i][j];
				}
				
				return menorBidimencional(array, i, j+1, menor);
			}
		}
		
		return menor;
	}
	
	public static int menorBidimencional(int[][] array) {
		int menor = array[0][0];
		if( array == null) {
			return -1;
		}
		
		return menorBidimencional(array, 0, 0, menor);
	}
	
	
	
	
	private static boolean matrizIdentidade(int[][] a, int i, int j, boolean isIdentidade) {
		
		
			if(i < a.length) {
				if(j >= a[i].length) {
					matrizIdentidade(a, i+1, 0, isIdentidade);
				}else {
					if( i == j && a[i][j] == 1 ) {
							return matrizIdentidade(a, i, j+1, true);
						}
					if(i == j && a[i][j] != 1 ) {
						return false;
					}
					if ( i != j && a[i][j] != 0) {
						return false;
					}
					matrizIdentidade(a, i, j+1, isIdentidade);
				}
			}

		return isIdentidade;
	}
	
	public static boolean matrizIdentidade(int[][] a) {
		if(a == null) {
			return false;
		} else if (a.length != a[0].length) {
			return false;
		}
		
		return matrizIdentidade(a, 0, 0, true);
	}
	
	public String conversaoParaBinario(int n) {
        if(n < 0) {
            return null;
        }
        return conversaoParaBinarioRecursivo(n,"");
    }
   
    private String conversaoParaBinarioRecursivo(int n, String binario) {
        if(n > 0) {
            Integer bin = n % 2;
            binario += bin.valueOf(bin);
            return conversaoParaBinarioRecursivo(n/2, binario);
        }
        return binario;
    }
    
    public static void selectionSort(int[] a) {
    	int min = 0;
    	for (int i = 0; i < a.length-1; i++) {
    		min = i; // mínimo inicial 
    		for (int j = i+1; j < a.length; j++)
    			if (a[j] < a[min])
    				min = j;  // acha o novo mínimo
    		int T = a[i];  // coloca o novo mínimo (min)
    		a[i] = a[min]; // na posição correta (i)
    		a[min] = T;
    	}
    }

	
	
	public static void main(String[] args) {
		
		
		
		System.out.println(exponencial(2, 4));
		
		
		double[] array = {1,2,3,4,5};
		int[][] identidade = new int[5][5];
		for (int i = 0; i < identidade.length; i++) {
			for (int j = 0; j < identidade[i].length; j++) {
				if( i == j) {
					identidade[i][j] = 1;
				}else {
					identidade[i][j] = 0;
				}
			}
			
		}
		
		for (int i = 0; i < identidade.length; i++) {
			for (int j = 0; j < identidade[i].length; j++) {
				System.out.print("[" + identidade[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println(matrizIdentidade(identidade));
		
		
		Aluno[][] a = new Aluno[5][5];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new Aluno();
				a[i][j].setNotafinal(Math.random() * 10);
				System.out.printf("%.2f%s",a[i][j].getNotafinal(),"  ");
			}
			System.out.println();
		}
		
		System.out.println(qtdAlunosReprovados(a));	
		
		String n = "mussum";
		System.out.println(isPalindromo(n));
		
		int[] arrayInteiros = {10,5,3,2,8};
		
		selectionSort(arrayInteiros);
		
		System.out.println(menorInteiro(arrayInteiros));
		
		int[][] intBi = new int[5][5];
		for (int i = 0; i < intBi.length; i++) {
			for (int j = 0; j < intBi[i].length; j++) {
				intBi[i][j] = (int) (Math.random() * 100) + 1;
				System.out.print(intBi[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(menorBidimencional(intBi));
		System.out.println();
		padovan(16);
		
	}

}
