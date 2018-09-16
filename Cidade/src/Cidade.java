


public class Cidade {

	private Terreno[][] mapa;
	private String nome;
	
	public Terreno[][] getMapa() {
		return mapa;
	}

	public void setMapa(Terreno[][] mapa) {
		this.mapa = mapa;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade(int linha, int coluna, String nome) {
		
		super();
		try { 
		this.nome = nome;
		this.mapa = new Terreno[linha][coluna];

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = new Terreno(5, null);
			}
		}
		
		}catch (IllegalArgumentException e) {
			System.out.println("Os Valores informados são incorretos!");
		}

	}


	public void associa(int linha, int coluna, Edificacao edificacao) {

		try {
		if (mapa[linha][coluna].getEdificacao() != null) {

			System.out.println("Este terreno não está disponivel!");
		} else {
			mapa[linha][coluna].setEdificacao(edificacao);
		}
		
		}catch (IllegalArgumentException e) {
			System.out.println("Os Valores informados são incorretos!");
		}

	}

	

	public void visualizarMapa() {

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {

				if (mapa[i][j].getEdificacao() instanceof Casa) {
					System.out.print("C ");
				} else if (mapa[i][j].getEdificacao() instanceof Edificio) {
					System.out.print("E ");
				} else {

					System.out.print("* ");
				}

			}
			System.out.println();
		}

	}

	public void calculaIPTU(int linha1, int coluna1,int linha2, int coluna2){
		
		double iptuCasas = 0;
		double iptuEdificios = 0;
		double terrenoVazio = 0;
		
		for (int i = linha1; i <= linha2; i++) {
			for (int j = coluna1; j <= coluna2; j++) {
				
				if(mapa[i][j].getEdificacao() instanceof Casa){
				String material = mapa[i][j].getEdificacao().getMaterial();
				
					if(material.equalsIgnoreCase("alvenaria")){
						iptuCasas += (mapa[i][j].getArea() * 1.5) + (mapa[i][j].getEdificacao().getAreaConstruida() * 1.12);
				} else if(material.equalsIgnoreCase("madeira")){
					iptuCasas += (mapa[i][j].getArea() * 1.5) + (mapa[i][j].getEdificacao().getAreaConstruida() * 1.04);
				}
					
					if(((Casa) mapa[i][j].getEdificacao()).isComPiscina() == true){
						iptuCasas += 2.3;
					}
						
					} else if(mapa[i][j].getEdificacao() instanceof Edificio){
						
						iptuEdificios += (mapa[i][j].getArea() * 1.4) + 
								(mapa[i][j].getEdificacao().getQtdAndares() * 0.3) + 
								(mapa[i][j].getEdificacao().getAreaConstruida() * 1.3) + 
								(((Edificio)mapa[i][j].getEdificacao()).getQtdAndares() * 0.2) + 
								(((Edificio)mapa[i][j].getEdificacao()).isQtdVagasBox() * 0.15);
						
					} else {
						terrenoVazio += mapa[i][j].getArea() * 1.75;
						
					}

				
			}
		}
		
		System.out.println("IPTU das Casas: " + iptuCasas);
		System.out.println("IPTU dos Edificios: " + iptuEdificios);
		System.out.println("IPTU Terrenos Vazio: " + terrenoVazio);
			
		}
	
	public void removerEdificacao(int linha, int coluna) {
		
		mapa[linha][coluna].setEdificacao(null);
		
	}
	
	public void pesquisarTerreno() {
		
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				
				if(mapa[i][j].getEdificacao() instanceof Casa && ((Casa)(mapa[i][j].getEdificacao())).getAreaConstruida() > 80 && ((Casa)(mapa[i][j].getEdificacao())).isComGaragem() == true) {
					
					System.out.println("O Terreno de localização: Linha: " + i + " Coluna: " + j + " Atende os criterios da pesquisa do Exemplo.");
				}
		}
		
	}

	}
	
	public int qtdCasas() {
		int qtdCasa = 0;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if(mapa[i][j].getEdificacao() instanceof Casa) {
					qtdCasa++;
				}
			}
		}
		
		return qtdCasa;
	}
}
