package Lista05;

public class Compra{
    private int numero;
    private Cliente cliente;
    private double valorFinal;
    private double valorInicial;

    public void setNumero(int numero){
        this.numero = numero;   
    }

    public int getNumero(){
        return this.numero;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;   
    }

    public void setValorInicial(double valorInicial){
        this.valorInicial = valorInicial;
    }

    public double getValorInicial(){
        return this.valorInicial;
    }

    public void setValorFinal(double valorFinal){
        this.valorFinal = valorFinal;
    }

    public double getValorFinal(){
        return this.valorFinal;
    }

    public Compra(int numero, double valorInicial, Cliente cliente){
        this.numero = numero;
        this.valorInicial = valorInicial;
        this.cliente = cliente;

    }

    public Compra(int numero, double valorInicial, String nome){
        this.numero = numero;
        this.valorInicial = valorInicial;
        this.cliente = new Cliente(nome);

    }

    public void calculaDesconto(){
        if (this.valorInicial < 50){
            this.valorFinal = this. valorInicial;

        } else if(this.valorInicial >= 50){
            char categoria = cliente.defineCategoria();

            if(categoria == 'A'){
                this.valorFinal = this.valorInicial - ((this.valorInicial * 5)/ 100);
            }else if (categoria == 'B'){
                this.valorFinal = this.valorInicial - ((this.valorInicial * 3.5)/ 100);
            } else {
                this.valorFinal = this.valorInicial - ((this.valorInicial * 1)/ 100);
            }

            if (this.valorInicial > 1000){
                this.valorFinal *= 0.98; 

            }
        }

        pontuaCliente();

    }

    private void pontuaCliente(){
        int pontosAtuais = this.cliente.getPontos();
        int pontosNovos = (int)(this.valorFinal/2);
        this.cliente.setPontos(pontosAtuais + pontosNovos);

    }

    public void emiteNota(){
        System.out.println("----Compra----");
        System.out.println("Numero: " + this.numero);
        System.out.println("Valor Inicial: " + this.valorInicial);
        System.out.println("Valor Final: " + this.valorFinal);
        System.out.println("Nome Cliente: " + this.cliente.getNome());
        System.out.println("Pontos do Cliente: " + this.cliente.getPontos());
        System.out.println("Categoria Cliente: " + this.cliente.defineCategoria());

    }

    public void emiteNota(Data dataVenda){
        emiteNota();
        
        if (dataVenda.obterDataPadrao() != null){
            System.out.println("Data de Venda: "+ dataVenda.obterDataPadrao());
        }else {
            System.out.println("Não tem data de nascimento informada");
        }
        
        if (this.cliente.getDataDeNascimento() != null){
            System.out.println("Data de Nascimento: "+ this.cliente.getDataDeNascimento().obterDataPadrao());
        }else {
            System.out.println("Não tem data de nascimento informada");
        }
       

    }

}
 