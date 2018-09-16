
public class Formula {
	
	private Celula[][] planilha;
	
	public Formula(Celula[][] planilha) {
		this.planilha = planilha;
	}

	
	public double operacao(char operacao, int linha, int coluna, int linha2,int coluna2) {
		double valor1 = (double) planilha[linha][coluna].getValor();
		double valor2 = (double) planilha[linha2][coluna2].getValor();
		double result = 0;
		switch (operacao) {
		case '+':
			result = soma(valor1, valor2);
			break;
		case '*':
			result = multiplica(valor1, valor2);
			break;
		case '/':
			result = divisao(valor1, valor2);
			break;
		case '-':
			result = subtrai(valor1, valor2);
			break;
		default:
			System.out.println("Essa operação não existe");
			break;
		}
		
		return result;
	}
	
	private double soma(double valor1, double valor2) {
		return valor1 + valor2;
	}
	
	private double multiplica(double valor1, double valor2) {
		return valor1 * valor2;
	}
	
	private double subtrai(double valor1, double valor2) {
		return valor1 - valor2;
	}
	
	public double divisao(double valor1, double valor2) {
		return valor1 / valor2;
	}

}
