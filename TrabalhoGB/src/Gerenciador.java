import java.util.Scanner;

public class Gerenciador {
	
	
	
	public void iniciaSistema() {
		DiscoVirtual dv = new DiscoVirtual();
		dv.testa();
		Scanner s = new Scanner(System.in);
		int operacao;

		while (true) {

			System.out.println("Escolha oque deseja fazer?:");
			System.out.println("(1) - Criar novo arquivo\n" 
							+ "(2) - Criar uma nova pasta\n" 
							+ "(3) - Lista todos arquivos\n" 
							+ "(4) - Busca arquivo especifico por nome\n" 
							+ "(5) - \n" 
							+ "(6) - Entrar em sub pasta\n"
							+ "(7) - Voltar ao diretório raiz\n"
							+ "(8) - Remover arquivo por nome\n"
							+ "(9) - Remover uma pasta");
			
			operacao = s.nextInt();

			if (operacao <= 0 || operacao > 10) {
				System.out.println("Operação invalida");
				continue;
			}

			switch (operacao) {
			case 1:
				dv.criaArquivo();
				break;
			case 2:
				dv.criaDiretorio();
				break;
			case 3:
				dv.listaArquivosDiretorioAtual();
				break;
			case 4:
				dv.exibirArquivoEspecifico();
				break;
			case 6:
				dv.entrarSubPasta();
				break;
			case 7:
				dv.voltaDiretorioRaiz();
				break;
			case 8:
				dv.removerArquivo();;
				break;
			case 9:
				dv.removerPasta();
			default:
				break;
			}
		}

	}


}
