public class Cliente{

    private String nome;
    private short senha; // senha de 4 dígitos
    private double saldoTotal; 

    public Cliente(String n){
        this.nome = n;
    }

    public void deposita(double valor){
        this.saldoTotal += valor;
    }

    public void retira(double valor){
        this.saldoTotal -= valor;
    }

    public String getNome(){
        return this.nome;
    }

    public double getSaldoTotal(){
        return this.saldoTotal;
    }

    public void cadastrarSenha(){
        Teclado t = new Teclado();
        short senha;
        boolean cond;
        do {
            senha =(short) t.leInt("Informe uma senha");
            cond = senha > 1000 && Integer.toString(senha).length() == 4;
        }while(cond == false);
        if (cond == true){
            this.senha = senha;
        }
        
    }
    public boolean verificarSenha(int numero){
        
        if( numero == this.senha){
            return true;
        } else {
            return false;

        }
    }

}