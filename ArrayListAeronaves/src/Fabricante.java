public class Fabricante {
	
	private int chave;
	private String nomeFabricante;
	private int codigoFabricante;
	
	public Fabricante(int chave, String nome, int codigo) {
		this.chave = chave;
		this.nomeFabricante = nome;
		this.codigoFabricante = codigo;
	}
	
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	public int getCodigoFabricante() {
		return codigoFabricante;
	}
	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}


	@Override
	public String toString() {
		return "Fabricante [chave=" + chave + ", nomeFabricante=" + nomeFabricante + ", codigoFabricante="
				+ codigoFabricante + "]";
	}
	
	
	
	
}
