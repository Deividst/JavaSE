public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void fazAniversario() {
        this.idade++;

    }

    public String getNome(){
        return this.nome = nome;
    }

    public int getIdade(){
        return this.idade = idade;   
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibiDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());

    }

}
