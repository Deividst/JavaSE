


public class Linear {
	
	public Integer[] evenNumbers(List<Integer> lista) {
		int cont = 0;
		for (int i = 0; i < lista.numElements(); i++) {
			if(lista.get(i) % 2 == 0) {
				cont++;
			}
		}
		
			Integer[] vetor = new Integer[cont];
		for (int i = 0; i < lista.numElements(); i++) {
			if(lista.get(i) % 2 == 0) {
				vetor[cont-1] = lista.get(i);
				cont--;
			}
		}
		
		return vetor;
		
	}
	
	public List<Character> mergeLists(List<Character> t1, List<Character> t2){
		List<Character> t3 = new StaticList<Character>((t1.numElements()) + (t2.numElements()));
		
		int i = 0;
		int j = 0;
		int k = 1;
		while (i < t1.numElements()) {
			t3.insert(t1.get(i), j);
			t3.insert(t2.get(i), k);
			
			i+=1;
			j += 2;
			k += 2;
		}
		
		return t3;
		
	}
	
	public void prependList(List<Double> t1, List<Double> t2) {
		List<Double> aux = new StaticList<Double>((t1.numElements()) + (t2.numElements()));
		int cont = 0;
		for (int i = 0; i < t2.numElements(); i++) {
			aux.insert(t2.get(i), cont);
			cont++;
		}
		
		for (int i = 0; i < t1.numElements(); i++) {
			aux.insert(t1.get(i), cont);
			cont++;
		}
		
		t1 = aux;
	}

	
	

}
