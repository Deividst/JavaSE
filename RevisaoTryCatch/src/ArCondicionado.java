
public class ArCondicionado {
	
	private int temperaturaAtual;

	public ArCondicionado(int temperaturaAtual) {
		super();
		this.temperaturaAtual = temperaturaAtual;
	}
	
	public int getTemperaturaAtual() {
		return this.temperaturaAtual;
	}
	
	
	public void aumentaTemperatura(double tempMais){
		try {
			if(temperaturaAtual + tempMais < 16 || temperaturaAtual + tempMais > 32) {
				throw new IllegalArgumentException();
			}
			this.temperaturaAtual += tempMais;
			
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: O Valor informado é invalido....");
		}
		
	}
	
	public void diminuiTemperatura(double tempMenos){
		try {
			if(temperaturaAtual - tempMenos < 16 || temperaturaAtual - tempMenos > 32) {
				throw new IllegalArgumentException();
			}
			this.temperaturaAtual -= tempMenos;
			
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: O Valor informado é invalido....");
		}
		
		
	}
	
	public void aumentaTemperatura2(double tempMais) throws IllegalArgumentException {
		
			if(temperaturaAtual + tempMais < 16 || temperaturaAtual + tempMais > 32) {
				throw new IllegalArgumentException();
			}
			this.temperaturaAtual += tempMais;

	}
	
	public void diminuiTemperatura2(double tempMenos){
		
			if(temperaturaAtual - tempMenos < 16 || temperaturaAtual - tempMenos > 32) {
				throw new IllegalArgumentException();
			}
			this.temperaturaAtual -= tempMenos;
		
		
	}
	


}
