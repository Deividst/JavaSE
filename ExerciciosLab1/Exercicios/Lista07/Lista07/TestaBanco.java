
public class TestaBanco{
    public static void main(String [] args){

        Teclado t = new Teclado();  
        Cliente c1 = new Cliente(t.leString("Informe o nome do Cliente."));

        ContaCorrente conta1 = new ContaCorrente(1,c1);
        ContaCorrente conta2 = new ContaCorrente(2,c1);

        System.out.println("Bem vindo ao terminal do Banco tal");
        int aux = t.leInt("Informe o numero da conta que deseja acessar");
        int tentativa = 1;
        boolean aux2;
        int op = 9;
        if ( aux == conta1.getNumero()){
            do{
            op = t.leInt("Escolha uma opção" +"\n" 
                    +"1 – Cadastra senha" +"\n"
                    +"2 – Depósito" + "\n"
                    +"3 – Retirada" + "\n" 
                    +"4 – Saldo da conta" + "\n"
                    +"5 – Saldo total do cliente" + "\n"
                    +"9 – Encerra");
            switch (op){

                case 1:
                c1.cadastrarSenha();
                break;

                case 2:
                conta1.deposita(t.leDouble("Informe quanto quer depositar"));
                break;

                case 3:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    conta1.retira(t.leDouble("Informe quanto quer retirar"));
                }
                tentativa = 1;
                break;

                case 4:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    System.out.println(conta1.getSaldo());
                }
                tentativa = 1;
                break;

                case 5:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    System.out.println(c1.getSaldoTotal());
                }
                tentativa = 1;
                break;

                case 9:
                System.exit(0);

                default:
                System.out.println("Esta opção é invalida");

            }
        }while(op != 9);

        } else if (aux == conta2.getNumero()){
            do{
            op = t.leInt("Escolha uma opção" +"\n" 
                    +"1 – Cadastra senha" +"\n"
                    +"2 – Depósito" + "\n"
                    +"3 – Retirada" + "\n" 
                    +"4 – Saldo da conta" + "\n"
                    +"5 – Saldo total do cliente" + "\n"
                    +"9 – Encerra");
            switch (op){

                case 1:
                c1.cadastrarSenha();
                break;

                case 2:
                conta2.deposita(t.leDouble("Informe quanto quer depositar"));
                break;

                case 3:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    conta2.retira(t.leDouble("Informe quanto quer retirar"));
                }
                tentativa = 1;
                break;

                case 4:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    System.out.println(conta2.getSaldo());
                }
                tentativa = 1;
                break;

                case 5:
                do {
                    aux2 = c1.verificarSenha(t.leInt("Informe a senha"));
                    tentativa++;
                }while(aux2 == false && tentativa <= 3);
                if (aux2 == true ){
                    System.out.println(c1.getSaldoTotal());
                }
                tentativa = 1;
                break;

                case 9:
                System.exit(0);

                default:
                System.out.println("Esta opção é invalida");

            }
        }while(op != 9);
    }
}
}