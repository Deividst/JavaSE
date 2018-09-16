/** Alunos : Deivid dos Santos Thomé Trabalho GA Lab 1 */
public class Cliente {
	
	private String nome;
	private Data dataNascimento;
	private double valorPenultimaCompra;
	private double valorUltimaCompra;
	private double saldoDevedor;
	
	public Cliente(String nome, Data dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public void fazerCompra(double valorFinal) {
		
		this.valorUltimaCompra = valorFinal;
		this.valorPenultimaCompra = this.valorUltimaCompra;
		
	}
	
	public 	void fazerCompra(double valorFinal, double somaParcelas) {
		saldoDevedor += somaParcelas;
		this.fazerCompra(valorFinal);
		
	}
	
	public Data getDataNascimento() {
		return dataNascimento;
	}

	public double getValorPenultimaCompra() {
		return valorPenultimaCompra;
	}

	public double getValorUltimaCompra() {
		return valorUltimaCompra;
	}

	public void pagarParcela(double valorOriginal) {		
	this.saldoDevedor = this.saldoDevedor - valorOriginal;	
	}
	
	public void exibirDados() {
		System.out.println("Nome: " + this.nome + "/n"
				+ "Data de Nascimento: " + dataNascimento. obtemDataPadrao() + "/n"
				+ "Valor da penultima Compra: " + this.valorPenultimaCompra + "/n"
				+ "Valor da ultima compra: " + this.valorUltimaCompra + "/n"
				+ "Saldo Devedor: " + this.saldoDevedor );
		
	}

	public String getNome() {
		return nome;
	}
	
	
	

}
