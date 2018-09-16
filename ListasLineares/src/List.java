
public interface List<E> {
	
	public int numElements();

	public boolean isEmpty();
	
	public boolean isFull();
	
	public void insert(E element, int pos);
	
	public E remove(int pos);
	
	public E get(int pos);
	
	public int search(E element);

	public boolean remover(E element);
	
	public void insertAfter(E obj1, E obj2);
	
	public void swap(int pos1, int pos2);
	
	public void flip();
	
	public void insert(List<E> lista, int pos);
	
	public void dedup();
	
	public boolean equals(List<E> lista);
	
	//public List<E> clone(List<E> lista);
	
	public int remove(int ini, int fim);
	
	public List<E> split(int pos);
}
