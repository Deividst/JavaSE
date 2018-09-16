import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciamento {

	private ArrayList<Aeronave> aeronaves = new ArrayList<Aeronave>();
	private ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
	private int chaveAux1 = 1;
	private int chaveAux2 = 1;
	
	Scanner s = new Scanner(System.in);
	
	public void insereFabricante() {
		
		System.out.println("Informe o nome do Fabricante:");
		String nomeFab = s.nextLine();
		System.out.println("Informe o código do Fabricante:");
		int codigo = s.nextInt();
		this.fabricantes.add(new Fabricante(chaveAux1++,nomeFab,codigo));
	}
	
	public void insereAeronave() {
		if(fabricantes.isEmpty() == false) {
			System.out.println("Informe o nome da Aeronave:");
			String nomeAero = s.nextLine();
			System.out.println("Informe o modelo da Aeronave:");
			String modelo = s.nextLine();
			System.out.println("Informe a matricula da Aeronave:");
			String matricula = s.nextLine();
			System.out.println("Escolha um Fabricante e digite seu código");
			for (Fabricante f : fabricantes) {
				System.out.println("Nome: [" + f.getNomeFabricante() + "]" + "Código: [" + f.getCodigoFabricante() +"]");
			}
			int codigo = s.nextInt();
			aeronaves.add(new Aeronave(chaveAux2++, nomeAero, modelo, matricula, codigo));
		}else {
			System.out.println("Não é possivel cadastrar aeronaves sem fornecedores");
		}
		
	}
	
	public void removerAeronave(String matricula) {
		Aeronave aux = null;
		for (Aeronave aeronave : aeronaves) {
			if(aeronave.getMatriculaAeronave().equalsIgnoreCase(matricula)) {
				aux = aeronave;
			}
		}
		aeronaves.remove(aux);
		
		System.out.println("Aeronave removida com sucesso");
	}
	
	public void removeFabricante(int codigo) {
		Fabricante aux = null;
		Aeronave aux2 = null;
		int cont = 0;
		for (Fabricante fabricante : fabricantes) {
			if(fabricante.getCodigoFabricante() == codigo) {
				aux = fabricante;
				do {
				for (Aeronave aeronave : aeronaves) {
					if(aeronave.getCodigoFabricante() == codigo) {
						aux2 = aeronave;
					}
					cont++;
				}
				aeronaves.remove(aux2);
				}while(cont < aeronaves.size());
			}
		}
		
		fabricantes.remove(aux);
		
		System.out.println("Fabricante removido com sucesso");
		
	}
	
	public void exibeDados() {
		for (Aeronave aeronave : aeronaves) {
			System.out.println(aeronave.toString());
		}
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.toString());
		}
	}
	
	public String pesquisar(int codigo) {
		int cont = 0;
		String textoFabricante = "";
		String textoAeronave = "";
		do {
			for (Fabricante fabricante : fabricantes) {
				if(fabricante.getCodigoFabricante() == codigo) {
					textoFabricante += fabricante.toString() + "\n";
				}
				for (Aeronave aeronave : aeronaves) {
					if(aeronave.getCodigoFabricante() == codigo) {
						textoAeronave += aeronave.toString() + "\n";
					}
				}
				
				cont++;
			}
			
		} while (cont < fabricantes.size());
		
		return textoFabricante + "\n" + textoAeronave;
	}
	
	public void salvarDados() {
		try {
			FileWriter fw = new FileWriter("dados.txt");
			PrintWriter out = new PrintWriter(fw);
			
			for (Aeronave aeronave : aeronaves) {
				out.println(aeronave.toString());
			}
			
			for (Fabricante fabricante : fabricantes) {
				out.println(fabricante.toString());
			}
			out.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
}
