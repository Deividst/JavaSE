package Lista05;


public class TestaAlunoComRepeticao2{

    public static void main(String[] args){
        Teclado t = new Teclado();
        Aluno a = null;
        
        int n = t.leInt("Informe a quantidade de alunos: ");
        int x = 1;
        int alunosAprovados = 0;
        double maiorMedia = 0;
        double media;
        while (x <= n){
            
        a = new Aluno(t.leString("Informe o nome"),
                      t.leInt("Informe a Nota A"),
                      t.leInt("Informe a nota B"),
                      t.leInt("Informe a nota C"));
        media = (a.getNA() + a.getNB() + a.getNC()) / 3; 
        System.out.println("Nome: " + a.getNome() + "  " + "Média: " + media);
        if (media > maiorMedia){
            maiorMedia = media;
        }
        
        if ( media >= 6){
            alunosAprovados++;
        }
        
        x++;
    }
    
    System.out.println("Quantidade de alunos aprovados: " + alunosAprovados);
    System.out.println("Maior média entre os alunos: " + maiorMedia);
}

}