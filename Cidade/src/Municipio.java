
public class Municipio {

	private Cidade[] cidades;

	public Municipio(int qtdCidades) {
		super();
		this.cidades = new Cidade[qtdCidades];
	}

	public void insereCid(Cidade cidade) {

		for (int i = 0; i < cidades.length; i++) {
			if (cidades[i] == null) {
				cidades[i] = cidade;
				break;
			}
		}
	}

	public void mostraMunicipio() {
		for (int i = 0; i < cidades.length; i++) {

			if (cidades[i] != null) {
				System.out.println("Cidade: " + cidades[i].getNome());
			}

		}

	}

	public void removeCid(String nomeCidade) {
		for (int i = 0; i < cidades.length; i++) {
			if (cidades[i] != null && cidades[i].getNome().equalsIgnoreCase(nomeCidade)) {
				cidades[i] = null;
			}
		}
	}

	public double numMedioCasas() {

		int totalCasas = 0;
		int totalCidade = 0;
		for (int m = 0; m < cidades.length; m++) {
			if (cidades[m] != null) {
				for (int i = 0; i < cidades[m].getMapa().length; i++) {
					for (int j = 0; j < cidades[m].getMapa()[i].length; j++) {

						if (cidades[m].getMapa()[i][j].getEdificacao() != null) {
							totalCidade++;
							totalCasas += cidades[m].qtdCasas();

						}
					}
				}
			}
		}

		return totalCasas / totalCidade;
	}
	
	
	public void ocupaSala(Sala sala) {
		for (int i = 0; i < cidades.length; i++) {
			if (cidades[i] != null) {
				for (int j = 0; j < cidades[i].getMapa().length; j++) {
					for (int k = 0; k < cidades[i].getMapa()[j].length; k++) {
						if (cidades[i].getMapa()[j][k].getEdificacao() != null) {
							if (cidades[i].getMapa()[j][k].getEdificacao() instanceof Edificio) {
								Sala[] ed = ((Edificio) cidades[i].getMapa()[j][k].getEdificacao()).getCondominio();
								for (int l = 0; l < ed.length; l++) {
										if(ed[l] == null) {
											ed[l] = sala;
											break;
										}
								}
							}

						}

					}
				}
			}

		}
		
	}
	
	

	public void mostrarSalas() {
		for (int i = 0; i < cidades.length; i++) {
			if (cidades[i] != null) {
				for (int j = 0; j < cidades[i].getMapa().length; j++) {
					for (int k = 0; k < cidades[i].getMapa()[j].length; k++) {
						if (cidades[i].getMapa()[j][k].getEdificacao() != null) {
							if (cidades[i].getMapa()[j][k].getEdificacao() instanceof Edificio) {
								Sala[] ed = ((Edificio) cidades[i].getMapa()[j][k].getEdificacao()).getCondominio();
								for (int l = 0; l < ed.length; l++) {
										if(ed[l] instanceof ApResidencial) {
											System.out.println("Apartamento Residencial");
											System.out.println("Proprietario :" + ((ApResidencial)ed[l]).getNomeProprietario());
											System.out.println("Area: " + ((ApResidencial)ed[l]).getArea());
										} else if(ed[l] instanceof SalaComercial) {
											System.out.println("Apartamento Comercial");
											System.out.println("Registro Comercial: " + ((SalaComercial)ed[l]).getRegistroComercial());
											System.out.println("Area: " + ((SalaComercial)ed[l]).getArea());
										}
								}
							}
							System.out.println("");

						}

					}
				}
			}

		}
	}
	

}
