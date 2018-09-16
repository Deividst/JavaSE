
public class Praticando {

	// exercicio 1 A(F)7,9,2,4,3 B(V)
	//Exercicio 2
	public static void transfereFila(StaticQueue<Integer> q1, StaticQueue<Integer> q2)
			throws UnderflowException, OverflowException {
		StaticQueue<Integer> aux = new StaticQueue<>(q1.numElements() + q2.numElements());
		Integer elemento;
		while (!aux.isFull()) {
			if (!q2.isEmpty()) {
				elemento = q2.dequeue();
				aux.enqueue(elemento);
			} else {
				elemento = q1.dequeue();
				aux.enqueue(elemento);
			}
		}

		q1 = aux;
	}
	//Exercicio 3
	public static void exterminateFromQueue(Queue<Character> q, char element) throws UnderflowException, OverflowException {
		Character aux = q.back();
		Character elemento;
		while (q.front() != aux) {
			if(q.front() == element) {
				q.dequeue();
			}else {
				elemento = q.dequeue();
				q.enqueue(elemento);
			}
		}
	}
	
	//TEsteGrauB
	public Character[] invertLetters(StaticQueue<Character> letters, String word) throws UnderflowException, OverflowException {
		StaticQueue<Character> filaAux = new StaticQueue<>(letters.numElements());
		Character aux;
		String texto = "";
		int tamanho = letters.numElements();
		
		while (tamanho > 0) {
			aux = letters.dequeue();
			letters.enqueue(aux);
			texto += aux;
			tamanho--;
		}
		if(word.equals(texto)) {
			
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		StaticQueue<Integer> q1 = new StaticQueue<>(5);
		StaticQueue<Integer> q2 = new StaticQueue<>(5);
		int i = 1;
		int j = 6;
		while (!q1.isFull() && !q2.isFull()) {
			try {
				q1.enqueue(i++);
				q2.enqueue(j++);
			} catch (OverflowException e) {
				e.printStackTrace();
			}
		}
		
//		try {
//			transfereFila(q1, q2);
//		} catch (UnderflowException | OverflowException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		StaticQueue<Character> filaChar = new StaticQueue<>(5);
			try {
				filaChar.enqueue('A');
				filaChar.enqueue('B');
				filaChar.enqueue('C');
				filaChar.enqueue('A');
				filaChar.enqueue('D');
			} catch (OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				exterminateFromQueue(filaChar, 'A');
			} catch (UnderflowException | OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				q2.enqueue(q1);
			} catch (UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StaticQueue<Character> filaChar2 = new StaticQueue<>(5);
			try {
				filaChar2.enqueue('A');
				filaChar2.enqueue('B');
				filaChar2.enqueue('C');
				filaChar2.enqueue('D');
			} catch (OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				filaChar2.enqueueWithPriority('X');
			} catch (OverflowException | UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StaticQueue<Integer> filaEquals = new StaticQueue<>(5);
			StaticQueue<Integer> filaEquals2 = new StaticQueue<>(5);
			int t = 0;
			int k = 0;
			while (!filaEquals.isFull()) {
				try {
					filaEquals.enqueue(t++);
					filaEquals2.enqueue(k++);
				} catch (OverflowException e) {
					e.printStackTrace();
				}
			}
			
			try {
				filaEquals.equals(filaEquals2);
			} catch (UnderflowException | OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				filaChar2.split('C');
			} catch (OverflowException | UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StaticQueue<Character> filaChar3 = new StaticQueue<>(5);
			try {
				filaChar3.enqueue('C');
				filaChar3.enqueue('B');
				filaChar3.enqueue('C');
				filaChar3.enqueue('D');
			} catch (OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				filaChar3.moveToBackAllOccurrencesOf('C');
			} catch (UnderflowException | OverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
