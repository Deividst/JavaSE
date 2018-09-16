package Lista05;


public class TestaAlunoComRepeticao{

    public static void main(String[] args){
        Teclado t = new Teclado();
        Aluno a = null;
        
        int n = 1;
        while (n <= 3){
            
        a = new Aluno(t.leString("Informe o nome"),
                      t.leInt("Informe a Nota A"),
                      t.leInt("Informe a nota B"),
                      t.leInt("Informe a nota C"));
        a.calculaMedia();
        System.out.println("Nome: " + a.getNome() + "  " + "Média: " + a.getMedia());
    }
}

}