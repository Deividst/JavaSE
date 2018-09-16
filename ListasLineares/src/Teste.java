
public class Teste {
	
	public static void main(String[] args) {
		
		Linear l = new Linear();
		
		List<Integer> listaInteiros = new StaticList<Integer>(10);
		
		for (int i = 0; i < 10; i++) {
			listaInteiros.insert(i+1, i);
		}
		
		l.evenNumbers(listaInteiros);
		
		List<Character> listaChar1 = new StaticList<Character>(4);
		listaChar1.insert('A', 0);
		listaChar1.insert('B', 1);
		listaChar1.insert('C', 2);
		listaChar1.insert('D', 3);
		List<Character> listaChar2 = new StaticList<Character>(4);
		listaChar2.insert('A', 0);
		listaChar2.insert('B', 1);
		listaChar2.insert('C', 2);
		listaChar2.insert('D', 3);
		
		l.mergeLists(listaChar1, listaChar2);
		
		List<Double> listaDouble1 = new StaticList<Double>(2);
		listaDouble1.insert(1.0, 0);
		listaDouble1.insert(2.0, 1);
		List<Double> listaDouble2 = new StaticList<Double>(2);
		listaDouble2.insert(3.0, 0);
		listaDouble2.insert(3.0, 1);
		
		l.prependList(listaDouble1, listaDouble2);
		
		System.out.println(listaChar1.remover('A'));
		
		List<Integer> listaInteiros2 = new StaticList<Integer>(5);
		listaInteiros2.insert(22, 0);
		listaInteiros2.insert(33, 1);
		listaInteiros2.insert(44, 2);
		listaInteiros2.insert(55, 3);
		listaInteiros2.insert(66, 4);
		
		listaInteiros.insertAfter(4, 20);
		listaInteiros.swap(0, 9);
		listaInteiros.flip();
		listaInteiros.insert(listaInteiros2, 3);
		System.out.println(listaInteiros);
		
		
		List<Integer> listaInteiros3 = new StaticList<Integer>(6);
		listaInteiros3.insert(22, 0);
		listaInteiros3.insert(33, 1);
		listaInteiros3.insert(44, 2);
		listaInteiros3.insert(55, 3);
		listaInteiros3.insert(66, 4);
		
		listaInteiros3.insert(22, 3);
		listaInteiros3.dedup();
		
		System.out.println(listaInteiros3.equals(listaInteiros));
		
		//System.out.println(listaInteiros.remove(2, 8));
		
		listaInteiros.split(5);
		
	}
	
}
