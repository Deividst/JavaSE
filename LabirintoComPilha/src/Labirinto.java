import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Labirinto {

	char[][] lab = new char[14][21];
	Stack<Celula> pilha = new Stack<Celula>();

	public char[][] getLab() {
		return lab;
	}

	public void setLab(char[][] lab) {
		this.lab = lab;
	}

	public void encontraSaida(int linha, int coluna) {
		this.pilha.push(new Celula(linha, coluna));
		lab[linha][coluna] = 'X';
		boolean achei = true;
		while (achei) {

			exibeLabirinto(lab);

			linha = pilha.peek().getLinha();
			coluna = pilha.peek().getColuna();
			if (lab[linha - 1][coluna] == 'S') {
				achei = false;
				System.out.println("Encontrei a saida");
			} else if (lab[linha - 1][coluna] == '.') {
				this.pilha.push(new Celula(linha - 1, coluna));
				lab[linha - 1][coluna] = 'X';
			} else if (lab[linha][coluna - 1] == '.') {
				this.pilha.push(new Celula(linha, coluna - 1));
				lab[linha][coluna - 1] = 'X';
			} else if (lab[linha][coluna + 1] == '.') {
				this.pilha.push(new Celula(linha, coluna + 1));
				lab[linha][coluna + 1] = 'X';
			} else if (lab[linha - 1][coluna] == '#' && lab[linha][coluna - 1] == '#'
					&& lab[linha][coluna + 1] == '#') {
				try {
					this.pilha.pop();
					lab[linha][coluna] = '^';
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
			} else if (lab[linha - 1][coluna] != '.' && lab[linha][coluna - 1] != '.'
					&& lab[linha][coluna + 1] != '.') {
				try {
					this.pilha.pop();
					lab[linha][coluna] = '^';
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void exibeLabirinto(char[][] lab) {
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				System.out.print(lab[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void lerArquivo() {
		try {
			FileReader f = new FileReader("labirinto.txt");
			BufferedReader in = new BufferedReader(f);
			String linha;
			int cont = 0;
			while ((linha = in.readLine()) != null) {
				char[] aux = linha.toCharArray();
				for (int i = 0; i < aux.length; i++) {
					lab[cont][i] = aux[i];
				}

				cont++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
