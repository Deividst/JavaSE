

public class Edificio extends Edificacao {
	
	private int qtdElevadores;
	private int qtdVagasBox;
	private Sala condominio[];
	private int totSalasOcupadas;
	
	
	
	public Edificio(int qtdAndares, String material, double areaConstruida, int qtdElevadores,
			int qtdVagasBox, int qtdSalas) {
		super(qtdAndares, material, areaConstruida);
		
		try {
		this.qtdElevadores = qtdElevadores;
		this.qtdVagasBox = qtdVagasBox;
		this.condominio = new Sala[qtdSalas];
		}catch (IllegalArgumentException e) {
			System.out.println("Os valores informados são incorretos");
		}
	}
	public int isQtdElevadores() {
		return qtdElevadores;
	}
	public void setQtdElevadores(int qtdElevadores) {
		this.qtdElevadores = qtdElevadores;
	}
	public int isQtdVagasBox() {
		return qtdVagasBox;
	}
	public void setQtdVagasBox(int qtdVagasBox) {
		this.qtdVagasBox = qtdVagasBox;
	}
	
	public void ocupaSala(Sala sala) {
		for (int i = 0; i < condominio.length; i++) {
			if(condominio[i] == null ) {
				condominio[i] = sala;
			}
		}
	}
	public Sala[] getCondominio() {
		return condominio;
	}
	
	
	
	
	

}
