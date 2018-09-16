
/** Alunos : Deivid dos Santos Thomé Trabalho GA Lab 1 */
public class Compra {

	private int modalidade;
	private Cliente cliente;
	private Data data;
	private double precoOriginal;
	private double precoFinal;
	private Parcela p1;
	private Parcela p2;
	private Parcela p3;
	
	public Compra (Cliente cliente, Data data, double preco) {
		this.cliente = cliente;
		this.data = data;
		precoOriginal = preco;
		this.escolherModalidade();
			
			
		}
	
	public Compra (Cliente cliente,int d, int m, int a, double preco) {
		
		this.data = new Data(d,m,a);
		this.cliente = cliente;
		precoOriginal = preco;
		this.escolherModalidade();
			
			
		}
		

	private void escolherModalidade() {
		Teclado t = new Teclado();
		int mod;
		mod = t.leInt("Informe a modalidade de pagamento: " + "\n"
				+ "1- Avista " +"\n" 
				+ "2- Duas parcelas" + "\n"
				+ "3- Tres Parcelas");
		if ( mod == 1 || mod == 2 || mod == 3) {
		this.modalidade = mod;
		} else {
			this.modalidade = 1;
		}
		
	}
	
	private boolean ultimasCrescente(double precoFinal) {
		this.precoFinal = precoFinal;
		
		if (precoFinal > cliente.getValorUltimaCompra() && 
				precoFinal > cliente.getValorPenultimaCompra() && 
				cliente.getValorUltimaCompra() > cliente.getValorPenultimaCompra()) {
			return true;
		} else {
			return false;
		}
	}
	
	public Data calcularVencimentoParcela(Data d) {
		Data proximaParcela;
		
		int mes = d.getMes();
		int ano = d.getAno();
		mes++;
		if (mes > 12) {
			mes = 1;
			ano++;
		}
		
		proximaParcela = new Data(28,mes,ano);
		return proximaParcela;
		
	}
		
		public String finalizarCompra() {
			
			Data d1;
			Data d2;
			Data d3;
			
			if (this.modalidade == 2) {
				double desconto = (precoOriginal * 3.5) /100;
				this.precoFinal = this.precoOriginal - desconto;
				
				d1 = calcularVencimentoParcela(this.data);
				p1 = new Parcela(cliente, d1,this.precoFinal/2);
				d2 = calcularVencimentoParcela(d1);
				p2 = new Parcela(cliente, d2, this.precoFinal/2);
				cliente.fazerCompra(this.precoFinal, this.precoFinal);
				return "Compra com entrada + 2 parcelas, ganhou desconto de 3,5%.";
				
			}else if (this.modalidade == 3) {
				this.precoFinal = this.precoOriginal;
				
				d1 = calcularVencimentoParcela(this.data);
				p1 = new Parcela(cliente, d1, this.precoFinal/3);
				d2 = calcularVencimentoParcela(d1);
				p2 = new Parcela(cliente, d2, this.precoFinal/3);
				d3 = calcularVencimentoParcela(d2);
				p3 = new Parcela(cliente, d3, this.precoFinal/3);
				cliente.fazerCompra(this.precoFinal, this.precoFinal);
				return "Compra em 3 parcelas, não ganhou desconto.";
				
			}else {
			
				if(data.getMes() == cliente.getDataNascimento().getMes()) {
					double desconto = (precoOriginal * 20) / 100;
					this.precoFinal = this.precoOriginal - desconto;
					cliente.fazerCompra(this.precoFinal);
					return "Compra à vista, ganhou 20% de desconto, pois cliente nasceu em " + cliente.getDataNascimento().obtemDataPadrao();
					
				} else if ( ultimasCrescente(this.precoFinal) == true) {
					double desconto = (precoOriginal * 8) /100;
					this.precoFinal =this.precoOriginal - desconto;
					cliente.fazerCompra(this.precoFinal);
					return "Compra à vista, ganhou 8% de desconto.";
					
				} else {
					double desconto = (precoOriginal * 5) /100;
					this.precoFinal =this.precoOriginal - desconto;
					cliente.fazerCompra(this.precoFinal);
					return "Compra à vista, ganhou só 5% de desconto.";
				}
					
			}
			
			
				
			}
		
		
			public void exibirDados() {
				if (this.modalidade == 2) {
				System.out.println("---------------------------------------------------------");
		        System.out.println("Nome Cliente: " + cliente.getNome() + "        " + "Data Nascimento: " + cliente.getDataNascimento().obtemDataPadrao());
				System.out.println("Pacela 1 de 2: "+ p1.getValorFinal() +"        " + "Data Vencimento: " +p1.getDataVencimento().obtemDataPadrao());
				System.out.println("Pacela 2 de 2: "+ p2.getValorFinal() +"        " + "Data Vencimento: " +p2.getDataVencimento().obtemDataPadrao());
				System.out.println("Compra com entrada + 2 parcelas, ganhou desconto de 3,5%");
				System.out.println("Valor Total: "+ this.precoFinal);
				System.out.println("---------------------------------------------------------");
				System.out.println("Data: " + data.obtemDataPadrao());
				System.out.println("---------------------------------------------------------");
			} else if (this.modalidade == 3) {
					System.out.println("---------------------------------------------------------");
			        System.out.println("Nome Cliente: " + cliente.getNome() + "        " + "Data Nascimento: " + cliente.getDataNascimento().obtemDataPadrao());
					System.out.println("Pacela 1 de 3: "+ p1.getValorFinal() +"        " + "Data Vencimento: " +p1.getDataVencimento().obtemDataPadrao());
					System.out.println("Pacela 2 de 3: "+ p2.getValorFinal() +"        " + "Data Vencimento: " +p2.getDataVencimento().obtemDataPadrao());
					System.out.println("Pacela 3 de 3: "+ p3.getValorFinal() +"        " + "Data Vencimento: " +p3.getDataVencimento().obtemDataPadrao());
					System.out.println("Compra em 3 parcelas, não ganhou desconto.");
					System.out.println("Valor Total: "+ this.precoFinal);
					System.out.println("---------------------------------------------------------");
					System.out.println("Data: " + data.obtemDataPadrao());
					System.out.println("---------------------------------------------------------");
				
			} else {
				System.out.println("---------------------------------------------------------");
		        System.out.println("Nome Cliente: " + cliente.getNome() + "        " + "Data Nascimento: " + cliente.getDataNascimento().obtemDataPadrao());
				System.out.println("Pagamento Avista: " +finalizarCompra());
				System.out.println("Valor Total: "+ this.precoFinal);
				System.out.println("---------------------------------------------------------");
				System.out.println("Data: " + data.obtemDataPadrao());
				System.out.println("---------------------------------------------------------");
				
			}
			}
}
			
		
		
		
		
	
	

