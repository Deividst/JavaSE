
public class Email {
	private String rementente;
	private String destinatario;
	private String assunto;
	private String corpoEmail;
	
	public Email(String remerente, String destinatario, String assunto, String corpoEmail) {
		super();
		this.rementente = remerente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpoEmail = corpoEmail;
	}

	public String getRementente() {
		return rementente;
	}

	public void setRementente(String rementente) {
		this.rementente = rementente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		this.corpoEmail = corpoEmail;
	}
	
	

}
