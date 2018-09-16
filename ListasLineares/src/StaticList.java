public class StaticList<E> implements List<E>{

	protected E[] elements;
	int numElements;

	public StaticList(int maxSize) {
		elements = (E[]) new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	@Override
	public void insert(Object element, int pos) {
		// verifica se há espaço na lista
		if (isFull())
			System.out.println("Lista está cheia");

		// verifica se a posição é válida
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();

		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo elemento
		for (int i = numElements - 1; i >= pos; i--)
			elements[i + 1] = elements[i];

		// armazena o novo elemento e ajusta o total
		elements[pos] = (E) element;
		numElements++;

	}

	@Override
	public E remove(int pos) {
		// verifica se a posição é válida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		// guarda uma referência temporária ao elemento removido
		E element = elements[pos];

		// desloca para a esquerda os elementos necessários,
		// sobrescrevendo a posição que está sendo removida
		for (int i = pos; i < numElements - 1; i++)
			elements[i] = elements[i + 1];

		// define para null a posição antes ocupada pelo último,
		// para que a coleta de lixo possa atuar, e ajusta o total
		elements[numElements - 1] = null;
		numElements--;
		return element;

	}

	@Override
	public E get(int pos) {
		// verifica se a posição é válida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();
		return elements[pos];

	}

	@Override
	public int search(Object element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;

		return -1;

	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}

	@Override
	public boolean remover(E element) {
		int busca = this.search(element);

		if (busca != -1) {
			this.remove(busca);
			return true;
		}

		return false;
	}
	
	@Override
	public void insertAfter(E obj1, E obj2) {
		int busca = this.search(obj1);
		if (busca == -1) {
			throw new IllegalArgumentException("Impossivel adicionar obj2, pois obj1 não foi encontrado");
		} else {
			E[] elementsAux = (E[]) new Object[this.numElements + 1];
			for (int i = 0; i < elements.length; i++) {
				elementsAux[i] = elements[i];
			}

			for (int i = elements.length - 1; i > busca; i--) {
				elementsAux[i + 1] = this.elements[i];
			}
			elementsAux[busca + 1] = obj2;
			this.elements = elementsAux;
			this.numElements++;
		}
	}
	
	@Override
	public void swap(int pos1, int pos2) {
		if(pos1 < 0 || pos1 > this.numElements-1 || pos2 < 0 || pos2 > this.numElements-1) {
			throw new IndexOutOfBoundsException();
		}
		E aux = this.elements[pos1];
		this.elements[pos1] = this.elements[pos2];
		this.elements[pos2] = aux;
		
	}

	@Override
	public void flip() {
		E[] elementsAux = (E[]) new Object[elements.length];
		
		for (int i = this.elements.length-1; i >= 0; i--) {
			elementsAux[i] = this.elements[i];
		}
		
		this.elements = elementsAux;
	}
	
	public void insert(List<E> lista, int pos) {
		E[] elementsAux = (E[]) new Object[this.numElements + lista.numElements()];
		for (int i = 0,k = 0; i < elementsAux.length;i++) {
			elementsAux[i] = elements[k++];
			if(i == pos) {
				k--;
				for (int j = 0; j < lista.numElements(); j++) {
					elementsAux[i++] = lista.get(j);
				}
				i--;
			}
			
		}
		
		elements = elementsAux;
		this.numElements += lista.numElements();
	}

	@Override
	public void dedup() {
		for (int i = 0; i < elements.length; i++) {
			for (int j = i+1; j < elements.length; j++) {
				if(elements[i].equals(elements[j])) {
					this.remove(j);
				}
			}
		}
		
	}

	@Override
	public boolean equals(List<E> lista) {
		if(lista.numElements() != this.numElements) {
			return false;
		}
		
		for (int i = 0; i < this.numElements; i++) {
			if(!this.elements[i].equals(lista.get(i))) {
				return false;
			}
		}
		
		return true;
	}



	@Override
	public int remove(int ini, int fim) {
		int cont = 0;
		while (ini <= fim) {
			this.remove(ini);
			cont++;
			fim--;
		}
		
		return cont;
	}

	@Override
	public List<E> split(int pos) {
		int cont = 0;
		for (int i = pos; i < this.numElements; i++) {
			cont++;
		}
		
		List<E> lista = new StaticList<E>(cont);
		for (int i = pos, j = 0; i < this.numElements; i++) {
			lista.insert(elements[i], j++);
		}
		this.remove(pos, numElements-1);
		return lista;
	}
	
	
	

}
