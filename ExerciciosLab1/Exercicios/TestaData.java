
public class TestaData{
 public static void main(String [] args){
     
     Data dtAluno = new Data (12,10,1994);
     Data dtHoje = new Data (07,9,2017);
     Aluno a = new Aluno("Deivid",10,8,7,dtAluno);
     
    
     
     System.out.println("Idade: " +  (dtHoje.obtemDataInvertida()- dtAluno.obtemDataInvertida())/10000);
     
     
     
     
     
     
     
    }
    
}