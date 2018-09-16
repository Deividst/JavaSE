package exercicioPilha;
import java.time.chrono.ThaiBuddhistEra;

public class StaticStack<E> implements Stack<E> {
	
	// �ndice do elemento no topo da pilha
		protected int top;

		// Array que armazena as refer�ncias para os elementos
		protected E elements[];

		/**
		 * Constr�i uma pilha com um tamanho m�ximo.
		 * @param maxSize O tamanho m�ximo da pilha
		 */
		public StaticStack(int maxSize) {
			elements = (E[])new Object[maxSize];
			top = -1;
		}

		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#isEmpty()
		 */
		public boolean isEmpty() {
			return top == -1;
		}

		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#isFull()
		 */
		public boolean isFull() {
			return top == elements.length - 1;
		}

		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#numElements()
		 */
		public int numElements() {
			return top + 1;
		}
		
		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#push(java.lang.Object)
		 */
		public void push(E element) throws OverflowException {
			if (isFull())
				throw new OverflowException("ERRO");
			elements[++top] = element;
		}

		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#pop()
		 */
		public E pop() throws UnderflowException {
			if (isEmpty())
				throw new UnderflowException();
			E element = elements[top];
			elements[top--] = null; // p/ coleta de lixo
			return element;
		}

		/* (non-Javadoc)
		 * @see br.unisinos.prog2lab2.Stack#top()
		 */
		public E top() throws UnderflowException {
			if (isEmpty())
				throw new UnderflowException();
			return elements[top];
		}

		/**
		 * Retorna uma representa��o String da pilha.
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			if (isEmpty())
				return "[Empty]";
			else {
				String s = "[";
				for (int i = numElements() - 1; i >= 0; i--) {
					s += "\n" + elements[i];
				}
				s += "\n]";
				return s;
			}
		}
		
		//exercicio 12
				public boolean contains(E element) {
					for (int i = 0; i < elements.length; i++) {
						if(this.elements[i] == element) {
							return true;
						}
					}
					return false;
				}
				
		//exercicio 13
		public void flip() {
			E[] aux = (E[]) new Object[this.elements.length];
			
			for (int i = aux.length, k = 0; i > 0; i--) {
				aux[k++] = this.elements[i];
			}
			
			this.elements = aux;
		}
		
		//Exercicio 14
		public void push(StaticStack<E> pilha) throws OverflowException, UnderflowException {
			StaticStack<E> aux = new StaticStack<>(pilha.numElements());
			while(!pilha.isEmpty()) {
				aux.push(pilha.pop());
			}
			while(!aux.isEmpty()) {
				pilha.push(aux.top());
				this.push(aux.pop());
			}
		}
		
		//Exercicio 15
		public boolean equals(StaticStack<E> pilha) throws UnderflowException, OverflowException {
			StaticStack<E> aux = new StaticStack<>(pilha.numElements());
			E element;
			for (int i = 0; i < elements.length; i++) {
				element = pilha.pop();
					if(element.equals(this.elements[i])) {
						return true;
					}
			}
			
			for (int i = 0; i < elements.length; i++) {
				pilha.push(aux.pop());
			}
			
			return false;
			
		}
		
		//TesteGrau_B
		public void clear() throws UnderflowException{
			while (!this.isEmpty()) {
				this.pop();
			}
		}
		
		
		
		
	}