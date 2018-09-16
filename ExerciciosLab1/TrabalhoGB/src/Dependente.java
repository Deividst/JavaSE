/** Alunos : Deivid dos Santos Thomé Trabalho GB Lab 1 */

public class Dependente {

	private String nome;
	private char parentesco; //C = conjuge, F = filho, P = progenitor , O = outro;
	
	public Dependente(String nome, char parentesco) {
		this.nome = nome;
		this.parentesco = parentesco;
		setParentesco(parentesco);
		
	}

	private void setParentesco(char parentesco) {
		
		if (parentesco == 'c' || parentesco == 'C') {
			this.parentesco = parentesco;
		} else if (parentesco == 'f' || parentesco == 'F') {
			this.parentesco = parentesco;
		}else if (parentesco == 'p'|| parentesco == 'P') {
			this.parentesco = parentesco;
		} else {
			this.parentesco = 'O';
		}
	}
	
	public String traduzParentesco() {
		if (parentesco == 'C' || parentesco == 'c') {
			return "Cônjuge";
		} else if (parentesco == 'F' || parentesco == 'f') {
			return "Filho";
		}else if (parentesco == 'P' || parentesco == 'p') {
			return "Progenitor";
		} else {
			return "Outro";
		}
	}

	@Override
	public String toString() {
		return "Dependente [nome=" + nome + ", traduzParentesco()=" + traduzParentesco() + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
