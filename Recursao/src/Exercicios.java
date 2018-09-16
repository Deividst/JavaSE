
public class Exercicios {
	
	//1
	public static int f(int x) {
		int res;
		if(x<4) res= 3*x;
		else res = 2*f(x-4)+5;
		return res;
	}
	
	//(2) = 6, f(4) = 5, f(9) = 27
	
	//2
	public static int soma(int n, int num) {
		
		//soma(int n){
		//if( n <= 0) return 0;
		//if(n == 1) return 1;
		//return n + soma(n - 1);
		//}
		
		
		if(n > 0) {
			n-=1;
			num+=1;
			return soma(n, num);
		}
		return num;
	}
	
	//3
	public static int somaVetor(int[] v, int i) {
		if(i < v.length) {
			return v[i] + somaVetor(v, ++i);
		}else {
			return 0;
		}
		
	}
	
	//4
	public static int MDC(int x, int y) {
		if(x >= y &&  x % y == 0) {
			return y;
		}else if(x < y) {
			return MDC(x, y);
		}else {
			return MDC(y, x % y);
		}
		
	}
	
	//5
	public static boolean verificar(String texto, char c, int i) {
		if(i > texto.length() -1 || texto == null) {
			return false;
		}else {
			char compare;
			compare = texto.charAt(i);
			if(compare == c) {
				return true;
			}
			i= i+1;
			return verificar(texto, c, i);
		}
	}
	
	//6
	
	
	
	public static void main(String[] args) {
		
		System.out.println(soma(10,0));
		
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		System.out.println(somaVetor(array, 0));
		
		System.out.println(MDC(16,24));
	
	}
}
