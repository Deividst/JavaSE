
public class Lista12Teste {

	public static void main(String[] args) {

		byte[] arreiBytes = { 11, 2, 9, 14, 3 };
		String[] arreiString = { "Renato", "Cristiano", "Luan", "Alex" };
		double[] arreiDouble = { 54, -2, -1, 3.6, 99.9, 7.5, 14.5 };
		Lista12 lista = new Lista12();

		lista.ordenaCrescente(arreiBytes);
		lista.ordenaAlfabeticamente(arreiString);
		lista.ordenaDecrescente(arreiDouble);

		imprimirArreiBytes(arreiBytes);
		imprimirArreiString(arreiString);
		imprimirArreiDouble(arreiDouble);
	}

	private static void imprimirArreiDouble(double[] arreiDouble) {
		System.out.print("[");
		for (int i = 0; i < arreiDouble.length; i++) {
			System.out.print(arreiDouble[i] + " ");
		}
		System.out.print("]");

	}

	private static void imprimirArreiString(String[] arreiString) {
		System.out.print("[");
		for (int i = 0; i < arreiString.length; i++) {
			System.out.print(arreiString[i] + " ");
		}
		System.out.print("]");

	}

	private static void imprimirArreiBytes(byte[] arreiBytes) {
		System.out.print("[");
		for (int i = 0; i < arreiBytes.length; i++) {
			System.out.print(arreiBytes[i] + " ");
		}
		System.out.print("]");

	}

}
