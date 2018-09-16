public class Teste{
    public static void main(String args[]){
   
    	
//    	SLinkedList <Pessoa>list = new SLinkedList<Pessoa>();
//    	
//    	list.addFirst(new Pessoa("João", 10));
//    	list.addFirst(new Pessoa("Carlos", 30));
//    	list.addBefore(new Pessoa("Luisa", 40),1); //antes do João...
//    	list.addLast(new Pessoa("Maria", 50));  	
//    	
//    	System.out.println(list.toString());
    	
    	SLinkedList<String> lista = new SLinkedList<>();
    	lista.addLast("A");
    	lista.addLast("B");
    	lista.addLast("C");
    	lista.addLast("D");
    	lista.addLast("E");
    	lista.addLast("F");
    	
    	SLinkedList<String> outralista = new SLinkedList<>();
    	outralista.addLast("X");
    	outralista.addLast("Y");
    	outralista.addLast("Z");
    	
    	
    	System.out.println(lista.toString());
    	
    	
			try {
				lista.shuffle();
			} catch (UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    	
    	System.out.println(lista.toString());
}
    
}