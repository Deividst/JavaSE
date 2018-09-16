package br.com.labirinto;

import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {
	
	public static void exibeLabirinto(char[][] lab) {
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				System.out.print(lab[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
 static String achaSaida(char[][] lab, int i, int j) {
		lab[i][j] = '+';
		exibeLabirinto(lab);
		
		if(lab[i-1][j] == 'S') {
			exibeLabirinto(lab);
			return "Achei a Saida";
		}
		
		if(lab[i-1][j] == '+' && lab[i][j-1] == '#' && lab[i][j+1] == '#') {
			return achaSaida(lab, i+1, j);
		}else if(lab[i-1][j] == '#' && lab[i][j-1] == '#' && lab[i][j+1] == '+' ) {
			return achaSaida(lab, i+1, j);
		}else if(lab[i-1][j] != '#' && lab[i-1][j] != '+') {
			return achaSaida(lab, i-1, j);
		}else if(lab[i-1][j] == '+' && lab[i][j-1] != '#') {
			return achaSaida(lab, i, j-1);
		}else if(lab[i-1][j] == '+' && lab[i][j+1] != '#') {
			return achaSaida(lab, i, j+1);
		}else if(lab[i][j-1] == '+' && lab[i][j+1] != '#') {
			return achaSaida(lab, i, j+1);
		}else if(lab[i][j+1] == '+' && lab[i][j-1] != '#') {
			return achaSaida(lab, i, j-1);
		}else if(lab[i-1][j] != '#') {
			return achaSaida(lab, i-1, j);
		}else if(lab[i][j-1] != '#') {
			return achaSaida(lab, i, j-1);
		}else if(lab[i][j+1] != '#') {
			return achaSaida(lab, i, j+1); 
		}else if(lab[i+1][j] =='#' ) {
			return achaSaida(lab, i, j);
		}
		
		
		return achaSaida(lab, i+1, j);
		
	}
	
			
	


	
	

	public static void main(String[] args) {

		char[][] lab = new char[14][21];

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

		} catch (Exception e) {
			
		}
		
		exibeLabirinto(lab);
		
		
		System.out.println(achaSaida(lab, 12, 12));

	}

}
