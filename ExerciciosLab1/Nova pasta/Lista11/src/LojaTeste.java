
public class LojaTeste {

	public static void main(String[] args) {
		
		Loja loja = new Loja(5);
		
		loja.exibeArray();
		
		Pessoa[] arreiRetorno = loja.ordenaPorAno();
		
		imprimirArrayPessoas(arreiRetorno);
		
		loja.mediaPontos();
		
		loja.pessoaMaisVelha();
	}

	private static void imprimirArrayPessoas(Pessoa[] arreiRetorno) {
		System.out.print("[");
		for (int i = 0; i < arreiRetorno.length; i++) {
			System.out.print(arreiRetorno[i].getAnoNascimento() + " ");
		}
		System.out.print("]\n");

		
	}

}
