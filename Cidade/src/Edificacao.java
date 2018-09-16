


public class Edificacao {
	
	
	private int qtdAndares;
	private String material;
	private double areaConstruida;
	
	
	
	public Edificacao(int qtdAndares, String material, double areaConstruida) {
		super();
		try {
		this.qtdAndares = qtdAndares;
		this.material = material;
		this.areaConstruida = areaConstruida;
		}catch (IllegalArgumentException e) {
			System.out.println("Os valores informados são incorretos");
		}
	}
	public int getQtdAndares() {
		return qtdAndares;
	}
	public void setQtdAndares(int qtdAndares) {
		this.qtdAndares = qtdAndares;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getAreaConstruida() {
		return areaConstruida;
	}
	public void setAreaConstruida(double areaConstruida) {
		this.areaConstruida = areaConstruida;
	}
	
	

}
