import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		
		
		PuzzleManager puz = new PuzzleManager();
		Scanner s = new Scanner(System.in);
		
		puz.setPuzzle1(puz.lerArquivo("arq1.txt"));
		puz.setPuzzle2(puz.lerArquivo("arq2.txt"));
		puz.setPuzzle3(puz.lerArquivo("arq3.txt"));
		
		
		
		System.out.println("Escolha uma das imagens");
		System.out.println("(1) - Imagem do Internacional");
		puz.exibePuzzle(puz.getPuzzle1());
		System.out.println("(2) - Imagem da Flor");
		puz.exibePuzzle(puz.getPuzzle2());
		System.out.println("(3) - Imagem da Casa");
		puz.exibePuzzle(puz.getPuzzle3());
		int op = s.nextInt();
		
		switch (op) {
		case 1:
			puz.criaPartes(puz.getPuzzle1());
			puz.embaralhamento();
			puz.transfereArraylist();
			puz.exibePuzzle(puz.getPuzTeste());
			puz.geraRelatorio(puz.getPuzzle1());
			break;
		case 2:
			puz.criaPartes(puz.getPuzzle2());
			puz.embaralhamento();
			puz.transfereArraylist();
			puz.exibePuzzle(puz.getPuzTeste());
			puz.geraRelatorio(puz.getPuzzle2());
			break;
		case 3:
			puz.criaPartes(puz.getPuzzle3());
			puz.embaralhamento();
			puz.transfereArraylist();
			puz.exibePuzzle(puz.getPuzTeste());
			puz.geraRelatorio(puz.getPuzzle3());
			break;

		}
	
		 
	}

}
