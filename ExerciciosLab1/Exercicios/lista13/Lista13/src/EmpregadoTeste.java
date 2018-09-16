
public class EmpregadoTeste {

	public static void main(String[] args) {
		
		Empregado e = new Empregado("Deivid", 2000.00);
		e.marcaUmaFalta();
		e.calculaSalarioLiquidoMes();
		e.emiteContraCheque();
		
		EmpregadoVendedor ev = new EmpregadoVendedor("Joao", 3000.00, 2);
		
		for(int i = 1; i <= 10; i++) {
			int dia = 1 +(int) Math.random() * 28;
			double valor = 	1000.00 + Math.random() * 2000.00;
			ev.fazVenda(dia, valor);
		}
		
		ev.calculaComissao(6);
		ev.marcaUmaFalta();
		ev.calculaSalarioLiquidoMes();
		ev.melhorDiaDoVendedor();
		ev.tresMelhoresDias();
		ev.emiteContraCheque();
		ev.relatorioVendas();
	}

}
