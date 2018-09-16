import java.util.Arrays;

public class EmpregadoVendedorTeste {

	public static void main(String[] args) {
		
		EmpregadoVendedor vend1 = new EmpregadoVendedor("Felipe", 3000, 1);
		vend1.fazVenda(1, 100);
		vend1.fazVenda(2, 200);
		vend1.fazVenda(2, 200);
		vend1.fazVenda(3, 300);
		vend1.calculaComissao(10);
		vend1.calculaSalarioLiquidoMes();
		vend1.emiteContraCheque();

		System.out.println();
		
		EmpregadoVendedor vend2 = new EmpregadoVendedor("Matheus", 2000, 4);
		vend2.fazVenda(1, 100);
		vend2.fazVenda(2, 200);
		vend2.fazVenda(3, 300);
		vend2.fazVenda(4, 400);
		vend2.calculaComissao(10);
		vend2.calculaSalarioLiquidoMes();
		vend2.emiteContraCheque();
		System.out.println("Tres melhores dias: " + Arrays.toString(vend2.tresMelhoresDias()) );
		System.out.println("Melhor dia de vendas: "+ vend2.melhorDiaDoVendedor());
		vend2.relatorioDeVendas();
		
		

	}

}
