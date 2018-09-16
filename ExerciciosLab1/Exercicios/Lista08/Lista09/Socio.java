
public class Socio{
    private String nome; 
    private int idade;
    
    public Socio(String umNome, int umaIdade){ 
        nome = umNome; 
        idade = umaIdade;
    }

    public void aniversario(){
        idade++;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    @Override
    public String toString(){
        return "Nome: " + this.nome + "Idade: " + this.idade;
    }
}
