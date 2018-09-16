
public class Teste {

	public static void main(String[] args) {
		
		
		ArCondicionado ar = new ArCondicionado(20);
		
		System.out.println(ar.getTemperaturaAtual());
		ar.aumentaTemperatura(10);
		System.out.println(ar.getTemperaturaAtual());
		ar.diminuiTemperatura(25);
		System.out.println(ar.getTemperaturaAtual());
		ar.aumentaTemperatura(30);
		System.out.println(ar.getTemperaturaAtual());
		
		try {
			ar.diminuiTemperatura2(20);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: Valor informado é invalido...");
		}
		
		Carro c = new Carro(60,30,9.8);
		
		System.out.println(c.distanciaPossivel());
		
		System.out.println(c.combustivelGasto(300));
		
		System.out.println(c.getNivelTanque());
		
		c.encherTanque(30);
		
		System.out.println(c.getNivelTanque());
		
		System.out.println(c.distanciaPossivel());
		
		c.andar(588);
		
		System.out.println(c.getNivelTanque());
		
		
		
	}

}
