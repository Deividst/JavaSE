
public class Pessoa{
    private String nome; 
    private int idade; 
    private char sexo;

    public Pessoa(String nome, int idade, char sexo){
        this.nome = nome; 
        this.idade = idade;
        this.sexo = sexo;
    }
    // Complete o método abaixo
    public void fazAniversario(){
        this.idade += 1;

    }

    public void exibeDados(){
        String s = "Nome : "+ getNome()+"\nIdade: "+getIdade()+"\nSexo: "
            + sexo + "\n";
        System.out.print(s);
    }
    // Programe os métodos get�

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public char getChar(){
        return this.sexo;   
    }
}

