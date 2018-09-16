/** Alunos : Deivid dos Santos Thomé Trabalho GA Lab 1 */
public class Parcela {

	private Cliente cliente;
	private Data dataVencimento;
	private double valorOriginal;
	private double valorFinal;
	private char situacao;

	public Parcela(Cliente cliente, Data dataVencimento, double valorOriginal) {
		this.cliente = cliente;
		this.dataVencimento = dataVencimento;
		this.valorOriginal = valorOriginal;
		this.valorFinal = this.valorOriginal;
		this.situacao = 'N';

	}

	public Data getDataVencimento() {
		return dataVencimento;
	}

	public boolean registrarAtraso() {
        Data d = new Data();
        if(situacao == 'N' && d.obtemDataInvertida() > dataVencimento.obtemDataInvertida()) {

            this.situacao = 'A';
            return true;

        } else {
            return false;

        }
    }

	

	public double pagar(Data d) {
		d = new Data();
		int dias = d.diasDeOutraData(this.dataVencimento);
		double juros = 0;
		if (situacao == 'A') {

			if (dias <= 5) {
				juros = this.valorOriginal * (1 / 100);
				this.valorFinal += juros;

			} else if (dias > 6 && dias <= 15) {
				juros = this.valorOriginal * (1.5 / 100);
				this.valorFinal += juros;
			} else if (dias > 15) {
				juros = this.valorOriginal * (2.5 / 100);
				this.valorFinal += juros;
			}

		} 
		
		cliente.pagarParcela(this.valorFinal);
		this.situacao = 'Q';
		return juros;
		
		
	}

	public String traduzirSituacao() {
		if (this.situacao == 'N') {
			return "Não venceu ainda";
		}else if (this.situacao == 'Q') {
			return "Quitada";
		}else {
			return "Em atraso";
	}
	}
	
	public void exibirDados(int numeroParcela) {
		System.out.println("Numero da Parcela: " + numeroParcela
							+"\n"+ "Nome Cliente: " + cliente.getNome()
							+"\n"+ "Data de vencimento: " + dataVencimento.obtemDataPadrao()
							+"\n"+ "Valor Original: " + this.valorOriginal
							+"\n"+ "Situação: " + traduzirSituacao());
	}
		
	public double getValorFinal() {
		return valorFinal;
	}

	public double getValorOriginal() {
		return valorOriginal;
	}

}
