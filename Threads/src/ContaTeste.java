
public class ContaTeste implements Runnable {

	private Conta conta = new Conta();
	
	private synchronized void saque(int valor) {
		if(conta.getSaldo() >= valor ) {
			System.out.println(Thread.currentThread().getName() + " Está indo sacar!");
			conta.saque(valor);
			System.out.println(Thread.currentThread().getName() + "Completou o saque, saldo: " + conta.getSaldo());
		}else {
			System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + "efetuar o saque, Saldo:  " + conta.getSaldo());
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			saque(10);
			if(conta.getSaldo() < 0) {
				System.out.println("Oh meu deus!");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ContaTeste ct = new ContaTeste();
		
		Thread deivid = new Thread(ct, "Deivid");
		Thread maria = new Thread(ct, "Maria");
		deivid.start();
		maria.start();
		
	}

}
