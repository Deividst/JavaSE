
public class Produto {

	private int codigo;
	private double preco;

	public Produto(int c, double p) {
		codigo = c;
		preco = p;
	}

	public void exibeProduto(){ 
		System.out.println(codigo + " – R$ " + preco);
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}

}
