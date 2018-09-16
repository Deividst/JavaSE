
public class TestaAluno2{
 
 public static void main (String [] args){
    
     Teclado t = new Teclado();
     
     Aluno a1 = new Aluno (t.leString("Informe o nome do aluno: " ),
     t.leDouble("Informe a primeira nota: "),
     t.leDouble("Informe a segunda nota: "),
     t.leDouble("Informe a terceira nota: "));
     
     a1.calculaMedia();
     a1.isAprovado();
     
     
     a1.exibiDados();
     
     
     
     
     
     
     
     
     
    }
    
    
    
}