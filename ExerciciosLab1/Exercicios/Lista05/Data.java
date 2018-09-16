package Lista05;


public class Data{
 
    private int dia;
    private int mes;
    private int ano;
    
    public Data(int dia, int mes, int ano){
     this.dia = dia;
     this.mes = mes;
     this.ano = ano;
    }
    
    public String obterDataPadrao(){
     String aux = this.dia+"/"+this.mes+"/"+this.ano; 
     return aux;
    }
    
    public int obtemDataInvertida(){
        int ano = this.ano * 10000;
        int mes = this.mes * 100;
        int dia = this.dia;
        int aux = ano+mes+dia;
        
        return aux;
        
    }
    
    Teclado t = new Teclado();
    public void leDataInvertida(){
        int ano = t.leInt("Informe uma data invertida:");
        this.ano = ano / 10000;
        double aux1 = ano % 10000;
        this.mes = (int)aux1 / 100;
        double aux2 = aux1 % 100;
        this.dia = (int) aux2;
        
    }
    
    public int getDia(){
     return this.dia = dia;
    }
    
    public int getMes(){
        return this.mes = mes;
    }
    
    public int getAno(){
        return this.ano = ano;
    }
    
    
    
}