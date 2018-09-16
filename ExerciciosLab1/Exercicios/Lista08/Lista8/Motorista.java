

public class Motorista extends Empregado{
    private double valorDiaria;
    
    public Motorista (String nome, int idade, char sexo, double salarioBase){
        super(nome, idade, sexo, salarioBase);
        double salarioDia = getSalarioBase() / 30;
        this.valorDiaria = salarioDia * 2.5;
        
    }
    
    
    public double getValorDiaria(){
        return this.valorDiaria;
    }
    
    public double calculaSalarioLiquidoMes(int faltas){
        Teclado t = new Teclado();
        int diasViajando = t.leInt("Informe quantos dias passou viajando")
        double aux = super.calculaSalarioLiquidoMes(faltas);
        
        return aux += diasViajando * this.valorDiaria;  
        
    }
    
    public void exibeDados(){
        super.exibeDados();
        System.out.println("Valor da diaria: " + this.valorDiaria);
        
        
    }
}
