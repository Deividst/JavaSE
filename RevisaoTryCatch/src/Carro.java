
public class Carro {
	
	private double capMaximaTanque;
	private double nivelTanque;
	private double qtdKmLitro;
	
	
	public Carro(double capMaximaTanque, double nivelTanque, double qtdKmLitro) {
		super();
		try {
			if(nivelTanque > capMaximaTanque ) {
				throw new IllegalArgumentException();
			}
			
		} catch (IllegalArgumentException e) {
			System.out.println("O Nivel do tanque não pode ser superior a capacidade maxíma!");
		}
		this.capMaximaTanque = capMaximaTanque;
		this.nivelTanque = nivelTanque;
		this.qtdKmLitro = qtdKmLitro;
	}


	public double getCapMaximaTanque() {
		return capMaximaTanque;
	}


	public void setCapMaximaTanque(double capMaximaTanque) {
		this.capMaximaTanque = capMaximaTanque;
	}


	public double getNivelTanque() {
		return nivelTanque;
	}


	public void setNivelTanque(double nivelTanque) {
		this.nivelTanque = nivelTanque;
	}


	public double getQtdKmLitro() {
		return qtdKmLitro;
	}


	public void setQtdKmLitro(double qtdKmLitro) {
		this.qtdKmLitro = qtdKmLitro;
	}
	
	public void encherTanque(double qtdCombustivel) {
		
		try {
			if(qtdCombustivel + this.nivelTanque > this.capMaximaTanque) {
				throw new TanqueCheioException();
			}
			
			this.nivelTanque += qtdCombustivel;
			
		} catch (TanqueCheioException e) {
			e.getMessage();
		}
		
	}
	
	public double distanciaPossivel() {
		return this.nivelTanque * this.qtdKmLitro;
	}
	
	public double combustivelGasto(double distancia) {
	
			double combustivelGasto = 0;
		try {
			if(distancia > distanciaPossivel()) {
				throw new TanqueInsuficienteException();
			}
			
			combustivelGasto = distancia / qtdKmLitro;
			this.nivelTanque -= combustivelGasto;
			
		} catch (TanqueInsuficienteException e) {
			System.out.println(e.getMessage());
			combustivelGasto = -1;
		}
		
		return combustivelGasto;
	}
	
	
	public void andar(double distancia) {
		
		double combustivelGasto = 0;
		try {
			
			if(distancia > distanciaPossivel()) {
				throw new TanqueInsuficienteException();
			}
			
			combustivelGasto = distancia / qtdKmLitro;
			this.nivelTanque -= combustivelGasto;
			
			
			if(this.nivelTanque == 0) {
				throw new TanqueVazioException();
			}

			
		} catch (TanqueVazioException | TanqueInsuficienteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
