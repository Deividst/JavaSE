
public class Recursao {
	
	public static int somaPares(int n, int total) {
		
		if(n % 2 == 0 && n != 0 ) {
			return somaPares(n-1, total+n );
		}
		
		if(n > 0 ) {
			return somaPares(n-1,total);
		}
		return total;
	}
	
	public static int somaInteirosArray(int[] v, int i, int soma) {
		if(i < v.length) {
			return somaInteirosArray(v, i+1, soma+v[i]);
		}
		
		return soma;
	}
	
	public static boolean charInString(String txt, char c,int i) {
		if(i < txt.length()) {
			if(txt.charAt(i) == c) {
				return true;
			}else {
				return charInString(txt, c, i+1);
			}	
		}
		return false;
	}
	
	public static int MDC(int x, int y) {
		if(x >= y &&  x % y == 0) {
			return y;
		}else if(x < y) {
			return MDC(x, y);
		}else {
			return MDC(y, x % y);
		}
		
	}
	
	public static void inverteArray(double[] array, int i, int f) {

		if(i < f){
			double aux;
			aux = array[i];
			array[i] = array[f];
			array[f] = aux;
			inverteArray(array, i+1, f-1);
			
		}
	}
	
	public static void fill(int[][] v, int i, int j, int linha, int coluna) {
		
		
	}
	

	public static void main(String[] args) {
		
		System.out.println(somaPares(3,0));
		
		int[] arrayInt = {1,2,3,4,5};
		
		System.out.println(somaInteirosArray(arrayInt, 0, 0));
		
		String txt = "Maria";
		
		System.out.println(charInString(txt, 't', 0));

	}
	
	

}
