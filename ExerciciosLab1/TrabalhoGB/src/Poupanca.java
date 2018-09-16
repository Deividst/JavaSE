/** Alunos : Deivid dos Santos Thomé Trabalho GB Lab 1 */

public class Poupanca{
	private int numero;
	private String cliente; // nome do cliente
	private double saldoLivre;

	public Poupanca(int n, String nome){
		this.numero = n;
		this.cliente = nome;
		this.saldoLivre = 0;
	}
	public void deposita(double valor){
		saldoLivre += valor;
	}
	public boolean retira(double valor){
		if (saldoLivre < valor)
			return false;
		saldoLivre -= valor;
		return true;
	}
	public double creditaRendimento(double taxa){ // a taxa é decimal
		double rendimento = taxa * saldoLivre;
		saldoLivre += rendimento;
		return rendimento;
	}
	public String toString(){
		return "Num: " + numero + " Cliente: " + cliente +
				"\nSaldo livre: R$ " + saldoLivre;
	}
	public String getCliente(){
		return cliente;
		}
	
	public int getNumero(){
		return numero;
		}
	
	public double getSaldoLivre(){
		return saldoLivre;
		}
}