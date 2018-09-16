
import exercicioPilha.*;
import exercicioPilha.OverflowException;

public class Teste {

	public static int convertToInt(SinglyLinkedList<Integer> lista) {

		String numero = "";
		Node<Integer> current = lista.head;
		while (current != null) {
			numero += current.getElement().toString();
			current = current.getNext();
		}

		return Integer.parseInt(numero);

	}

	private static void somaElementLista(SinglyLinkedList<Integer> lista, Node<Integer> current, int soma) {

		if (current != null) {
			soma += current.getElement();
			somaElementLista(lista, current.getNext(), soma);
		} else {
			System.out.println(soma);
		}

	}

	public static void somaElementLista(SinglyLinkedList<Integer> lista) {
		if (lista.isEmpty()) {
			throw new UnderflowException();
		}

		Node<Integer> current = lista.head;
		somaElementLista(lista, current, 0);
	}

	public static StaticStack<Double> retiraNegativos(SinglyLinkedList<Double> lista) throws OverflowException {
		StaticStack<Double> pilha = new StaticStack<>(lista.numElements());

		Node<Double> current = lista.head;

		while (current.getNext() != null) {
			if (current.getElement() < 0) {
				pilha.push(current.getElement());
			}

			current = current.getNext();
		}

		return pilha;
	}

	public static int calculaSaldoGols(SinglyLinkedList<String> lista, String time) {

		Node<String> current = lista.head;
		String[] aux;
		int golFeito = 0;
		int golRecebido = 0;
		while (current != null) {
			int indice = 0;
			aux = current.getElement().split(" ");
			for (int i = 0; i < aux.length; i++) {
				if (aux[i].equalsIgnoreCase("x")) {
					indice = i;
					break;
				}
			}
			if (aux[0].equalsIgnoreCase(time) || aux[indice+2].equalsIgnoreCase(time)) {
				if (aux[0].equalsIgnoreCase(time)) {
					golFeito += Integer.parseInt(aux[indice-1]);
				}

				if (!aux[indice+2].equalsIgnoreCase(time)) {
					golRecebido += Integer.parseInt(aux[indice+1]);
				}

				if (aux[indice+2].equalsIgnoreCase(time)) {
					golFeito += Integer.parseInt(aux[indice+1]);
				}
				if (!aux[0].equalsIgnoreCase(time)) {
					golRecebido += Integer.parseInt(aux[indice-1]);
				}
			}
			current = current.getNext();
		}

		return golFeito - golRecebido;

	}

	public static void main(String[] args) {

		SinglyLinkedList<Double> listaInt = new SinglyLinkedList<>();

		int cont = 1;
		while (cont < 7) {
			cont++;
			listaInt.insertLast(new Double(cont));
		}

		listaInt.insertFirst(-1.0);
		listaInt.insertFirst(-5.7);

		// Teste.convertToInt(listaInt);
		// Teste.somaElementLista(listaInt);
		// listaInt.split(5);
		try {
			Teste.retiraNegativos(listaInt);
		} catch (OverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SinglyLinkedList<String> listaJogos = new SinglyLinkedList<>();
		listaJogos.insertLast("Grêmio 5 x 0 Internacional");
		listaJogos.insertLast("Santos 2 x 3 Cruzeiro");
		listaJogos.insertLast("Real Madrid 1 x 4 Grêmio");
		listaJogos.insertLast("Barcelona 2 x 3 Real Madrid");

		Teste.calculaSaldoGols(listaJogos, "Grêmio");
	}

}
