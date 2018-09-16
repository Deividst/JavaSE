
public class Lista11Teste {

	public static void main(String[] args) {
		
		Lista11  lista = new Lista11();
		
		int[]  arreiA = {7, 5, 13};
		int[] arreiB = {13, 7, 5, 5 , 3};
		
		int retorno = lista.verificaArrays(arreiA, arreiB);
				
		System.out.println("Quantidade = " +retorno);
		
		
		String[] nomes = {"Renato", "Luan", "Edilson"};
		
		char[] iniciais = lista.iniciaisNomes(nomes);
		
		System.out.println("Iniciais = " + String.copyValueOf(iniciais));
		
	}

}
