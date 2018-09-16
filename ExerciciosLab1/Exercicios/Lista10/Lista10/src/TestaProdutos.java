
public class TestaProdutos {
	public static void main(String[] args) {
		
		Teclado t = new Teclado();
		
		Deposito d = new Deposito(t.leInt("Informe o tamanho do estoque"));
		
		d.insereProdutos();
		d.exibeEstoque();
		System.out.println(d.precoMaisBaixo());
		System.out.println(d.produtoMaisCaro());
		System.out.println(d.precoMedio());
		System.out.println(d.buscaProduto(t.leInt("Informe o codigo para busca")));
		
		
	}

}
