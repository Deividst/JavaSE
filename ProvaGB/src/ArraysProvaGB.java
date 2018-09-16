
public class ArraysProvaGB {
	
	private int[] v; // declara um atributo de tipo array int

	public ArraysProvaGB(int tamanho){ 
		this.v = new int[tamanho];	//instancia o obj array
	}
	
	/** Preenche v com valores randomicos */
	public void preencheArray() {
		for (int i = 0; i < v.length; i++) {
			v[i] = (int) (1 + (Math.random() * 50));
		}
	}

	/**  Exibe os valores de v **/
	public void exibeArray() {
		for (int i = 0; i < v.length; i++) {
			System.out.println("Array v[" + i + "] = " + v[i]);
		}
	}	
	
	/** Retorna true se o a valor x aparece no array do atributo v */ 
	// + boolean buscaNumero(int x)
	
	public boolean buscaNumero(int x) {
		for (int i = 0; i < v.length; i++) {
			if (v[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	
	/** Imprime a posicao do menor valor do array v */
	// + void imprimePosicaoDoMenorValor()
	
	public void imprimePosicaoDoMenorValor() {
		int menor = v[0];
		int pos = 0;
		
		for (int i = 0; i < v.length; i++) {
			if(v[i] < menor) {
				menor = v[i];
				pos = i;
			}
		}
		System.out.println("Posição do menor numero:"+ pos);
	}

	/** Retorna um array contendo somente os valores pares do array v */
	// + int[] valoresPares()
	
	public int[] valoresPares() {
		int tamanho = 0;
		for (int i = 0; i < v.length; i++) {
			if(v[i] % 2 == 0) {
				tamanho++;
			}
		}
		
		int [] arrayPar = new int[tamanho];
		int j=0;
		for (int i = 0; i < v.length; i++) {
			if(v[i] % 2 == 0) {
				arrayPar[j] = v[i];
				j++;
			}
		}
		
		return arrayPar;
		
	}

}
