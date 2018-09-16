
public class Proprietario {
	private String nome;

	// acumula tudo que o proprietario gasta com o
	// abastecimento de/ TODOS os seus carros
	private double despesaCombustivel;

	public Proprietario(String nome) {
		this.nome = nome;
	}

	public void abasteceCarro(double valor) {
		despesaCombustivel += valor;
	}

	public String toString() {
		return "Nome: " + this.nome + 
			 "\nGasto com combustivel: R$ " + this.despesaCombustivel;
	}

	public String getNome() {
		return nome;
	}

	public double getDespesaCombustivel() {
		return despesaCombustivel;
	}
}

