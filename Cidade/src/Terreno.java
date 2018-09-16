


public class Terreno {

	private double area;
	private Edificacao edificacao;
	
	
	public Terreno(double area, Edificacao edificacao) {
		super();
		this.area = area;
		this.edificacao = edificacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Edificacao getEdificacao() {
		return edificacao;
	}
	public void setEdificacao(Edificacao edificacao) {
		this.edificacao = edificacao;
	}
	
	
	
}
