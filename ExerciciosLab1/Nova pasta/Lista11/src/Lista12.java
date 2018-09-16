
public class Lista12 {

	// (a) Ordena o array b em ordem crescente
	public void ordenaCrescente(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length - 1; j++) {
				if (b[j] > b[j + 1]) {
					byte aux = b[j];
					b[j] = b[j + 1];
					b[j + 1] = aux;
				}
			}
		}
	}

	// (b) Ordena a segunda metade do array s em ordem alfabética
	public void ordenaAlfabeticamente(String[] s) {

		for (int i = 0; i < s.length / 2; i++) {
			for (int j = 0; j < s.length - 1; j++) {
				if (s[j].compareTo(s[j + 1]) > 0) {
					String aux = s[j];
					s[j] = s[j + 1];
					s[j + 1] = aux;
				}
			}
		}

		// (c) Ordena decrescentemente só os elementos de índices
		// ímpares do array v.
	}

	public void ordenaDecrescente(double[] v) {
		for (int i = 1; i < v.length; i += 2) {
			for (int j = 1; j < v.length - 2; j += 2) {
				if (v[j] < v[j + 2]) {
					double aux = v[j];
					v[j] = v[j + 2];
					v[j + 2] = aux;
				}
			}
		}

	}
}
