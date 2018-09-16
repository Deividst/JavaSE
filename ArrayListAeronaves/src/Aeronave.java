public class Aeronave {
	
	private int chave;
	private String nomeAeronave;
	private String modeloAeronave;
	private String matriculaAeronave;
	private int codigoFabricante;
	
	public Aeronave(int chave, String nome, String modelo, String matricula, int codigoFabricante) {
		this.chave = chave;
		this.nomeAeronave = nome;
		this.modeloAeronave = modelo;
		this.matriculaAeronave = matricula;
		this.codigoFabricante = codigoFabricante;
	}
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public String getNomeAeronave() {
		return nomeAeronave;
	}
	public void setNomeAeronave(String nomeAeronave) {
		this.nomeAeronave = nomeAeronave;
	}
	public String getModeloAeronave() {
		return modeloAeronave;
	}
	public void setModeloAeronave(String modeloAeronave) {
		this.modeloAeronave = modeloAeronave;
	}
	public String getMatriculaAeronave() {
		return matriculaAeronave;
	}
	public void setMatriculaAeronave(String matriculaAeronave) {
		this.matriculaAeronave = matriculaAeronave;
	}
	public int getCodigoFabricante() {
		return codigoFabricante;
	}
	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

	@Override
	public String toString() {
		return "Aeronave [chave=" + chave + ", nomeAeronave=" + nomeAeronave + ", modeloAeronave=" + modeloAeronave
				+ ", matriculaAeronave=" + matriculaAeronave + ", codigoFabricante=" + codigoFabricante + "]";
	}
	
	
		
}
