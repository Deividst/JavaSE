


public class Casa extends Edificacao {
	
	private boolean comGaragem;
	private boolean comPiscina;
	
	
	
	public Casa(int qtdAndares, String material, double areaConstruida, boolean comGaragem, boolean comPiscina) {
		super(qtdAndares, material, areaConstruida);
		this.comGaragem = comGaragem;
		this.comPiscina = comPiscina;
	}
	public boolean isComGaragem() {
		return comGaragem;
	}
	public void setComGaragem(boolean comGaragem) {
		this.comGaragem = comGaragem;
	}
	public boolean isComPiscina() {
		return comPiscina;
	}
	public void setComPiscina(boolean comPiscina) {
		this.comPiscina = comPiscina;
	}
	
	
}
