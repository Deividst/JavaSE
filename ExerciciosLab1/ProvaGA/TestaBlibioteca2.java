
public class TestaBlibioteca2{
    public static void main (String [] args){

        char opcao = 's';
        Teclado t = new Teclado();
        while (opcao == 's'){
            Pessoa p = new Pessoa(t.leInt("Informe a matricula:"),
                    t.leChar("Informe o tipo de Pessoa:"),
                    t.leString("Informe o nome:"));
            p.exibirDados();

            System.out.println("Usuario deseja continuar");
            opcao = t.leChar("s = sim, n = não");

        }
    }

}
