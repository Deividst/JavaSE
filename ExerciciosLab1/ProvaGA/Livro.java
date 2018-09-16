
public class Livro{
    private int codigo;
    private String titulo;
    private Data dataCompra;
    private int quantidadeEstoque;
    private Pessoa autorPrincipal;

    public Livro (int codigo, String titulo, Data dataCompra, int quantidadeEstoque, Pessoa autorPrincipal){
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataCompra = dataCompra;
        this.quantidadeEstoque = quantidadeEstoque;
        this.autorPrincipal = autorPrincipal;

    }

    public void setCodigo(int codigo){
        this.codigo = codigo;   
    }

    public int getCodigo(){
        return this.codigo;   
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;   
    }

    public String getTitulo(){
        return this.titulo;   
    }

    public void setDataCompra(Data dataCompra){
        this.dataCompra = dataCompra;
    }

    public Data getDataCompra(){
        return this.dataCompra;   
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }

    public void setAutorPrincipal(Pessoa autorPrincipal){
        this.autorPrincipal = autorPrincipal;
    }

    public Pessoa getAutorPrincipal(){
        return this.autorPrincipal;
    }

    public void exibirDados(){
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Data da Compra: " +this.dataCompra.obtemDataPadrao());
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
        System.out.println("Nome Autor: " + this.autorPrincipal.getNome());
        System.out.println("Matricula Autor: " + this.autorPrincipal.getMatricula());
        System.out.println("Tipo de Pessoa: " + this.autorPrincipal.getTipoPessoa());

    }
}