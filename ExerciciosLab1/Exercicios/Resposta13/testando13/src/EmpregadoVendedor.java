
public class EmpregadoVendedor extends Empregado {

	/**
	 * - um array que totaliza o valor das vendas feitas pelo vendedor em cada
	 * dia do mes. Por exemplo, se o vendedor fez duas vendas no dia 21 do mes,
	 * de R$ 100,00 e de R$ 55,00, a posicao 21 do array contera o valor 155.00.
	 */
	private double[] totalVendasPorDia;

	/** - o valor total das comissoes do mes. */
	private double totalComissaoMes;

	/**
	 * Construtor: recebe 3 parametros, nome, salario mensal e mes do ano
	 * (inteiro de 1 a 12). Deve instanciar o array dos totais diarios de
	 * vendas, dimensionando-o de acordo com a quantidade de dias do mes. Para
	 * fevereiro, use sempre 28 dias, desconsiderando a existencia dos anos
	 * bissextos.
	 */
	public EmpregadoVendedor(String nome, double salarioMensal, int mes) {
		super(nome, salarioMensal);
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			this.totalVendasPorDia = new double[31];
		} else if (mes == 2) {
			this.totalVendasPorDia = new double[28];
		} else {
			this.totalVendasPorDia = new double[30];
		}
	}

	/**
	 * chamado cada vez que o vendedor realiza uma venda. Recebe o dia do mes em
	 * que a venda ocorreu e o valor da venda.
	 */
	public void fazVenda(int dia, double valorVenda) {
		for (int i = 0; i < totalVendasPorDia.length; i++) {
			if ((dia - 1) == i) {
				totalVendasPorDia[i] += valorVenda;
			}
		}
	}

	/**
	 * recebe o valor da taxa de comissao por parametro e calcula a comissao
	 * total do mes do vendedor.
	 */
	public void calculaComissao(double taxa) {
		this.totalComissaoMes = totalVendasMes() * (taxa / 100);
	}

	private double totalVendasMes() {
		double somaVendas = 0;
		for (int i = 0; i < totalVendasPorDia.length; i++) {
			somaVendas += totalVendasPorDia[i];
		}
		return somaVendas;
	}

	/**
	 * sobrescreve o metodo de mesmo nome da superclasse, acrescentando ao
	 * liquido do vendedor o valor de sua comissao do mes;
	 */
	public double calculaSalarioLiquidoMes() {
		return super.calculaSalarioLiquidoMes() + this.totalComissaoMes;
	}

	/**
	 * sobrescreve o metodo de mesmo nome da superclasse, acrescentando o total
	 * de vendas do mes e o valor da comissao;
	 */
	public void emiteContraCheque() {
		super.emiteContraCheque();
		System.out.println("Total vendas mes: " + totalVendasMes());
		System.out.println("Total comissao mes: " + this.totalComissaoMes);
	}

	/**
	 * retorna o dia do mês em que o vendedor vendeu mais. Se houver empate em
	 * mais de um dia, retornar apenas o dia mais cedo;
	 */
	public int melhorDiaDoVendedor() {
		double maiorValorVendaDia = totalVendasPorDia[0];
		int diaComMaiorVenda = 1;
		for (int i = 0; i < totalVendasPorDia.length; i++) {
			if (totalVendasPorDia[i] > maiorValorVendaDia) {
				diaComMaiorVenda = (i + 1);
			}
		}
		return diaComMaiorVenda;
	}

	/**
	 * retorna um array contendo os 3 maiores totais diários de vendas 
	 * em ordem decrescente. Atenção: o atributo array não deve ser alterado.
	 */
	public double[] tresMelhoresDias() {
		// copia do array original para nao altera-lo
		double[] arrayAux = new double[totalVendasPorDia.length];
		for (int i = 0; i < totalVendasPorDia.length; i++) {
			arrayAux[i] = totalVendasPorDia[i];
		}
		
		// ordenacao do array copia em ordem descrescente de valor
		for (int i = 0; i < arrayAux.length; i++) {
			for (int j = 0; j < arrayAux.length - 1; j++) {
				if (arrayAux[j] < arrayAux[j + 1]) {
					double temp = arrayAux[j];
					arrayAux[j] = arrayAux[j + 1];
					arrayAux[j + 1] = temp;
				}
			}
		}
		
		// selecao apenas dos 3 primeiros valores que ja estao em ordem decrescente
		double[] arrayRetorno = new double[3];
		arrayRetorno[0] = arrayAux[0];
		arrayRetorno[1] = arrayAux[1];
		arrayRetorno[2] = arrayAux[2];
		
		return arrayRetorno;
	}
	
	/**
	 * exibe uma relação dos dias do mês em que o vendedor 
	 * realizou venda e o valor total diário, como no exemplo abaixo. 
	 * Trate de arredondar para apenas duas casas decimais os valores em dinheiro.
	 */
	public void relatorioDeVendas() {
		System.out.println("Relatorio do mes");
		System.out.println("Dia do mes \t Total vendido - R$");
		for (int i = 0; i < totalVendasPorDia.length; i++) {
			System.out.printf((i+1) + "\t\t R$ %.2f \n", totalVendasPorDia[i]);
		}
	}

}
