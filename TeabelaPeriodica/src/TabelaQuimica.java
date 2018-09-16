public class TabelaQuimica {

	private ElementoQuimico[][] tabela;

	public TabelaQuimica(int i, int j) {
		this.tabela = new ElementoQuimico[i][j];
	}

	public void setElemento(String simbolo, String nome, int numero, double peso, int linha, int coluna) {
		try {
			this.isValido(linha, coluna);
			tabela[linha][coluna] = new ElementoQuimico(simbolo, nome, numero, peso);

		} catch (IllegalArgumentException e) {
			System.out.print("As indices informados são invalidos");
		}
	}

	public ElementoQuimico getElementoQuimico(int linha, int coluna) {
		try {
			this.isValido(linha, coluna);
		} catch (IllegalArgumentException e) {
			System.out.print("As indices informados são invalidos");
		}
		return tabela[linha][coluna];
	}

	public String getTabela() {
		String todaTabela = "";
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela[i].length; j++) {

				if (i == 0 && j > 0) {
					for (int k = 1; k < 17; k++) {
						todaTabela += "    ";
						j++;
					}
				} else if (i == 1 && j > 1 && j < 12 || i == 2 && j > 1 && j < 12) {
					for (int k = 2; k < 12; k++) {
						todaTabela += "    ";
						j++;
					}
				} else if (i == tabela.length - 1 && j == 11) {
					break;
				}

				if (tabela[i][j] == null) {
					todaTabela += "[" + "  " + "]";
				} else {
					todaTabela += "[" + tabela[i][j].getSimboloElemento() + "]";
				}
			}
			todaTabela += "\n";
		}
		return todaTabela;
	}
	
	
	public void salvaTabela() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void isValido(int linha, int coluna) throws IllegalArgumentException {
		if (linha > tabela.length - 1 && linha < 0 || coluna > tabela[0].length - 1 && coluna < 0) {
			throw new IllegalArgumentException();
		} else if (linha == 0 && coluna > 0 && coluna < 17) {
			throw new IllegalArgumentException();
		} else if (linha == 1 && coluna > 1 && coluna < 12 || linha == 2 && coluna > 1 && coluna < 12) {
			throw new IllegalArgumentException();
		} else if (linha == tabela.length - 1 && coluna > 11) {
			throw new IllegalArgumentException();
		}
	}
}
