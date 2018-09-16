
/**
 * Escreva a descrição da classe TestaAluno3 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TestaAluno3{
    public static void main (String [] args){

        Teclado t = new Teclado();
        Aluno a1 = new Aluno(t.leString("Informe o nome:"),
                (double)t.leInt("informe a nota A"),
                (double)t.leInt("informe a nota B"),
                (double)t.leInt("Informe a nota C"));

        Aluno a2 = new Aluno(t.leString("Informe o nome:"),
                (double)t.leInt("informe a nota A"),
                (double)t.leInt("informe a nota B"),
                (double)t.leInt("Informe a nota C")); 

        a1.calculaMedia();
        a2.calculaMedia();
        if ( a1.getMedia() < a2.getMedia()){
            System.out.println("Nome do aluno: " + a1.getNome() + "Com conceito " + a1.defineConceito());
        } else if ( a1.getMedia() == a2.getMedia()){
            System.out.println("Nome do aluno: " + a2.getNome() + "Com conceito " + a2.defineConceito());
        } else {
            System.out.println("Os alunos tem médias iguais");
        }
    }
}