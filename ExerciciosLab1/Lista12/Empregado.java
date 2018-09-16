public class Empregado { // Processa dados de um mês
	
	private static int ultimaMatricula = 100;
	private int matricula;
	private String nome;
	private double salarioMensal;
	private int faltasMes;

	public Empregado(String nome, double salarioMensal) {
		matricula = ++ultimaMatricula;
		this.nome = nome;
		this.salarioMensal = salarioMensal;
	}

	public void marcaUmaFalta() {
		faltasMes++;
	}

	public double calculaSalarioLiquidoMes() {
		return salarioMensal - faltasMes * salarioMensal / 160;
	}

	public void emiteContraCheque() {
		double liquido = calculaSalarioLiquidoMes();
		System.out.println("Matr: " + matricula);
		System.out.println("Nome " + nome);
		System.out.println("A receber: R$" + liquido);
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getFaltasMes() {
		return faltasMes;
	}
}