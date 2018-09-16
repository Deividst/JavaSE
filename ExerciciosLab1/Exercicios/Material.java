public class Material {

    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Material(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Material(int codigo, String nome, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarMaterialEstoque() {
        this.quantidadeEstoque++;
    }

    public void adicionarMaterialEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque += quantidadeEstoque;
    }   

    public void venderMaterialEstoque() {
        this.quantidadeEstoque--;
    }

    public void venderMaterialEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque -= quantidadeEstoque;
    }   

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco = preco;
    }

    public int getQuantidadeEstoque(){
        return this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirDados(){
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + "R$ " + getPreco());
        System.out.println("Quantidade: " + getQuantidadeEstoque());

    }

}
