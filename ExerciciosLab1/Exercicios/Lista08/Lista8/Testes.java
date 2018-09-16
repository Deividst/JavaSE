
public class Testes{
    public static void main (String [] args){
        Teclado t = new Teclado();
        Pessoa p = new Pessoa("Deivid", 23, 'M');
        Empregado e = new Empregado ("Maria", 22, 'F', 1500 );
        
        p.exibeDados();
        e.exibeDados();
        
        p.fazAniversario();
        
        double aux = e.calculaSalarioLiquidoMes(t.leInt("Informe o numero de faltas"));
        System.out.println("Valor liquido a Receber: " + aux);
        
        
    }
}