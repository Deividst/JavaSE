
public class Entregador implements Runnable{
	private ListaMembros listaMembros;
	
	

	public Entregador(ListaMembros listaMembros) {
		super();
		this.listaMembros = listaMembros;
	}



	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + "Começando trabalho de entrega");
		int qtdPendente = listaMembros.getEmailsPendente();
		boolean aberta = listaMembros.isAberta();
		
		while (aberta || qtdPendente > 0) {
			try {
				String email = listaMembros.obterEmailMembro();
				if(email != null) {
					System.out.println(nomeThread + "Enviado email para"+ email);
					Thread.sleep(2000);
					System.out.println("Envio para " + email +" concluido com sucesso");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			aberta = listaMembros.isAberta();
			qtdPendente = listaMembros.getEmailsPendente();
		}
		
		System.out.println("Arividades finalizadas");
	}

	
}
