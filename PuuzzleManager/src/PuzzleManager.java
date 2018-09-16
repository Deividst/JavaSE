import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PuzzleManager {

	private String[][] puzzle1 = new String[46][81];
	private String[][] puzzle2 = new String[46][81];
	private String[][] puzzle3 = new String[46][81];
	private String[][] puzTeste = new String[46][81];
	int[] nums = new int[9];
	ArrayList<String[][]> embaralhado = new ArrayList<String[][]>();
	ArrayList<String[][]> listaPartes = new ArrayList<String[][]>();

	public String[][] getPuzzle1() {
		return puzzle1;
	}

	public void setPuzzle1(String[][] puzzle1) {
		this.puzzle1 = puzzle1;
	}

	public String[][] getPuzzle2() {
		return puzzle2;
	}

	public void setPuzzle2(String[][] puzzle2) {
		this.puzzle2 = puzzle2;
	}

	public String[][] getPuzzle3() {
		return puzzle3;
	}

	public void setPuzzle3(String[][] puzzle3) {
		this.puzzle3 = puzzle3;
	}

	public String[][] getPuzTeste() {
		return puzTeste;
	}

	public void setPuzTeste(String[][] puzTeste) {
		this.puzTeste = puzTeste;
	}

	public ArrayList<String[][]> getEmbaralhado() {
		return embaralhado;
	}

	public void setEmbaralhado(ArrayList<String[][]> embaralhado) {
		this.embaralhado = embaralhado;
	}

	public ArrayList<String[][]> getListaPartes() {
		return listaPartes;
	}

	public void setListaPartes(ArrayList<String[][]> listaPartes) {
		this.listaPartes = listaPartes;
	}
	
	public void geraRelatorio(String[][] imagem) {

		try {
			FileWriter fw = new FileWriter("relatoriopuzzle.txt");
			PrintWriter out = new PrintWriter(fw);
			int qdtAcerto = this.verificaQuadrante();
			out.println("Imagem Escolhida Original:");
			for (int i = 0; i < imagem.length; i++) {
				for (int j = 0; j < imagem[i].length; j++) {
					out.print(imagem[i][j]);
				}
				out.println("");
			}
			
			out.println("Imagem Escolhida embaralhada:");
			for (int i = 0; i < puzTeste.length; i++) {
				for (int j = 0; j < puzTeste[i].length; j++) {
					out.print(puzTeste[i][j]);
				}
				out.println("");
			}
			out.println("Quantidade de acertos: "+ qdtAcerto);		
			out.close();
			
			System.out.println("Relatório criado com sucesso");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[][] lerArquivo(String nomeArquivo) {
		char[][] auxPuzz = new char[46][81];
		String[][] puzz = new String[46][81];
		try {
			FileReader f = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(f);
			String linha;
			int cont = 0;

			while ((linha = br.readLine()) != null) {
				char[] aux = linha.toCharArray();
				for (int i = 0; i < aux.length; i++) {
					auxPuzz[cont][i] = aux[i];
				}
				cont++;
			}

			for (int i = 0; i < puzz.length; i++) {
				for (int j = 0; j < puzz[i].length; j++) {
					puzz[i][j] = Character.toString(auxPuzz[i][j]);
				}
			}

		} catch (IOException e) {

			e.getStackTrace();
		}
		return puzz;

	}

	public void criaPartes(String[][] imagem) {
		for (int i = 1; i < 10; i++) {
			this.listaPartes.add(new String[15][27]);
		}
		int cont = 0;
		for (int i = 0; i < imagem.length; i = i + 15) {
			for (int j = 0; j < imagem[i].length; j = j + 27) {
				int colunaAux = j;
				int linhaAux = i;
				int linha = 0;
				while (linha < 15) {
					for (int k = 0; k < 27; k++) {
						listaPartes.get(cont)[linha][k] = imagem[linhaAux][colunaAux];
						colunaAux++;
					}
					linhaAux++;
					linha++;
					colunaAux = j;
				}
				cont++;

			}
			if (i == 30) {
				i = 45;
			}

		}

	}

	public void embaralhamento() {
		Random r = new Random();
		int cont = 0;
		while (cont < 8) {
			int aux = r.nextInt(9);
			for (int i = 0; i < nums.length; i++) {
				if (aux == nums[i]) {
					break;
				} else if (nums[i] == 0) {
					nums[cont] = aux;
					cont++;
					break;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			this.embaralhado.add(this.listaPartes.get(nums[i]));
		}

	}

	public void exibePuzzle(String[][] puzzle) {
		for (int i = 0; i < puzzle.length - 1; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.println();
		}
	}

	public void transfereArraylist() {
		int cont = 0;
		for (int i = 0; i < puzTeste.length; i = i + 15) {
			for (int j = 0; j < puzTeste[i].length; j = j + 27) {
				int colunaAux = j;
				int linhaAux = i;
				int linha = 0;
				while (linha < 15) {
					for (int k = 0; k < 27; k++) {
						puzTeste[linhaAux][colunaAux] = embaralhado.get(cont)[linha][k];
						colunaAux++;
					}
					linhaAux++;
					linha++;
					colunaAux = j;
				}
				cont++;

			}
			if (i == 30) {
				i = 45;
			}

		}
	}

	public int verificaQuadrante() {
		Scanner s = new Scanner(System.in);
		int cont = 0;
		int i = 1;
		while (i <= 9) {
			System.out.println("Para onde foi o quadrante " + i++ + " da imagem original?");
			int quadrante = s.nextInt();
			if (i-2 == nums[quadrante-1]) {
				cont = cont + 1;
			}
		}
		
		return cont;
	}
}
