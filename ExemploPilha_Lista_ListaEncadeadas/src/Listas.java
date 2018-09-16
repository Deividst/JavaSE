
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.EmptyStackException;

public class Listas{ 
  public static void main(String args[]){ 
	  
	/**************************************************************************
	 * 
	 *   LISTAS ENCADEADAS
	 *   
	 **************************************************************************/
	  
	  
    // Cria uma LinkedList de String
    LinkedList<String> lista = new LinkedList<String>();  //LinkedList eh duplamente encadeado
    
    // adiciona três elementos no final da lista
    lista.add("Cuiabá");
    lista.add("Goiânia");
    lista.add("Belo Horizonte");

    String teste = lista.pop();  //remove e retorna primeiro elemento da lista
    
    // obtém um ListIterator para percorrer toda a
    // lista, começando no primeiro elemento
    ListIterator<String> iterador = lista.listIterator(0);
    while(iterador.hasNext()){           //iterador.hasPrevious();  iterador.remove();
      String cidade = iterador.next(); 
      System.out.println(cidade); 
    }
    
    LinkedList<Coisa> l2 = new LinkedList<Coisa>();
    l2.add(new Coisa(0));
    l2.add(new Coisa(1));
    
    for(Coisa cc:l2)
    	System.out.println(cc.getVal());
    
    Coisa c=l2.peek();  //acessa elem sem tira-lo da lista
    l2.offer(c);        //insere no final
    c=l2.poll();        //devolve e remove primeiro elemento da lista
    
  
	/**************************************************************************
	 * 
	 *   DEQUES
	 *   
	 **************************************************************************/
  
    // Constructs an empty array deque with an initial capacity
    // sufficient to hold the specified number of elements.
    
    //Deque<Integer> deque = new ArrayDeque<Integer>(5);
    Deque<Coisa> deque = new ArrayDeque<Coisa>(5);
    deque.add(new Coisa(2));  //deque.add(10);
    deque.add(new Coisa(3));
    deque.add(new Coisa(4));
    deque.addFirst(new Coisa(-1));
    
    Coisa co  = deque.removeLast(); //pode gerar exceção!!!
    
    //for (Integer number : deque) {
    for (Coisa number : deque) {
      System.out.println("Number = " + number + "   "+number.getVal());
    }
    
    
	/**************************************************************************
	 * 
	 *   PILHAS (STACKS)
	 *   
	 *   The Stack class represents a last-in-first-out (LIFO) stack of objects.
	 *   It extends class Vector with five operations that allow a vector to be
	 *   treated as a stack. The usual push and pop operations are provided, as
	 *   well as a method to peek at the top item on the stack, a method to test
	 *   for whether the stack is empty, and a method to search the stack for an
	 *   item and discover how far it is from the top. 
	 **************************************************************************/

    Stack <Coisa> pilha = new Stack<Coisa>();
     pilha.push(new Coisa(10));
     pilha.push(new Coisa(11));
     pilha.push(new Coisa(12));
     pilha.push(new Coisa(13));
    
     System.out.println("desempilhando de pilha:");
     try{
        System.out.println(pilha.pop().getVal()+" "+pilha.pop().getVal());
     }
     catch(EmptyStackException e){
    	 System.out.println("pilha vazia!!!");
     }
     
     Deque<Integer> pilha2 = new ArrayDeque<Integer>();
     pilha2.push(30);
     pilha2.push(40);
     System.out.println("desempilhando de pilha2:");
     try{
         System.out.println(pilha2.pop()+" "+pilha2.pop());
      }
      catch(EmptyStackException e){
     	 System.out.println("pilha2 vazia!!!");
      }
     
        
 	/**************************************************************************
 	 * 
 	 *   FILAS (QUEUES)    (FIFO)
 	 *   
 	 **************************************************************************/
    
     Queue <Coisa> fila1 = new ArrayDeque<Coisa>(10);  //10 é a capacidade
     Queue <Coisa> fila2 = new LinkedList<Coisa>();
     Queue <Coisa> fila3 = new LinkedBlockingDeque<Coisa>();   //THREAD SAFE !!!
     Queue <Coisa> fila4 = new ArrayBlockingQueue<Coisa>(20);  //THREAD SAFE !!!
     
     try{
       fila1.add(new Coisa(200));   //no final
       fila1.add(new Coisa(300));
       fila1.add(new Coisa(400));
       Coisa primeirodafila = fila1.remove();  //remove primeiro da fila
       
       fila2.add(new Coisa (99));
       fila2.addAll(fila1);
       fila2.add(new Coisa (88));
       
       System.out.println("Fila2:");
       for(Coisa elemFila:fila2)
       	System.out.println(elemFila.getVal());       
       
       System.out.println("Fila2:");      
       fila2.removeAll(fila1);
       for(Coisa elemFila:fila2)
          	System.out.println(elemFila.getVal());     
     }
     catch(Exception e){}
  } 
}

