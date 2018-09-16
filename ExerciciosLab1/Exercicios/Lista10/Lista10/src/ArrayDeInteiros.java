
public class ArrayDeInteiros {

	private int[] v; // declara um atributo de tipo array int

	public ArrayDeInteiros(int tamanho) { // Construtor v = new int[tamanho]; //instancia o obj arrayv
		this.v = new int[tamanho];
	}

	public void preencherArray() {

		for (int i = 0; i < v.length; i++) {
			this.v[i] = (int) (Math.random() * 10) + 0;

		}
	}

	public void exibeArray() {
		for (int i = 0; i < v.length; i++) {
			System.out.print(this.v[i]);
			
		}
	}
	
	public void exibeInvertido(){
		for (int i = this.v.length -1 ; i >= 0 ; i--) {
			System.out.print(this.v[i]);
		}
		
	}
	
	int aux = 0;
	public void maiorValor() {
		for (int i = 0; i < v.length ; i++) {
			if (this.v[i] > aux) {
				aux = this.v[i];
			}
			
		}
		System.out.println("Maior valor: " + aux);
	}
	
	public int mediaArray() {
		for (int i = 0; i < v.length ; i++) {
			aux += this.v[i];
					
		}
		return aux / v.length;
	}
}
