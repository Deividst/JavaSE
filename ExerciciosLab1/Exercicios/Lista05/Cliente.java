package Lista05;

public class Cliente{
    private String nome;
    private int pontos; //saldo de pontos
    private Data dataDeNascimento;

    
    public Cliente(String n){
        setNome(n);
    }

    public char defineCategoria(){

        if (pontos >= 500){
            return 'A';
        } else if (pontos >= 301 && pontos < 500){
            return 'B';
        }else if (pontos >= 100 && pontos < 301){
            return 'C';
        }else {
            return 'D';   
        }

        
    }
    
    
    public void setDataDeNascimento(Data dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public Data getDataDeNascimento(){
     return this.dataDeNascimento;   
    }
    
    

    public void setNome(String nome){this.nome = nome;}

    public void setPontos(int pontos){this.pontos = pontos;}

    public String getNome(){return nome;}

    public int getPontos(){return pontos;} 

}