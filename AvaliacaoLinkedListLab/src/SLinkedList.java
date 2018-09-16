import java.util.Random;

public class SLinkedList<E> {
	protected Node<E> head; // nodo cabe�a da lista
	protected Node<E> tail; // nodo cauda da lista
	protected int size; // n�mero de nodos da lista

	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node<E> getFirst() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return head;
	}

	public Node<E> getLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return tail;
	}

	public void addFirst(E element) {
		Node<E> novoNodo = new Node<E>(element);
		novoNodo.setNext(head);
		head = novoNodo;
		size++;
		if (size == 1)
			tail = head;
	}

	public void addLast(E element) {
		if (isEmpty())
			addFirst(element);
		else {
			Node<E> novoNodo = new Node<E>(element);
			novoNodo.setNext(null);
			tail.setNext(novoNodo);
			tail = novoNodo;
			size++;
		}
	}

	public E removeFirst() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		Node<E> removedItem = head;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
		}
		size--;
		return removedItem.getElement();
	}

	public E removeLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		Node<E> removedItem = tail;
		if (head == tail) {
			head = tail = null;
		} else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
			current.setNext(null);
		}
		size--;
		return removedItem.getElement();
	}

	public void addAfter(E el, int pos) throws IndexOutOfBoundsException {
		if (pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		if (pos == size - 1)
			addLast(el);
		else {
			Node<E> n = new Node<E>(el);
			int posAtual = 0;
			Node<E> current = head;
			while (posAtual < pos) {
				current = current.getNext();
				posAtual++;
			}
			n.setNext(current.getNext());
			current.setNext(n);
			size++;
		}
	}

	public void addBefore(E el, int pos) throws IndexOutOfBoundsException {
		if (pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		if (pos == 0)
			addFirst(el);
		else {
			int posAtual = 0;
			Node<E> current = head;
			Node<E> previous = null;
			Node<E> n = new Node<E>(el);
			while (posAtual < pos) {
				previous = current;
				current = current.getNext();
				posAtual++;
			}
			n.setNext(current);
			previous.setNext(n);
			size++;
		}
	}

	public String toString() {
		String str = "";
		if (isEmpty()) {
			return "Empty list";
		} else {
			str += "List: ";
			Node<E> current = head;
			while (current != null) {
				str += current.getElement().toString() + " ";
				current = current.getNext();
			}
			str += "\n";
		}
		return str;
	}

	public int size() {
		return size;
	}

	public void trocaNodes() {
		Node<E> atual = this.head;
		Node<E> prox;
		int pos = 0;
		int tamanho = this.size;
		if (this.size % 2 == 0) {
			while (pos < tamanho) {
				prox = atual.getNext();
				this.addBefore(prox.getElement(), pos);
				atual.setNext(prox.getNext());
				atual = prox.getNext();
				pos += 2;
			}
		} else {
			while (pos < tamanho - 1) {
				prox = atual.getNext();
				this.addBefore(prox.getElement(), pos);
				atual.setNext(prox.getNext());
				atual = prox.getNext();
				pos += 2;
			}
		}
	}

	public void inverteLista() throws UnderflowException {
		Node<E> current = this.head;
		E aux;
		int cont = 0;
		while (current != this.tail) {
			aux = this.removeLast();
			this.addBefore(aux, cont++);
		}

	}

	public void removeNodes(int pos, int qtdNodes) throws UnderflowException {
		if (pos > this.size - 1 || (this.size - pos) < qtdNodes) {
			throw new UnderflowException();
		}

		Node<E> current = this.head;
		int cont = 1;

		while (cont++ < pos) {
			current = current.getNext();
		}
		cont = 0;
		while (cont++ < qtdNodes) {
			current.setNext(current.getNext().getNext());
			this.size--;
		}

	}

	public void insereLista(SLinkedList<E> lista, int pos) {
		Node<E> current = this.head;
		Node<E> aux;
		int cont = 1;

		while (cont++ < pos) {
			current = current.getNext();
		}
		aux = current.getNext();
		current.setNext(lista.head);
		lista.tail.setNext(aux);
	}

	public void shuffle() throws UnderflowException {
		E elementoAux;
		int tamanho = this.size / 2;
		Random gerador = new Random();
		
		while (tamanho-- != 0) {
			int random = gerador.nextInt(this.size);
			while (random-- != 0) {
				this.inverteLista();
				elementoAux = this.removeFirst();
				this.addAfter(elementoAux, random);
			}
		}

	}

}