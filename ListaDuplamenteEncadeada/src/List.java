
public interface List<E> {
	
	public boolean isEmpty(); 
	//verifica se a lista está vazia
	public E get(int n);
	//Retorna o elemento contido na posição n, sem removê-lo
	public int numElements();
	//Retorna o número de elementos armazenados na lista
	public void insertFirst( E element ); 
	//insere element na frente da lista
	public void insertLast( E element );
	//insere element no final da lista
	public void insert( E element, int pos ); 
	//insere element na posição especificada por pos
	public E removeFirst(); 
	//remove e retorna o primeiro elemento da lista
	public E removeLast(); 
	//remove e retorna o último elemento da lista
	public E remove(int pos);
	//exibe o conteúdo da lista
	public int search (E element);
	//Retorna a posição na lista do elemento element



}
