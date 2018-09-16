package exercicioPilha;
public class Praticando {
	
	// Exercicio 1: p1{}, p2{}, p3{3,1,4,2}

	// Exercicio 3
	public static Integer[] itemsExcept(int number, Stack<Integer> p) {
		Integer[] vetor = new Integer[(p.numElements() - 1)];
		Integer[] aux = new Integer[(p.numElements())];
		int cont = 0;
		try {
			for (int i = 0; i < aux.length; i++) {

				aux[i] = p.pop();
				if (aux[i] != number) {
					vetor[cont] = aux[i];
					cont++;
				}

			}

			for (int i = 0; i < aux.length; i++) {
				p.push(aux[i]);
			}

		} catch (UnderflowException e) {
			e.printStackTrace();
		} catch (OverflowException e) {
			e.printStackTrace();
		}

		return vetor;
	}
	//exercicio 4
			public <E> void transferElements(Stack<E> s1, Stack<E> s2) throws UnderflowException, OverflowException {
				Stack<E> aux = new StaticStack<E>(s1.numElements());
				int tamanho = s1.numElements();
					for (int i = 0; i < tamanho; i++) {
					aux.push(s1.pop());
					}
					
					for (int i = 0; i < tamanho; i++) {
						if(!s2.isFull()) {
							s2.push(aux.pop());
						}else {
							System.out.println("Pilha est� cheia");
						}
					}
			}
	
	
	//Exercicio 8
	public static StaticStack<Integer> foobar(Stack<Integer> s1, Stack<Integer> s2) throws OverflowException, UnderflowException {
		StaticStack<Integer> s3 = new StaticStack<Integer>(s1.numElements()+s2.numElements()-1);
		 while (!s1.isEmpty() && !s2.isEmpty()) {
		int int1 = s1.top();
		int int2 = s2.top();
		s3.push(int1 > int2 ? s1.pop() : s2.pop());
		 }
		 while (!s1.isEmpty() && !s3.isFull())
			 	s3.push(s1.pop());
		 while (!s2.isEmpty())
			 s3.push(s2.pop());
		 return s3;
		} 
	
	//Exercicio 9
	public static void invertePilha(StaticStack<Integer> pilha) throws OverflowException, UnderflowException {
		StaticStack<Integer> aux = new StaticStack<>(pilha.numElements());
		for (int i = 0; i < pilha.numElements(); i++) {
			aux.push(pilha.pop());
		}
		for (int i = 0; i < pilha.numElements(); i++) {
			pilha.push(aux.pop());
		}
		
	}
	
	//exercicio 10
	public static int procuraElemento(int num, StaticStack<Integer> pilha) throws OverflowException, UnderflowException {
		StaticStack<Integer> aux = new StaticStack<Integer>(pilha.numElements());
		int tamanho = pilha.numElements()-1;
		int indice = tamanho;
		int result = 0;
		while (!pilha.isEmpty()) {
			int valor = pilha.pop();
			if(valor == num) {
				result = indice;
				aux.push(valor);
				while(indice != tamanho) {
					pilha.push(aux.pop());
						indice++;
				}
				break;
			}else {
				aux.push(valor);
				indice--;
			}
		}
		
		return result;
	}
	
	//Exercicio 11
	public static boolean checkBrackets(Stack<Character> s1) throws UnderflowException, OverflowException {
		StaticStack<Character> aux = new StaticStack<Character>(s1.numElements());
		int abrePerentese = 0;
		int fechaParentese = 0;
		Character elemento;
		while(!s1.isEmpty()) {
			elemento = s1.pop();
			if(elemento.equals('(')) {
				abrePerentese++;
			}else if(elemento.equals(')')) {
				fechaParentese++;
			}
			aux.push(elemento);
		}
		
		while(!aux.isEmpty()) {
			s1.push(aux.pop());
		}
		
		if(abrePerentese != fechaParentese) {
			return false;
		}
		
		return true;
 	}
	
	
	public static void main(String[] args) throws OverflowException {

		Stack<Integer> p1 = new StaticStack<Integer>(5);
		Stack<Integer> p2 = new StaticStack<Integer>(5);
		Stack<Integer> p3 = new StaticStack<Integer>(5);

		try {
			p1.push(1);
			p1.push(2);
			p1.push(3);
			p1.push(4);

			int temp = p1.pop();
			p2.push(temp);
			p3.push(p1.pop());
			p2.push(p1.pop());
			temp = p1.pop();
			p3.push(temp);
			p1.push(p2.pop());
			p3.push(p2.pop());
			p3.push(p1.pop());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// Exercicio 2:

		Stack<Integer> mp1 = new StaticStack<Integer>(5);
		Stack<Integer> mp2 = new StaticStack<Integer>(5);
		Stack<Integer> mp3 = new StaticStack<Integer>(5);

		try {
			mp1.push(10);
			mp1.push(20);
			mp1.push(30);
			mp1.push(40);
			mp2.push(mp1.pop());
			mp2.push(mp1.pop());
			mp3.push(mp1.pop());
			mp3.push(mp1.pop());
			mp1.push(mp2.pop());
			mp3.push(mp2.pop());
			mp3.push(mp1.pop());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		//testa Exercicio 3
		Stack<Integer> pilha3 = new StaticStack<Integer>(5);
		pilha3.push(10);
		pilha3.push(20);
		pilha3.push(30);
		pilha3.push(40);
		
		itemsExcept(30, pilha3);
		
		Stack<Integer> ex1 = new StaticStack<Integer>(5);
		ex1.push(1);
		ex1.push(2);
		ex1.push(3);
		ex1.push(4);
		ex1.push(5);
		StaticStack<Integer> ex2 = new StaticStack<Integer>(6);
		ex2.push(1);
		ex2.push(2);
		ex2.push(3);
		ex2.push(4);
		ex2.push(5);
		
		try {
			foobar(ex1, ex2);
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//exercicio 10
		//testa Exercicio 3
			Stack<Integer> pilha10 = new StaticStack<Integer>(5);
				pilha10.push(10);
				pilha10.push(20);
				pilha10.push(30);
				pilha10.push(40);
		
		
		try {
			procuraElemento(20, (StaticStack<Integer>) pilha10 );
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//exercicio 11
		StaticStack<Character> pilhaChar = new StaticStack<Character>(5);
		pilhaChar.push('(');
		pilhaChar.push('B');
		pilhaChar.push('+');
		pilhaChar.push('A');
		pilhaChar.push(')');
		
		try {
			checkBrackets(pilhaChar);
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
