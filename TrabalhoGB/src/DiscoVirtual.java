import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiscoVirtual {

	Driver driver;

	private int clusterSize = 240; // 240 bytes
	private int quantClusters = 2160; // 2160 clusters

	private byte[] buffer;
	private int[] vetFAT;
	private ArrayList<DirEntry> dirAtual;
	private int clusterDoDir;
	private int qdtArquivosDir;
	// pode-se empregar ArrayList para estes vetores...

	public DiscoVirtual() {

		driver = new Driver(clusterSize, quantClusters);
		buffer = new byte[clusterSize * 20]; // buffer com espa�o para 20 clusters
		vetFAT = new int[quantClusters];
		this.dirAtual = new ArrayList<>();
		this.clusterDoDir = 20;
		this.qdtArquivosDir = 10;
	}

	Scanner s = new Scanner(System.in);

	private void inicializaFAT() {

		// seta valores iniciais na vetFAT
		vetFAT[0] = 0; // cluster de boot
		for (int i = 1; i < 19; i++) {
			vetFAT[i] = i + 1; // encadeamento dos clusters da FAT
		}
		vetFAT[19] = 0; // ultimo cluster da FAT
		vetFAT[20] = 0; // cluster do diretorio raiz

		for (int i = 21; i < 2160; i++) {
			vetFAT[i] = 9999; // clusters livres
		}
		// copia vetFAT para disco (clusters)
		atualizaFATnoDisco();
	}

	private void limpaBuffer() {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = 0;
		}
	}

	private void atualizaFATnoDisco() {
		// copia vetFAT para buffer
		int j = 0;
		for (int i = 0; i < quantClusters; i++) {
			buffer[j] = (byte) (vetFAT[i] / 256);
			buffer[j + 1] = (byte) (vetFAT[i] - buffer[j] * 256);
			j += 2;

		}
		// grava buffer no disco
		writeBufferOnDisk(1, 19); // grava 19 clusters a partir do cluster 1
	}

	private void carregaVetFatDoDisco() {
		int qtdClusterFat = 1;
		byte[] aux;
		int indiceBuffer = 0;
		while (qtdClusterFat <= 19) {
			aux = driver.readCluster(qtdClusterFat++);
			for (int i = 0; i < aux.length; i++) {
				this.buffer[indiceBuffer++] = aux[i];
			}

		}
		int j = 0;
		for (int i = 0; i < 2160; i++) {
			vetFAT[i] = buffer[j] * 256 + buffer[j + 1];
			j += 2;
		}

	}

	/*
	 * writeBufferOnDisk recebe o numero do clusterInicial e quantos clusters ser�o
	 * gravados a partir deste cluster
	 */
	public void writeBufferOnDisk(int clusterInicial, int quantosClusters) {
		byte[] cluster = new byte[clusterSize];

		// grava quantosClusters no disco
		for (int qClusters = 0; qClusters < quantosClusters; qClusters++) {
			// para cada cluster, grava clusterSize bytes...
			for (int i = 0; i < clusterSize; i++) {
				cluster[i] = buffer[qClusters * clusterSize + i]; //
			}
			driver.writeCluster(cluster, clusterInicial + qClusters);
		}

		this.limpaBuffer();
	}

	private void gravaBufferArquivoDisco(int[] clustersLivres, int qtdCluster) {
		byte[] bufferAux = new byte[this.clusterSize];
		int indiceCluster = 0;
		int i = 0;
		while (qtdCluster > 0) {
			for (int j = 0; j < bufferAux.length; j++) {
				bufferAux[j] = this.buffer[i++];
			}
			qtdCluster--;
			driver.writeCluster(bufferAux, clustersLivres[indiceCluster]);
			indiceCluster++;
		}

		this.limpaBuffer();
	}

	/*
	 * Importa arquivo externo e copia para buffer
	 */
	public int importaArquivo(String nomeArquivo) {
		int tam = 0;
		try {
			FileInputStream fis = new FileInputStream(nomeArquivo);

			byte byteLido;
			while ((byteLido = (byte) fis.read()) != -1) { // enquanto nao chegar no final do arquivo...
				buffer[tam] = byteLido;
				// if tam > tamanho do buffer (buffer cheio!), tratar esta situa��o...
				// System.out.println(buffer[tam] + "byte atual: " + tam);
				tam++;
			}
			fis.close();
		} catch (IOException e) {
			System.out.println("nao foi possivel ler do arquivo...");
		}
		return tam;
	}

	private int quantosClusterOcupaArquivo(int tamanhoArquivo) {
		int qtdCluster = 0;
		for (int i = tamanhoArquivo; i > 0; i -= 240) {
			qtdCluster++;
		}

		return qtdCluster;
	}

	private int[] procuraClusterLivreFat(int qtdcluster) {
		int[] clustersLivres = new int[qtdcluster];
		int j = 0;
		for (int i = 21; i < vetFAT.length; i++) {
			if (vetFAT[i] == 9999) {
				clustersLivres[j++] = i;
				qtdcluster--;
			}

			if (qtdcluster == 0) {
				return clustersLivres;
			}
		}

		throw new ArrayIndexOutOfBoundsException("Não tem cluster livre");
	}

	private void adicionaArquivoDirAtual(String nome, String tipo, int primeiroCluster, int tamanhoArquivo) {
		this.limpaBuffer();
		if (this.dirAtual.size() < this.qdtArquivosDir) {
			dirAtual.add(new DirEntry(nome, tipo, primeiroCluster, tamanhoArquivo));
			this.atualizaDirAtualDisco();
		} else {
			int[] clusters = this.procuraClusterLivreFat(1);
			this.clusterDoDir = clusters[0];
			this.vetFAT[this.clusterDoDir] = clusters[0];
			this.vetFAT[clusters[0]] = 0;
			this.atualizaFATnoDisco();
			dirAtual.add(new DirEntry(nome, tipo, primeiroCluster, tamanhoArquivo));
			this.atualizaDirAtualDisco();
			this.qdtArquivosDir += 10;
		}
	}

	private void atualizaDirAtualDisco() {
		int indiceBuffer = 0;
		for (DirEntry dir : dirAtual) {
			for (byte bytesArquivo : dir.getTotalBytesArquivo()) {
				this.buffer[indiceBuffer++] = bytesArquivo;
			}
		}
		int[] cluster = new int[1];
		cluster[0] = this.clusterDoDir;
		this.gravaBufferArquivoDisco(cluster, 1);
		this.limpaBuffer();
	}

	private void atualizaFatRemoverArquivo(int primeiroCluster) {
		while (this.vetFAT[primeiroCluster] != 0) {
			int aux = this.vetFAT[primeiroCluster];
			this.vetFAT[primeiroCluster] = 9999;
			primeiroCluster = aux;
		}

		this.vetFAT[primeiroCluster] = 9999;
		this.atualizaFATnoDisco();
	}

	private void atualizaFat(int[] clusters, int qtdCluster) {
		int i = 0;
		while (qtdCluster > 0) {
			if (qtdCluster > 1) {
				this.vetFAT[clusters[i]] = clusters[i + 1];
				i += 2;
				qtdCluster--;
			} else {
				i -= 1;
				if (i == -1) {
					i = 0;
				}
				this.vetFAT[clusters[i]] = 0;
				qtdCluster--;
			}
		}
		this.atualizaFATnoDisco();
	}

	private void lerDirDoDisco() throws UnsupportedEncodingException {
		ArrayList<DirEntry> dirAux = new ArrayList<>();
		byte[] bytesLido = driver.readCluster(this.clusterDoDir);
		byte[] aux = new byte[24];

		for (int j = 0; j < bytesLido.length;) {
			if (bytesLido[j] != 0) {
				for (int i = 0; i < aux.length; i++) {
					aux[i] = bytesLido[j++];
				}

				int cont = 0;
				for (int i = 0; i < 16; i++) {
					if (aux[i] != 0) {
						cont++;
					}
				}

				byte[] auxArq = new byte[cont];
				int k = 0;
				for (int i = 0; i < cont; i++) {
					auxArq[i] = aux[k];
					k++;
				}
				String nome = new String(auxArq, "UTF-8");

				auxArq = new byte[3];
				k = 16;
				for (int i = 0; i < 3; i++) {
					auxArq[i] = aux[k++];
				}
				String ext = new String(auxArq, "UTF-8");

				auxArq = new byte[1];
				auxArq[0] = aux[19];
				String tipo = new String(auxArq, "UTF-8");

				int primeiroCluster = aux[20] * 256 + aux[21];
				int tamanhoArquivo = aux[22] * 256 + aux[23];

				if (tipo.equalsIgnoreCase("A")) {
					dirAux.add(new DirEntry(nome + "." + ext, tipo, primeiroCluster, tamanhoArquivo));
				} else {
					dirAux.add(new DirEntry(nome, tipo, primeiroCluster, tamanhoArquivo));
				}

				j--;
			}
			j++;
		}
		this.dirAtual = dirAux;
		this.limpaBuffer();
	}

	public void criaArquivo() {
		System.out.println("Informe o nome do arquivo");
		String nomeArquivo = s.nextLine();
		System.out.println("Indique o arquivo de fora do disco");
		String arquivoDoDisco = s.nextLine();
		int tamanhoArquivo = this.importaArquivo(arquivoDoDisco);
		int qtdCluster = this.quantosClusterOcupaArquivo(tamanhoArquivo);
		int[] clustersLivres = this.procuraClusterLivreFat(qtdCluster);
		this.gravaBufferArquivoDisco(clustersLivres, qtdCluster);
		this.adicionaArquivoDirAtual(nomeArquivo, "A", clustersLivres[0], tamanhoArquivo);
		this.atualizaFat(clustersLivres, qtdCluster);

	}

	public void criaDiretorio() {
		System.out.println("Informe o nome do diretorio");
		String nomeDiretorio = s.nextLine();
		int[] clusterLivre = this.procuraClusterLivreFat(1);
		this.adicionaArquivoDirAtual(nomeDiretorio, "D", clusterLivre[0], 0);
		this.atualizaFat(clusterLivre, 1);
	}

	public void listaArquivosDiretorioAtual() {
		for (DirEntry arquivos : dirAtual) {
			arquivos.exibeArquivo();
		}
	}

	public void exibirArquivoEspecifico() {
		System.out.println("Informe o nome do arquivo que deseja visualizar");
		String nome = s.nextLine();
		for (DirEntry arquivos : dirAtual) {
			if (arquivos.getNome().equalsIgnoreCase(nome)) {
				arquivos.exibeArquivo();
			}
		}
	}

	public void entrarSubPasta() {
		System.out.println("Em qual diretório deseja entrar?");
		for (DirEntry arquivos : dirAtual) {
			if (arquivos.getTipo().equalsIgnoreCase("D")) {
				System.out.println(arquivos.getNome());
			}
		}
		String nome = s.nextLine();
		for (DirEntry arquivos : dirAtual) {
			if (arquivos.getNome().equalsIgnoreCase(nome)) {
				this.clusterDoDir = arquivos.getPrimeiroCluster();
				try {
					this.lerDirDoDisco();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void voltaDiretorioRaiz() {
		this.clusterDoDir = 20;
		try {
			this.lerDirDoDisco();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removerArquivo() {
		System.out.println("Qual arquivo deseja excluir?");
		this.listaArquivosDiretorioAtual();
		String nome = s.nextLine();
		int cont = 0;
		int tam = dirAtual.size();
		for (int i = 0; i < tam; i++) {
			if (dirAtual.get(i).getNome().equalsIgnoreCase(nome)) {
				int cluster = dirAtual.get(i).getPrimeiroCluster();
				this.atualizaFatRemoverArquivo(cluster);
				dirAtual.remove(cont);
				this.atualizaDirAtualDisco();
				System.out.println("Arquivo excluido com sucesso");
			}
			cont++;
		}

		if (cont == dirAtual.size()) {
			System.out.println("Arquivo Não encontrado");
		}

	}

	public void removerPasta() {
		System.out.println("Qual diretório deseja excluir?");
		for (DirEntry arquivos : dirAtual) {
			if (arquivos.getTipo().equalsIgnoreCase("D")) {
				System.out.println(arquivos.getNome());
			}
		}
		String nome = s.nextLine();
		
	}

	public void testa() {

		this.inicializaFAT();
		this.carregaVetFatDoDisco();

	}

}
