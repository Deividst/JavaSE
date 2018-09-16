
public class Locacao{
    private int numero;
    private Livro livro;
    private Pessoa usuario;
    private Pessoa funcionario;
    private Data dataLocacao;

    public Locacao(int numero, Livro livro, Pessoa usuario, Pessoa funcionario, Data dataLocacao){
        this.numero = numero;
        this.livro = livro;
        this.usuario = usuario;
        this.funcionario = funcionario;
        this.dataLocacao = dataLocacao;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public Livro getLivro(){
        return this.livro;
    }

    public void setUsuario(Pessoa usuario){
        this.usuario = usuario;
    }

    public Pessoa getUsuario(){
        return this.usuario;
    }

    public void setFuncionario(Pessoa funcionario){
        this.funcionario = funcionario;
    }

    public Pessoa getFuncionario(){
        return this.funcionario;
    }

    public void setDataLocacao(Data dataLocacao){
        this.dataLocacao = dataLocacao;
    }

    public Data getDataLocacao(){
        return this.dataLocacao;
    }

    public void exibirDados(){
        System.out.println("Numero: " + this.numero);
        System.out.println("livro:"); 
        this.livro.exibirDados();
        System.out.println("Usuario:"); 
        this.usuario.exibirDados();
        System.out.println("Funcionario:");
        this.funcionario.exibirDados();
        System.out.println("Data Locação: "+ this.dataLocacao.obtemDataPadrao());
    }
}