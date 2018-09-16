
public interface Queue<E>{

	  /** Returns the number of elements in the queue.*/
	  public int numElements();  
	  /** Returns whether the queue is empty. */
	  public boolean isEmpty();
	  /** Returns whether the queue is full. */
	  public boolean isFull();
	  /** Inspects the element at the front of the queue.*/
	  public E front() throws UnderflowException; 
	  /** Inspects the element at the back of the queue.*/
	  public E back() throws UnderflowException;
	  /** Inserts an element at the rear of the queue. */
	  public void enqueue (E element) throws OverflowException; 
	  /** Removes the element at the front of the queue.*/
	  public E dequeue() throws UnderflowException;
	  
	  public boolean contains(E element);
	  
	  public void flip();
	  
	  public void enqueueWithPriority(E element) throws OverflowException, UnderflowException;
	  
	  public boolean equals(StaticQueue<E> fila) throws UnderflowException, OverflowException;
	  
	  public Queue<E> split(E element) throws OverflowException, UnderflowException;
	  
	  public void moveToBackAllOccurrencesOf(E element) throws UnderflowException, OverflowException;
	  
	  public void ensureCapacity(int capacity) throws UnderflowException;

}
