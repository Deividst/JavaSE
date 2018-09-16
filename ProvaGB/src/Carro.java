
public class Carro {
	private String placa;
	private Proprietario dono;
	private double consumoMedio; // quantos km o carro roda com 1 litro
	private double nivelTanque; // quantidade de combustivel no tanque

	public Carro(String placa, double consumoMedio, Proprietario dono) {
		this.placa = placa;
		this.dono = dono;
		this.consumoMedio = consumoMedio;
	}
	
	public boolean abastece(int qtdLitros, double precoLitro) {
		if ((qtdLitros+ this.nivelTanque) <= 60) {
			this.nivelTanque += qtdLitros;
			dono.abasteceCarro(precoLitro * qtdLitros);
			return true;
		}
		
		return false;
	}
	
	// Crie e complete um metodo com a seguinte assinatura:
	// + abastece(qtdLitros : int, precoLitro : double) : void 
	// Este metodo recebe a quantidade de litros de combustivel a ser adicionada ao tanque e 
	// o preco por litro deste combustivel. A capacidade maxima do tanque eh sempre 60 litros. 
	// Se a quantidade a ser abastecida for causar o transbordamento do tanque, entao o 
	// abastecimento nao deve ser feito e o metodo deve retornar false para indicar este insucesso. 
	// Caso contrario, o tanque sera devidamente abastecido.
	// O metodo deve atualizar o atributo nivelTanque e o atributo despesaCombustivel (do dono do carro),
	// bem como deve retornar true, indicando que a operacao teve sucesso.

	/* Método simula uma viagem do carro. Se o carro não tem combustível no tanque
	suficiente para percorrer a distância, retornar false (neste caso, o carro não anda). 
	Em caso contrário, o carro percorre a distância (em km), gasta combustível do tanque e
	o método retorna true */
	public boolean anda (int distancia) {
		int litrosConsumo = (int) (distancia / this.consumoMedio);
		if (litrosConsumo > this.nivelTanque) {
			System.out.println("Nao ha combustivel suficiente para o carro andar.");
			return false;
		} else {
			this.nivelTanque -= litrosConsumo;
			System.out.println("Carro percorreu " + distancia + " km, nivel do tanque atual = " + this.nivelTanque);
			return true;
		}
	}

	public String toString() {
		return "Carro [placa=" + this.placa + ", dono=" + this.dono + ", consumoMedio=" + 
			this.consumoMedio + ", nivelTanque=" + this.nivelTanque + "]";
	}

	public void setDono(Proprietario dono) {
		this.dono = dono;
	}

	public void setConsumoMedio(double consumoMedio) {
		this.consumoMedio = consumoMedio;
	}
	
	public String getPlaca() {
		return placa;
	}

	public Proprietario getDono() {
		return dono;
	}

	public double getNivelTanque() {
		return nivelTanque;
	}

	public double getConsumoMedio() {
		return consumoMedio;
	}


}
