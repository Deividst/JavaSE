
public class Pessoa{
    private int matricula;
    private char tipoPessoa;
    private String nome;

    public Pessoa(int matricula, char tipoPessoa, String nome){
        this.matricula = matricula;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public void setTipoPessoa(char tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }

    public char getTipoPessoa(){
        return this.tipoPessoa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return  this.nome;
    }

    public void exibirDados(){
        String aux;
        System.out.println("Numero de matrucula:" + this.matricula);
        if (this.tipoPessoa == 'A'){
            aux = "Aluno";
            System.out.println("Tipo de Pessoa:" + aux);
        } else if (this.tipoPessoa == 'P'){
            aux = "Professor";
            System.out.println("Tipo de Pessoa:" + aux);
        }else if (this.tipoPessoa == 'F'){
            aux = "Funcionario";
            System.out.println("Tipo de Pessoa:" + aux);
        } else if (this.tipoPessoa == 'T'){
            aux = "Autor";
           System.out.println("Tipo de Pessoa:" + aux);
        }
        System.out.println("Nome: " + nome);
    }
}
