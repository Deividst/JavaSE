
public class TestaAluno{
 public static void main (String[] args){
     
     Aluno a1 = new Aluno("João", 10, 5, 8);
     
     Aluno a2 = new Aluno("Maria", 6, 6, 9);
     
     
     a1.calculaMedia();
     a2.calculaMedia();
     
     a1.exibiDados();
     a2.exibiDados();
     
     System.out.println("Relatório de notas");
     System.out.println("------------------------------------------------------------");
     System.out.println("Nome do Aluno               Notas                   Média");
     System.out.println("------------------------------------------------------------");
     System.out.println(a1.getNome()+"                  "+a1.getNA()+" "+a1.getNB()+" "+a1.getNC() + "        " + a1.getMedia());
     System.out.println(a2.getNome()+"                  "+a2.getNA()+" "+a2.getNB()+" "+a2.getNC() + "        " + a2.getMedia());
     System.out.println();
     System.out.println("Média dos dois Alunos: " +a1.getMedia() + "  "+ a2.getMedia());
     
    }
}