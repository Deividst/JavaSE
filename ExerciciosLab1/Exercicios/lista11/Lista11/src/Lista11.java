
public class Lista11 {

	public int verificaArrays(int[] a, int[] b) {
		
		int cont = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	public char[] iniciaisNomes(String[] nomes) {
		
		char[] retorno = new char[nomes.length];
		
		for (int i = 0; i < nomes.length; i++) {
			retorno[i] = nomes[i].charAt(0);
		}
		
		return retorno;
	}
	
	
	
	
}
