
public class StaticList<E> implements List<E> {
	
	protected E[] elements;
	int numElements;
	

	public StaticList(int maxSize) {
	    elements = (E[])new Object[maxSize];
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
	public void insert(Object element, int pos){
		// verifica se há espaço na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posição é válida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
			
		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo elemento
			for (int i = numElements-1; i >= pos; i--)
				elements[i+1] = elements[i];
			
		// armazena o novo elemento e ajusta o total
		elements[pos] = (E) element;
		numElements++;

		
	}

	@Override
	public E remove(int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
			
	// guarda uma referência temporária ao elemento removido
		E element = elements[pos];
			
	// desloca para a esquerda os elementos necessários,
	// sobrescrevendo a posição que está sendo removida
		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];
			
	// define para null a posição antes ocupada pelo último,
	// para que a coleta de lixo possa atuar, e ajusta o total
			elements[numElements-1] = null;
			numElements--;
			return element;

	}

	@Override
	public E get(int pos) {
		// verifica se a posição é válida
	  	if (pos < 0  ||  pos >= numElements)
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
	
	public StaticList<E> clone(){
		StaticList<E> ret = new StaticList<>(this.numElements);
		for(int i=0; i<this.numElements; i++)
			ret.insert(this.get(i), ret.numElements);
		return ret;
	}

}
