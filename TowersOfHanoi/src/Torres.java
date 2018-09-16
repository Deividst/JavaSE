
import java.util.Scanner;
import java.util.Stack;

public class Torres {
	Stack<Anilha> torre1 = new Stack<Anilha>();
	Stack<Anilha> torre2 = new Stack<Anilha>();
	Stack<Anilha> torre3 = new Stack<Anilha>();
	private boolean fim = true;

	public Torres() {
		int tamanho = 4;
		while (tamanho > 0) {
			torre1.push(new Anilha(tamanho--));
		}

	}

	public void play() {
		Scanner s = new Scanner(System.in);
		int cont = 0;
		int torreOrigem = 0;
		int torreDestino = 0;
		while (fim) {
			do {
				System.out.println("Escolha a torre de origem");
				torreOrigem = s.nextInt();
			} while (torreOrigem < 1 || torreOrigem > 3);

			do {
				System.out.println("Escolhe a torre de destino");
				torreDestino = s.nextInt();
			} while (torreDestino < 1 || torreDestino > 3 || torreDestino == torreOrigem);

			boolean movimentoValido = this.transfereAnilha(torreOrigem, torreDestino);
			if (movimentoValido) {
				cont++;
			}
			if (this.torre3.size() == 4) {
				this.fim = false;
				System.out.println("Numero de movimentos: " + cont);
				System.out.println("Você ganhou o jogo");
			}
			this.exibeTodasTorres();
		}
	}

	private boolean transfereAnilha(int origem, int destino) {
		if (origem == 1) {
			if (torre1.isEmpty()) {
				return false;
			} else {
				if (destino == 2) {
					if (torre2.isEmpty()) {
						torre2.push(torre1.pop());
						return true;
					} else if (torre1.peek().getPeso() < torre2.peek().getPeso()) {
						torre2.push(torre1.pop());
						return true;
					}
				} else {
					if (torre3.isEmpty()) {
						torre3.push(torre1.pop());
						return true;
					} else if (torre1.peek().getPeso() < torre3.peek().getPeso()) {
						torre3.push(torre1.pop());
						return true;
					}
				}
				return false;
			}
		} else if (origem == 2) {
			if (torre2.isEmpty()) {
				return false;
			} else {
				if (destino == 1) {
					if (torre1.isEmpty()) {
						torre1.push(torre2.pop());
						return true;
					} else if (torre2.peek().getPeso() < torre1.peek().getPeso()) {
						torre1.push(torre2.pop());
						return true;
					}
				} else {
					if (torre3.isEmpty()) {
						torre3.push(torre2.pop());
						return true;
					} else if (torre2.peek().getPeso() < torre3.peek().getPeso()) {
						torre3.push(torre2.pop());
						return true;
					}
				}
				return false;
			}
		} else {
			if (torre3.isEmpty()) {
				return false;
			} else {
				if (destino == 1) {
					if (torre1.isEmpty()) {
						torre1.push(torre3.pop());
						return true;
					} else if (torre3.peek().getPeso() < torre1.peek().getPeso()) {
						torre1.push(torre3.pop());
						return true;
					}
				} else {
					if (torre2.isEmpty()) {
						torre2.push(torre3.pop());
						return true;
					} else if (torre3.peek().getPeso() < torre2.peek().getPeso()) {
						torre2.push(torre3.pop());
						return true;
					}
				}
			}
			return false;
		}
	}

	public void exibeTorre1() {
		Stack<Anilha> aux = new Stack<Anilha>();
		while (!torre1.isEmpty()) {
			aux.push(this.torre1.pop());
		}
		for (Anilha anilha : aux) {
			System.out.print(anilha.getPeso());
		}
		while (!aux.isEmpty()) {
			torre1.push(aux.pop());
		}
	}

	public void exibeTorre2() {
		Stack<Anilha> aux = new Stack<Anilha>();
		while (!torre2.isEmpty()) {
			aux.push(this.torre2.pop());
		}
		for (Anilha anilha : aux) {
			System.out.print(anilha.getPeso());
		}
		while (!aux.isEmpty()) {
			torre2.push(aux.pop());
		}
	}

	public void exibeTorre3() {
		Stack<Anilha> aux = new Stack<Anilha>();
		while (!torre3.isEmpty()) {
			aux.push(this.torre3.pop());
		}
		for (Anilha anilha : aux) {
			System.out.print(anilha.getPeso());
		}
		while (!aux.isEmpty()) {
			torre3.push(aux.pop());
		}
	}

	public void exibeTodasTorres() {
		System.out.print("Torre 1: ");
		if (!torre1.isEmpty()) {
			this.exibeTorre1();
		} else {
			System.out.print("0000");
		}
		System.out.println();

		System.out.print("Torre 2: ");
		if (!torre2.isEmpty()) {
			this.exibeTorre2();
		} else {
			System.out.print("0000");
		}
		System.out.println();

		System.out.print("Torre 3: ");
		if (!torre3.isEmpty()) {
			this.exibeTorre3();
		} else {
			System.out.print("0000\n");
		}

	}

}
