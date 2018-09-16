
public class ApResidencial extends Sala implements RegistroPrefeitura {

	private String nomeProprietario;
	private double area;
	
	public ApResidencial(String nomeProprietario, double area) {
		super();
		this.nomeProprietario = nomeProprietario;
		this.area = area;
	}

	@Override
	public double calcCondominio() {
		return getValor() * this.area; 
		
	}

	@Override
	public double getValor() {
		return this.valorCUB * 2;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}


	public double getArea() {
		return area;
	}


}
