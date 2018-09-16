
public class Teste {

	public static void main(String[] args) {
		
		Labirinto l = new Labirinto();
		
		l.lerArquivo();
		l.exibeLabirinto(l.getLab());
		
		l.encontraSaida(12, 16);
		
		l.exibeLabirinto(l.getLab());
	}

}
