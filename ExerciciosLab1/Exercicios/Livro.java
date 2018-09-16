public class Livro {

    private int codigo;
    private String titulo;
    private char situacao;
    private Pessoa autor;

    public Livro(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.situacao = 'D';
    }

    public Livro(int codigo, String titulo, Pessoa autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.situacao = 'D';
        this.autor = autor;
    }

    public void retira() {
        this.situacao = 'E';
    }

    public void devolve() {
        this.situacao = 'D';
    }

    public int getCodigo(){
        return this.codigo = codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo = titulo;
    }

    public char getSituacao(){
        return this.situacao = situacao;   
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }
    
    public Pessoa getAutor(){
    return this.autor = autor;
    }
    
    public void exibirDados(){
        System.out.println("Codigo: "+ getCodigo());
        System.out.println("Titulo: "+ getTitulo());
        System.out.println("Situação: "+ getSituacao());
        System.out.println("Autor: "+ getAutor());
        
    }

}
