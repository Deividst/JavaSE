
public class Cliente extends Pessoa {

	private int pontos;

	public Cliente(String nome, int ano, int pontos) {
		super(nome, ano);
		this.pontos = pontos;
	}

	public int getPontos() {
		return pontos;
	}

}
