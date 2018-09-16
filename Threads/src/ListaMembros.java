import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {
	
	private Queue<String> emails = new LinkedList<>();
	private boolean aberta = true;
	
	public int getEmailsPendente() {
		synchronized (emails) {
			return this.emails.size();
		}
	}
	
	public boolean isAberta() {
		return aberta;
	}
	
	public String obterEmailMembro() {
		String email = null;
		try {
			synchronized (this.emails) {
				while(this.emails.size() == 0) {
					if(!aberta) return null;
					
					System.out.println("Lista vazia, colocando a Thread: " + Thread.currentThread().getName() + " em modo wait");
					this.emails.wait();
				}
				email = this.emails.poll();
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
	
	public void adicionarEmailMembros(String email) {
		synchronized (emails) {
			this.emails.add(email);
			
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as Threads que estão em espera");
			this.emails.notifyAll();
		}
	}
	
	
	public void fecharLista() {
		System.out.println("Notificando todas as threads e fechando elas");
		
		this.aberta = false;
		
		synchronized (emails) {
			this.emails.notifyAll();
		}
	}
	
}
