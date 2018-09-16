
public class ArraysProvaGBTeste {

	public static void main(String[] args) {
		
		ArraysProvaGB arrei = new ArraysProvaGB(5);
		Teclado t = new Teclado();
		arrei.preencheArray();
		arrei.exibeArray();
		
		System.out.println(arrei.buscaNumero(t.leInt("Informe o numero para busca")));
		arrei.imprimePosicaoDoMenorValor();
		arrei.valoresPares();
	}

}
