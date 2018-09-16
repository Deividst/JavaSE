
public class CaixaPostal {
	private String remetente;
	private Email[] caixaSaida = new Email[10];
	private Email[] caixaEntrada = new Email[10];
	
	public CaixaPostal(String remetente) {
		super();
		this.remetente = remetente;
	}
	
	
	public void send(String destinatario, String assunto, String corpoEmail) {
		
		for (int i = 0; i < caixaSaida.length; i++) {
			if(caixaSaida[i] == null) {
				caixaSaida[i] = new Email(this.remetente, destinatario, assunto, corpoEmail);
				break;
			}
		}
		
	}
	
	
	public void showInbox() {
		for (int i = 0; i < caixaEntrada.length; i++) {
			if(caixaEntrada[i] != null){
				System.out.println("Remetente: " + caixaEntrada[i].getRementente());
				System.out.println("Destinatário: " + caixaEntrada[i].getDestinatario());
				System.out.println("Assunto: " + caixaEntrada[i].getAssunto());
				System.out.println("Corpo Email: " + caixaEntrada[i].getCorpoEmail());
				System.out.println("-----------------------------------------------");
		}
		}
		
	}


	public String getRemetente() {
		return remetente;
	}


	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}


	public Email[] getCaixaSaida() {
		return caixaSaida;
	}


	public void setCaixaSaida(Email[] caixaSaida) {
		this.caixaSaida = caixaSaida;
	}


	public Email[] getCaixaEntrada() {
		return caixaEntrada;
	}


	public void setCaixaEntrada(Email[] caixaEntrada) {
		this.caixaEntrada = caixaEntrada;
	}
	
	
	

}
