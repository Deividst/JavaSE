public class DirEntry {

	private String nome;
	private String ext;
	private String tipo;
	private int primeiroCluster;
	private int tamanhoArquivo;
	private byte[] totalBytesArquivo = new byte[24];

	public DirEntry(String nome, String tipo, int primeiroCluster, int tamanhoArquivo) {
		if(tipo.equalsIgnoreCase("A")) {
			nome = nome.replace('.', '/');
			String arquivo[];
			arquivo = nome.split("/");
	
			if (arquivo[0].length() <= 16) {
				this.nome = arquivo[0];
			} else {
				throw new IllegalArgumentException("Nome do arquivo excede o tamanho permitido");
			}
			
			if (arquivo[1].length() <= 3) {
				this.ext = arquivo[1];
			}
			
		}else {
			this.nome = nome;
			this.ext = "";
		}
		
		this.tipo = tipo;
		this.primeiroCluster = primeiroCluster;
		this.tamanhoArquivo = tamanhoArquivo;

		this.carregaBytes();
	}

	public byte[] getTotalBytesArquivo() {
		return totalBytesArquivo;
	}


	private void carregaBytes() {
		int j = 0;
		byte[] aux = this.nome.getBytes();
		for (int i = 0; i < aux.length; i++) {
			this.totalBytesArquivo[j++] = aux[i];
		}

		if (this.ext != null) {
			aux = this.ext.getBytes();
		}

		j = 16;
		for (int i = 0; i < aux.length; i++) {
			this.totalBytesArquivo[j++] = aux[i];
		}
		aux = this.tipo.getBytes();
		this.totalBytesArquivo[19] = aux[0];
		this.totalBytesArquivo[20] = (byte) (this.primeiroCluster / 256);
		this.totalBytesArquivo[21] = (byte) (this.primeiroCluster - this.totalBytesArquivo[20] * 256);

		this.totalBytesArquivo[22] = (byte) (this.tamanhoArquivo / 256);
		this.totalBytesArquivo[23] = (byte) (this.tamanhoArquivo - this.totalBytesArquivo[22] * 256);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrimeiroCluster() {
		return primeiroCluster;
	}

	public void setPrimeiroCluster(int primeiroCluster) {
		this.primeiroCluster = primeiroCluster;
	}

	public int getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(int tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public void exibeArquivo() {
		System.out.println("Nome: " + this.nome + "." + this.ext + "\n" + "Tipo: " + this.tipo + "\n" + "Tamanho: "
				+ this.tamanhoArquivo + "\n" + "Primeiro Cluster: " + this.primeiroCluster);
		System.out.println();
	}

}
