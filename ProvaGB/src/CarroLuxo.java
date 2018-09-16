
public class CarroLuxo extends Carro {
	
	private boolean arCondicionadoLigado;

	public CarroLuxo(String placa, double consumoMedio, Proprietario dono) {
		super(placa, consumoMedio, dono);
		
	}
	
	double consumoAr = this.getConsumoMedio() * 0.1;
	
	public void ligaAr() {
		this.setConsumoMedio(this.getConsumoMedio() + consumoAr);
		this.arCondicionadoLigado = true; 
		
	}
	public void desligaAr() {
		this.setConsumoMedio(this.getConsumoMedio() - consumoAr);
		this.arCondicionadoLigado = false;
		
	}
	
	public void computadorDeBordo() {
		System.out.println("Nome: " + this.getDono().getNome());
		System.out.println("Despesa Total com combustivel: $ " + this.getDono().getDespesaCombustivel());
		System.out.println("Consumo médio: " + this.getConsumoMedio());
		System.out.println("Nivel atual do tanque: " + this.getNivelTanque());
	}

}
