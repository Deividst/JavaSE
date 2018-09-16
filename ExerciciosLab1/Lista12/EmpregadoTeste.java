
public class EmpregadoTeste {

	public static void main(String[] args) {
		
		Empregado emp1 = new Empregado("Marcos", 1000);
		emp1.calculaSalarioLiquidoMes();
		emp1.emiteContraCheque();
		
		System.out.println();
		
		Empregado emp2 = new Empregado("Thiago", 2000);
		emp2.marcaUmaFalta();
		emp2.calculaSalarioLiquidoMes();
		emp2.emiteContraCheque();

	}

}
