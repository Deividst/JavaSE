
public class Empregado extends Pessoa{
    private double salarioBase;

    public Empregado(String nome, int idade, char sexo, double salarioBase){
        super(nome,idade,sexo);
        this.salarioBase = salarioBase;

    }

    public void setSalarioBase(double salarioBase){
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double calculaSalarioLiquidoMes(int faltas){
        double salarioDia = this.salarioBase / 30;
        if (faltas == 1){
            return this.salarioBase;
        } else if (faltas > 1 && faltas <= 3){
            double aux =  (salarioDia / 2) * faltas; 
            return this.salarioBase - aux;
        } else {
            double aux = salarioDia * faltas;
            return this.salarioBase - aux;
        }
    }

    public void exibeDados(){
        super.exibeDados();
        System.out.println("Salario Base: " + this.salarioBase);
    }
}
