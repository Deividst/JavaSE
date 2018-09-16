import java.net.PortUnreachableException;

/** Alunos : Deivid dos Santos Thomé Trabalho GB Lab 1 */

public class Agencia {
	
	private Poupanca[] p;
	private int qtdContas;
	
	public Agencia(int maximoContas) {
		p = new Poupanca[maximoContas];
		
	}
	
	
	private int abreConta() {
		Teclado t = new Teclado();
		for (int i = 0; i < p.length; i++) {
		if (p[i] == null) {
			
			int op = t.leInt("Informe o tipo de Conta: \n" + "1 - Poupança Simples\n" + "2 - Poupança Saúde");
			if (op != 1 && op != 2) {
				op = 2;
				}
			switch (op) {
			case 1:
				p[i] = new Poupanca(t.leInt("Informe o numero da Conta"), t.leString("Informe o nome Cliente"));
				return p[i].getNumero();

			case 2:
				p[i] = new PoupancaSaude(t.leInt("Informe o numero da conta"), t.leString("Informe o nome do cliente"));
				boolean ok = true;
				int cont = 0;
				do {
					char sn = t.leChar("Deseja adicionar um dependente? \n (S)- Sim \n (N) - Não");
					 if ( sn == 's') {
					Dependente dep = new Dependente(t.leString("Informe o nome"), t.leChar("Informe o parentesco \n C = conjuge \n F = filho \n P = progenitor \n O = outro"));	
					((PoupancaSaude)p[i]).insereDependentes(dep);
					cont++;
						if (cont == 5) {
							ok = false;
						}
					} else {
						ok = false;
					}
					 
				} while (ok);
				return ((PoupancaSaude)p[i]).getNumero();
			}
		}
			
			
		} 
		
		System.out.println("Array de contas lotado");
		return -1;
	
		
	}
	
	private int buscaConta(int numeroConta) {
		for (int i = 0; i < p.length; i++) {
			if(p[i] != null) {
				if (numeroConta == p[i].getNumero()) {
					return i;
		}
		}
		}
		return -1;
	}
		
		
	
	public void menuTransacoes() {
		boolean ok = true;
		Teclado t = new Teclado();
		do {
			System.out.println("1 – Abre conta \n"
					+"2 – Deposita \n"
					+"3 – Retira \n"
					+"4 – Retira para saúde \n"
					+"5 – Amortiza financiamento \n"
					+"6 – Emite extrato da conta \n"
					+"7 – Credita rendimentos \n"
					+"8 – Insere um dependente \n"
					+"9 – Retira um dependente \n"
					+"10 – Encerra");
			int op = t.leInt("Escolha uma opção valida");
			if (op >= 1 && op <= 10) {
				int busca;
				switch (op) {
				case 1:
					int aux = abreConta();
					if (aux == -1) {
						System.out.println("Não pode abrir novas contas nesta agência");
					}else {
						System.out.println("Conta aberta de número: " + aux);
					}
					break;

				case 2:
					busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					} else  if ((p[busca] instanceof PoupancaSaude)){
						((PoupancaSaude)p[busca]).deposita(t.leDouble("Informe o valor para depositar"));
					} else {
						p[busca].deposita(t.leDouble("Informe o valor para depositar"));
					}
					break;
				case 3:
					 busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					} else {
						boolean res = p[busca].retira(t.leDouble("Informe o valor para saque"));
						if (res = false) {
							System.out.println("Saldo insuficiente");
						}
					}
					break;
				case 4:
					 busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					} else if(!(p[busca] instanceof PoupancaSaude)) {
						System.out.println("Não é poupança saude");
						
					} else {
						double valorFinanciado = ((PoupancaSaude)p[busca]).retiraSaude(t.leDouble("Informe o valor para retirar"));
						System.out.println("Valor Financiado: " + valorFinanciado);
					}
					break;
				case 5:
					busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					}else if(!(p[busca] instanceof PoupancaSaude)) {
						System.out.println("Tipo de conta não aceita nesta operação");
					} else {
						double premio = ((PoupancaSaude)p[busca]).amortizaFinanciamento(t.leDouble("Informe o valor"));
						System.out.println("Ganhou desconto-depósito de R$: " + premio);
					}
					break;
				case 6:
					busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					}else if((p[busca] instanceof PoupancaSaude)) {
						System.out.println(((PoupancaSaude)p[busca]).toString());
					} else {
						System.out.println(p[busca].toString());
					}
					break;
				case 7:
					double taxa = t.leDouble("Informe a taxa de rendimento");
					double totalCredito = 0;
					for (int i = 0; i < p.length; i++) {
						if(p[i] != null) {
					totalCredito += p[i].creditaRendimento(taxa);
						}
					}
					System.out.println("Total de credito: " + totalCredito);
					break;
				case 8:
					busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					}else if(!(p[busca] instanceof PoupancaSaude)) {
						System.out.println("Tipo de conta não aceita nesta operação");
					} else {
						Dependente dep = new Dependente(t.leString("Informe o nome"), t.leChar("Informe o parentesco \n C = conjuge \n F = filho \n P = progenitor \n O = outro"));	
						boolean res = ((PoupancaSaude)p[busca]).insereDependentes(dep);
						if (res == false) {
							System.out.println("Esta conta não admite mais dependentes");
						}
					}
					break;
				case 9:
					busca = buscaConta(t.leInt("Informe o numero da conta para busca"));
					if ( busca == -1) {
						System.out.println("Conta inexistente");
					}else if(!(p[busca] instanceof PoupancaSaude)) {
						System.out.println("Tipo de conta não aceita nesta operação");
					} else {
						Dependente d = ((PoupancaSaude)p[busca]).retiraDependente(t.leString("Informe o nome para excluir"));
						if (d  == null) {
							System.out.println(" Não existe dependente com este nome nesta conta.");
						}
					}
					break;
				case 10:
					System.exit(0);
					ok = false;
					break;
				}
				
			} else {
				System.out.println("Opção invalida");
			}
			
		} while (ok);
	}

}
