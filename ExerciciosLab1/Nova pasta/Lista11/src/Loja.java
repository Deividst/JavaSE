
public class Loja {

	private Pessoa[] p;

	public Loja(int tamanho) {

		p = new Pessoa[tamanho]; // instancia o array
		// preenche o array com pessoas e clientes
		int r = 0;
		int cont = 0;

		for (int i = 0; i < p.length; i++) {
			int ano = 1940 + (int) (Math.random() * 73);
			r = 1 + (int) (Math.random() * 2);
			if (r == 1)
				p[i] = new Pessoa("P" + cont++, ano);
			else
				p[i] = new Cliente("C" + cont++, ano, (int) (Math.random() * 1000));
		}
	}
	
	public Pessoa[] getP(){
		return p ;
		}
	
	public void exibeArray() {
		System.out.println("--- Array de pessoas ---");
		for (int i = 0; i < p.length; i++) {
			Pessoa pes = p[i];
			System.out.println("Nome= " + pes.getNome() + " Ano nasc=" + pes.getAnoNascimento() );
			
			if (pes instanceof Cliente) {
				Cliente cli = (Cliente) pes;
				System.out.println(" Pontos=" + cli.getPontos());
			}
			System.out.print("\n");
		}
	}
	
	public Pessoa[] ordenaPorAno() {
		
		Pessoa[] copia = new Pessoa[p.length];
		for (int i = 0; i < p.length; i++) {
			copia[i] = p[i];
		}
			for (int i = 0; i < copia.length; i++) {
				for (int j = 0; j < copia.length - 1; j++) {
					if (copia[j].getAnoNascimento() > copia[j + 1].getAnoNascimento()) {
						Pessoa aux = copia[j];
						copia[j] = copia[j + 1];
						copia[j + 1] = aux;
					}
				}
			}
			return copia;
		}
	
	public int mediaPontos() {
		int soma = 0;
		int cont = 0;
		
		for (int i = 0; i < p.length; i++) {
			if (p[i] instanceof Cliente) {
				soma +=((Cliente) p[i]).getPontos();
				cont++;
			}
		}
		
		return cont > 0 ? soma / cont : 0; // Ternario
	}
	
	public String pessoaMaisVelha() {
		int aux = 0;
		int idade;
		String nome = null;
		for (int i = 0; i < p.length; i++) {
			idade = 2017 -  p[i].getAnoNascimento();
			if (idade  > aux) {
				aux = idade;
				nome = p[i].getNome();
			}
		}
		
		return nome;
	}
	
	}


