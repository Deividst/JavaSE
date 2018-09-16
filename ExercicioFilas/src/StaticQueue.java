public class StaticQueue<E> implements Queue<E>{

	// Index to the first element
	protected int first;

	// Index to the last element
	protected int last;

	// Generic array used to store the elements
	protected E elements[];

	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}

	/** Testes whether the queue is empty. */
	public boolean isEmpty() {
		return first == -1;
	}

	public boolean isFull() {
		return first == ((last + 1) % elements.length);
	}

	/** Returns the number of elements in the queue. */
	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length;

			return ((n + this.last - this.first) % n) + 1;
		}
	}

	/** Inspects the element at the front of the queue. */
	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	/** Inspects the element at the back of the queue. */
	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}

	/** Inserts an element at the rear of the queue. */
	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException("Lista cheia");
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}
	}

	/** Removes and return the element at the front of the queue. */
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	// Exercicio 4
	public boolean contains(E element) {
		for (int i = 0; i < elements.length; i++) {
			if (this.elements[i].equals(element)) {
				return true;
			}
		}

		return false;
	}

	// Exercicio 5
	public void flip() {
		E[] aux = (E[]) new Object[this.numElements()];
		for (int i = this.numElements(), j = 0; i > 0; i--) {
			aux[j++] = this.elements[i];
		}

		this.elements = aux;
	}

	// Exercicio 6
	public void enqueue(StaticQueue<E> fila) throws UnderflowException {
		E[] aux = (E[]) new Object[this.numElements() + fila.numElements()];
		int cont = 0;
		while (!fila.isEmpty()) {
			if (this.elements.length > cont) {
				aux[cont] = this.elements[cont];
			} else {
				aux[cont] = fila.dequeue();
			}
			cont++;
		}
		this.last = aux.length - 1;
		this.elements = aux;
	}

	// Exercicio 7
	public void enqueueWithPriority(E element) throws OverflowException, UnderflowException {
		int cont = 0;
		E[] aux = (E[]) new Object[this.numElements()];
		if (this.isFull()) {
			throw new OverflowException("Lista Cheia");
		} else if (this.isEmpty()){
			this.elements[0] = element;
			this.first = this.last = 0;
		} else {
			aux[cont++] = element;
			while(!this.isEmpty()) {
				aux[cont++] = this.dequeue();
			}
		}
		
		this.elements = aux;

	}

	// Exercicio 8
	public boolean equals(StaticQueue<E> fila) throws UnderflowException, OverflowException {
		E elemento = this.elements[this.elements.length - 1];
		E aux;
		int cont = 0;
		while (!elemento.equals(this.elements[cont])) {
			aux = fila.dequeue();
			if (!this.elements[cont].equals(aux)) {
				return false;
			}
			fila.enqueue(aux);
			cont++;
		}

		return true;
	}

	// Exercicio11
	public Queue<E> split(E element) throws OverflowException, UnderflowException {
		StaticQueue<E> fila2 = new StaticQueue<>(this.numElements());
		E[] aux = (E[]) new Object[this.numElements()];
		int cont = 0;
		while(!this.isEmpty()) {
			if(this.elements[this.first].equals(element)) {
				while (!this.isEmpty()) {
					fila2.enqueue(this.dequeue());
				}
			}else {
				aux[cont++] = this.dequeue();
			}
		}
		
		this.elements = aux;
		return fila2;
	}
	
	//Exercicio 12
	@Override
	public void moveToBackAllOccurrencesOf(E element) throws UnderflowException, OverflowException {
		E[] aux = (E[]) new Object[this.numElements()];
		int finalFila = this.elements.length;
		E elemento;
		int cont = 0;
		while (finalFila > 0) {
			elemento = this.dequeue();
			if(elemento.equals(element)) {
				aux[cont++] = elemento;
			}else {
				this.enqueue(elemento);
			}
			finalFila--;
		}
		for (int i = 0; i < cont; i++) {
			this.enqueue(aux[i]);
		}
		
	}
	
	public void ensureCapacity(int capacity) throws UnderflowException {
		E[] aux = (E[]) new Object[capacity];
		int cont = 0;
		while (!this.isEmpty()) {
			aux[cont++] = this.dequeue();
		}
		
		this.elements = aux;
	}

}
