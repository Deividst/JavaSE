import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/** Alunos : Deivid dos Santos Thomé Trabalho GB Lab 1 */

public class PoupancaSaude extends Poupanca{

	
	
	private double saldoVinculado; 
	private double saldoFinanciado;
	private Dependente[] dependente;
	
	
	public PoupancaSaude(int n, String nome) {
		super(n, nome);
		this.dependente = new Dependente[5];
	}
	
	public int contaDependentes() {
		int quantidade = 0;
		for (int i = 0; i < dependente.length; i++) {
			if (dependente[i] != null) {
				quantidade++;
			}
		}
		return quantidade;
	}
	
	public void deposita(double valor) {
		int nDependentes = contaDependentes();
		double desconto;
		if (nDependentes == 0) {
			desconto = ((valor * 15) / 100);
			this.saldoVinculado += desconto;
			super.deposita(valor - desconto);
		} else if (nDependentes >= 1 && nDependentes <= 2) {
			desconto = ((valor * 20) / 100);
			this.saldoVinculado += desconto;
			super.deposita(valor - desconto);
		} else if (nDependentes >= 3 && nDependentes<= 4 ) {
			desconto = ((valor * 30) / 100);
			this.saldoVinculado += desconto;
			super.deposita(valor - desconto);
		} else if (nDependentes == 5) {
			desconto = ((valor * 50) / 100);
			this.saldoVinculado += desconto;
			super.deposita(valor - desconto);
		}
		
	}
	
	public double creditaRendimento(double taxa){ 
		double rendimento = taxa * super.getSaldoLivre();
		super.deposita(rendimento);
		double rendimento2 = taxa * this.saldoVinculado;
		this.saldoVinculado += rendimento2;
		return rendimento + rendimento2;
	}
	
	public boolean insereDependentes(Dependente dependente) {
		for (int i = 0; i < this.dependente.length; i++) {
			if (this.dependente[i] == null) {
				this.dependente[i] = dependente;
				return true;
			}
		}
		return false;
	}
	
	public int buscaDepedente(String nome) {
		for (int i = 0; i < dependente.length; i++) {
			if(dependente[i] != null) {
				if (this.dependente[i].getNome().equalsIgnoreCase(nome)) {
					return i;
			}
			}
		}
		return 99;
	}
	
	public Dependente retiraDependente(String nome) {
		int result = buscaDepedente(nome);	
		if (result != 99) {
			Dependente aux = this.dependente[result];
			this.dependente[result] = null;
			return aux;
		}
			return null;
		
		
	}
	
	public double retiraSaude(double despesa) {
				
		
		if (despesa > this.saldoVinculado) {
			
			double valorRestante = despesa - this.saldoVinculado;
			Teclado t = new Teclado();
			int op;
			
			
				System.out.println("Sua despesa é maior que o saldo vinculado \n Oque deseja fazer?");
				System.out.println("1 - Usar Saldo livre" +"\n"
									+"2 - Fazer financiamento" +"\n");
									
				
				op = t.leInt();
				
				switch (op) {
				case 1:
					boolean sim = false;
					double valor;
					do {
						System.out.println("Saldo Atual: " + super.getSaldoLivre());
						System.out.println("Valor a debitar: " + valorRestante);
						valor = t.leDouble("Informe o valor que deseja usar");
						
						if ( valor > super.getSaldoLivre() || valor > valorRestante) {
							System.out.println("Valor muito grande, redigite!");
							sim = true;;
						} else {
							sim = false;
						}
					}while (sim);
					
							this.saldoVinculado =  0;
							valorRestante = valor - valorRestante;
							super.retira(valor);
							
							if (valorRestante != 0) {
								double juros;
								if ( this.saldoFinanciado == 0) {
									juros =( (valorRestante * 5) / 100);
									this.saldoVinculado =  0;
									this.saldoFinanciado += (juros + valorRestante);
									return valorRestante + juros;
								} else if (this.saldoFinanciado <= 500 ) {
									juros = ( (valorRestante * 10) / 100);
									this.saldoVinculado =  0;
									this.saldoFinanciado += (juros + valorRestante);
									return valorRestante + juros;
								}else if (this.saldoFinanciado > 500) {
									juros = ( (valorRestante * 15) / 100);
									this.saldoVinculado =  0;
									this.saldoFinanciado += (juros + valorRestante);
									return valorRestante + juros;
								}
							}
					break;

				case 2:
					double juros;
					if ( this.saldoFinanciado == 0) {
						juros =( (valorRestante * 5) / 100);
						this.saldoFinanciado += (juros + valorRestante);
						this.saldoVinculado =  0;
						return valorRestante + juros;
					} else if (this.saldoFinanciado <= 500 ) {
						juros = ( (valorRestante * 10) / 100);
						this.saldoFinanciado += (juros + valorRestante);
						this.saldoVinculado =  0;
						return valorRestante + juros;
					}else if (this.saldoFinanciado > 500) {
						juros = ( (valorRestante * 15) / 100);
						this.saldoFinanciado += (juros + valorRestante);
						this.saldoVinculado =  0;
						return valorRestante + juros;
					}
					
					break;
					
				}

			
		}
			this.saldoVinculado = despesa - this.saldoVinculado;
			return 0;

		
	}
	
	public double amortizaFinanciamento(double valor) {
		double deposito = 0;
		if (valor > this.saldoFinanciado) {
			return deposito;
		}
		
		this.saldoFinanciado = valor - this.saldoFinanciado;
		 if (this.saldoFinanciado == 0) {
			 deposito = ((valor * 5) / 100);
			 super.deposita(deposito);
		 }
		 
		 return deposito;
		
	}
	
	public void ordenaDependentes() {
		
		for (int i = 0; i < dependente.length; i++) {
			for (int j = 0; j < dependente.length - 1; j++) {
				if (dependente[j].getNome().compareToIgnoreCase(dependente[j+1].getNome()) > 0) {
					Dependente aux = dependente[j];
					dependente[j] = dependente[j+1];
					dependente[j+1] = aux;
					
				}
			}
			
		}
	}

	@Override
	public String toString() {
		return super.toString() + " \nPoupancaSaude saldoVinculado: R$ " + saldoVinculado + ", saldoFinanciado: R$ " + saldoFinanciado
				+ ", \ndependente=" + Arrays.toString(dependente) + "]";
	}

	
		
	
	
	
	
	
	
}
