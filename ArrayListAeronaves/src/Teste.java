
public class Teste {

	public static void main(String[] args) {


		Gerenciamento g = new Gerenciamento();
		
		g.insereFabricante();
		g.insereAeronave();
		g.insereFabricante();
		g.insereAeronave();
		
		g.exibeDados();
		g.pesquisar(12);
		
		g.removeFabricante(12);
		g.removerAeronave("p-1212");
		
		g.exibeDados();
		
		g.salvarDados();
	}

}
