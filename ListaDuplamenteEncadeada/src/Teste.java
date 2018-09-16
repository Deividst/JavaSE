import exercicioPilha.*;
import exercicioPilha.OverflowException;

public class Teste {

//	public static StaticStack<String> retornaPilha(DoublyLinkedList<String> Dlista) throws OverflowException{
//		DNode<String> current = Dlista.tail;
//		StaticStack<String> pilha = new StaticStack<>(Dlista.numElements);
//		while(current.getPrevious() != null) {
//			pilha.push(current.getElement());
//			current = current.getPrevious();
//		}
//		
//		return pilha;
//	}
	
	public static StaticStack<String> retornaPilha(DoublyLinkedList<String> lista) throws OverflowException{
		if(lista != null && !lista.isEmpty()) {
			StaticStack<String> pilha = new StaticStack<>(lista.numElements());
			retornaPilha(lista, pilha, lista.numElements()-1);
		}
		
		return null;
	}
	
	private static void retornaPilha(DoublyLinkedList<String> lista,StaticStack<String> pilha, int i) throws OverflowException{
		if(i >= 0) {
			pilha.push(lista.get(i)); 
			retornaPilha(lista, pilha, i-1);
		}
	}
	
//	public static boolean isOrdenada(DoublyLinkedList<Integer> lista) {
//		
//		DNode<Integer> current = lista.head;
//		while(current.getNext() != null) {
//			if(current.getElement() > current.getNext().getElement()) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
	
	public static boolean isOrdenada(DoublyLinkedList<Integer> lista) {
		if(lista != null && !lista.isEmpty()) {
			return isOrdenada(lista, 0);
		}
		
		return false;
	}
	
	private static boolean isOrdenada(DoublyLinkedList<Integer> lista, int i) {
		if(i == lista.numElements-1) {
			return true;
		}
		
		if(lista.get(i) > lista.get(i)+1) {
			return false;
		}
		
		return isOrdenada(lista,i+1);
	}
	
	public static int pesquisaBinaria(DoublyLinkedList<Integer> lista, int elemento) {
		if(lista == null || lista.isEmpty() || !Teste.isOrdenada(lista)) {
			throw new UnderflowException();
		}
		return pesquisaBinaria(lista, elemento, 0, lista.numElements());
	}
	
	private static int pesquisaBinaria(DoublyLinkedList<Integer> lista, int elemento, int inf, int sup) {
		if(inf > sup) {
			return -1;
		}
		
		int med = (inf + sup) / 2;
		
		if(elemento == lista.get(med)) {
			return med;
		} else if(elemento < lista.get(med)) {
			return pesquisaBinaria(lista, elemento, inf, med-1);
		}else {
			return pesquisaBinaria(lista, elemento, med+1, sup);
		}
		
	}
	
	public static StaticStack<Integer> accum(DoublyLinkedList<Integer> lista) throws OverflowException {
		if(lista != null && !lista.isEmpty()) {
			StaticStack<Integer> pilha = new StaticStack<>(lista.numElements());
			 accum(lista,pilha,0,0);
			 return pilha;
		}
		
		return null;
	}
	
	private static void accum(DoublyLinkedList<Integer> lista,StaticStack<Integer> pilha, int soma, int i ) throws OverflowException{
		
		if( i < lista.numElements-1) {
			soma += lista.get(i);
			pilha.push(soma);
			
			accum(lista, pilha, soma, i+1);
		}
	}
	
	public static void main(String[] args) {
		

	}

}
