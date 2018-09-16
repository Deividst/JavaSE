
public class SalaComercial extends Sala implements RegistroPrefeitura{
	
	private String registroComercial;
	private double area;
	

	public SalaComercial(String registroComercial, double area) {
		super();
		this.registroComercial = registroComercial;
		this.area = area;
	}

	@Override
	public double calcCondominio() {
		return (getValor() * this.area) * 1.7; 
	}

	@Override
	public double getValor() {
		return this.valorCUB * 3;
	}

	public String getRegistroComercial() {
		return registroComercial;
	}

	public double getArea() {
		return area;
	}
	
	

}
