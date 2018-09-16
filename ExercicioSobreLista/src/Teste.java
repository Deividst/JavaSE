import java.util.ArrayList;

public class Teste {
	
	public static void inverteElementos(List<Double> lista) {
		int i = 0;
		int j = lista.numElements();
		while(i < j) {
			double aux = lista.get(i);
			lista.insert(lista.get(j), i);
			lista.insert(aux, j);
			i++;
			j--;
		}
	}
	
	public static int pesquisaBinaria(List<Integer> lista, int x) {
		int inf = 0;
		int sup = lista.numElements()-1;
		
		while(inf <= sup ) {
			int med = (inf + sup)/2;
			if(x == lista.get(med)) {
				return med;
			}else if(x < lista.get(med)) {
				sup = med - 1;
			}else {
				inf = med + 1;
			}
		}
		return -1;
	}
	
	public static void imprimeInvertido(List<String> lista) {
		if(lista != null) {
			imprimeInvertido(lista, lista.numElements());
		}
		
	}

	private static void imprimeInvertido(List<String> lista, int i) {
		if(i >= 0) {
			System.out.println(lista.get(i));
			imprimeInvertido(lista, i-1);
		}
	}
	
	/*Exercicio 4:
	 * public void metodo1(List<Integer> lista)
	 * O Método 1 pode receber uma lista sequencial e uma lista dinamica. 

		public void metodo2(StaticList<Integer> lista)
		Já o método 2 só pode receber uma lista sequencial.
	 */
	
	public static PostoCombustivel postoMenorValorGasolina(List<PostoCombustivel> postos) {
		if(postos != null) {
			return postoMenorValorGasolina(postos, 0, postos.get(0));
		}
		
		return null;
	}
	
	private static PostoCombustivel postoMenorValorGasolina(List<PostoCombustivel> postos, int i,PostoCombustivel menor) {
		if(i <= postos.numElements()-1) {
			if(postos.get(i).getValorGasolina() < menor.getValorGasolina()) {
				menor = postos.get(i);
			}
			return postoMenorValorGasolina(postos, i+1, menor);
		}
		return menor;
	}
	
	public static boolean isIguais(StaticList<String> lista1, StaticList<String> lista2) {
		if(lista1 == null || lista2 == null) {
			return true;
		}else if(lista1.numElements != lista2.numElements()) {
			return false;
		}
		
		return isIguais(lista1, lista2, 0);
	}
	
	private static boolean isIguais(StaticList<String> lista1, StaticList<String> lista2, int i) {
		
		if(i < lista1.numElements) {
			if(lista1.get(i).equalsIgnoreCase(lista2.get(i))) {
				isIguais(lista1, lista2, i+1);
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	public static String criaString(StaticList<String> lista) {
		String texto = "";
		
		for (int i = 0; i <= lista.numElements(); i++) {
			texto += lista.get(i);
		}
		
		return texto;
	}
	
	public static List<Integer> listaComMaiorSoma(List<Integer>[] listas){
		int posMaiorLista = 0;
		int soma = 0;
		int maiorSoma = 0;
		for(int i = 0; i < listas.length;i++) {
			for(int j = 0; j < listas[i].numElements(); j ++) {
				soma += listas[i].get(j);
			}
			if(soma > maiorSoma) {
				maiorSoma = soma;
				posMaiorLista = i;
			}
		}
		
		return listas[posMaiorLista];
	}
	
	public static void main(String[] args) {
		StaticList<PostoCombustivel> lista = new StaticList<>(5);
		int i = 0;
		while(!lista.isFull())
			lista.insert(new PostoCombustivel("Posto "+(i+++1), 10*i), lista.numElements());
		
		System.out.println("LISTA:");
		System.out.println(lista);
		
		StaticList<PostoCombustivel> listaClone = lista.clone();
		
		System.out.println("LISTA CLONE:");
		System.out.println(listaClone);
		
		listaClone.remove(3);
		
		System.out.println("LISTA CLONE:");
		System.out.println(listaClone);
		
		System.out.println("LISTA:");
		System.out.println(lista);
		
		System.out.println(lista.equals(listaClone));
		//Object[] a = (Object[])lista.elements;
		//Object[] b = (Object[])listaClone.elements;
		//System.out.println(((Object[])lista.elements).equals((Object[])listaClone.elements));

		
		System.out.println("ARRAY LIST");
		ArrayList<PostoCombustivel> postos = new ArrayList<>();
		for(i=0; i<5; i++)
			postos.add(new PostoCombustivel("NOVO POSTO "+i, 100-i));
		
		ArrayList<PostoCombustivel> postosClone = (ArrayList<PostoCombustivel>)postos.clone();
		
		postosClone.get(1).setNome("Geromel");
		
		System.out.println("POSTOS");
		System.out.println(postos);
		
		System.out.println("POSTOS CLONE");
		System.out.println(postosClone);
		
		PostoCombustivel p1 = new PostoCombustivel("Lalala", 1);
		PostoCombustivel p2 = null;
		try {
			p2 = p1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p2.setNome("FUNCIONAAAAAA");
		System.out.println(p1);
		System.out.println(p2);
		
		
		
	}

}
