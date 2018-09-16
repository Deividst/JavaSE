/** Alunos: Deivid dos Santos Thomé Trabalho GA Lab 1 */
public class TestaCompras {

    public static void main(String [] args) {

        Data aniversario = new Data(12,10,1994);
        Cliente c = new Cliente("Deivid", aniversario);

        Data compra1 = new Data(8,10,2017);
        Compra avista = new Compra(c,compra1,1000.00);
        avista.finalizarCompra();
        avista.exibirDados();

        Compra entrada = new Compra(c, 20, 11, 2017, 2000.00);
        entrada.finalizarCompra();
        entrada.exibirDados();

        Data compra3 = new Data(21,11,2017);
        Compra avista2 = new Compra(c, compra3, 3000.00);
        avista2.finalizarCompra();
        avista2.exibirDados();

        Compra avista3 = new Compra(c, 25, 11, 2017, 4000.00);
        avista3.finalizarCompra();
        avista3.exibirDados();

        Compra parcelada = new Compra(c, 30, 12, 2017, 3500.00);
        parcelada.finalizarCompra();
        parcelada.exibirDados();

    }
}

	        
	
