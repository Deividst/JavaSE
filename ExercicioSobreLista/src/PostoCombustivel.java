
public class PostoCombustivel implements Cloneable {
	private String nome;
	private double valorGasolina;
	private double valorAlcool;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorGasolina() {
		return valorGasolina;
	}
	public void setValorGasolina(double valorGasolina) {
		this.valorGasolina = valorGasolina;
	}
	public double getValorAlcool() {
		return valorAlcool;
	}
	public void setValorAlcool(double valorAlcool) {
		this.valorAlcool = valorAlcool;
	}
	
	PostoCombustivel(String nome, double valorAlcool){
		this.nome = nome;
		this.valorAlcool = valorAlcool;
	}
	@Override
	public String toString() {
		return "Posto [nome=" + nome + ", Alcool=" + valorAlcool
				+ "]";
	}
	
	public PostoCombustivel clone() throws CloneNotSupportedException{
		return (PostoCombustivel)super.clone();
	}

}
