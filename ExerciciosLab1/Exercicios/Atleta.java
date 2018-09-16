
public class Atleta{
    private String nome;
    private double altura;
    private Data dataNascimento;

    public Atleta(String nome, double altura, Data dataNascimento){
        this.nome = nome;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }
    
    
    public Atleta(String umNome, double umaAltura, int umDia, int umMes, int umAno){
        this.nome = umNome;
        this.altura = umaAltura;
        this.dataNascimento = new Data(umDia, umMes, umAno);
        
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome = nome;   
    }

    public void setAltura(double altura){
        this.altura = altura;   
    }

    public double getAltura(){
        return this.altura = altura;   
    }

    public void setDataNascimento(Data dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Data getDataNascimento(){
        return this.dataNascimento = dataNascimento;
    }
    
    public void exibiDados(){
     System.out.println("Dados do Atleta"); 
     System.out.println("Nome: " +getNome());
     System.out.println("Altura: "+ getAltura());
     System.out.println("Data de Nascimento: "+ getDataNascimento().obterDataPadrao());
     
    }

    
}