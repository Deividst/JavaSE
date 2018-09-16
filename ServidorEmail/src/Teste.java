
public class Teste {
	public static void main(String[] args) {
		
		CaixaPostal cpCarlos = new CaixaPostal ("carlos@unisinos.br");
		CaixaPostal cpEduardo = new CaixaPostal ("eduardo@unisinos.br");
		CaixaPostal cpJonas = new CaixaPostal ("jonas@unisinos.br");
		
		Servidor ser = new Servidor();
		
		ser.add(cpCarlos);
		ser.add(cpEduardo);
		ser.add(cpJonas);
		
		cpCarlos.send("eduardo@unisinos.br", "email", "corpoEmail");
		cpEduardo.send("carlos@unisinos.br", "email2", "corpoEmail2");
		cpJonas.send("carlos@unisinos.br", "email3", "corpoEmail3");
		cpCarlos.send("nenhum", "emailSemDestino", "corpoEmailSemDestino");
		
		ser.sendReceive();
		
		cpCarlos.showInbox();
		cpEduardo.showInbox();
		cpJonas.showInbox();

	}

}
