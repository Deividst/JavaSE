package Lista05;

public class Aluno {

    private String nome;
    private double nA;
    private double nB;
    private double nC;
    private double media;
    private boolean aprovado;
    private Data dataDeNascimento;

    public Aluno (String nome, double nA, double nB, double nC, Data dataDeNascimento){
        this.nome = nome;
        this.nA = nA;
        this.nB = nB;
        this.nC = nC;
        this.dataDeNascimento = dataDeNascimento;

    }

    public Aluno(String nome) {
        this.nome = nome;
    }	

    public Aluno(String nome, double nA, double nB, double nC) {
        this.nome = nome;
        this.nA = nA;
        this.nB = nB;
        this.nC = nC;
    }

    public void calculaMedia() {
        this.media = ( this.nA + this.nB + this.nC ) / 3;
        if (this.media >= 6){
            this.aprovado = true;
        } else {
            this.aprovado = false;
        }
    }

    public boolean isAprovado(){
        return this.aprovado;
    }

    public void setDataNascimento(Data dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }

    public Data getDataNascimento(){
        return this.dataDeNascimento;   
    }

    public String getNome(){
        return this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotaA(double nA) {
        if (nA >= 0 && nA <= 10){
            this.nA = nA;
        }else {
            this.nA = 0;   
        }

    }

    public double getNA(){
        return this. nA = nA;
    }

    public void setNotaB(double nB) {
        if (nB >= 0 && nB <= 10){
            this.nB = nB;}
        else {
            this.nB = 0;
        }
    }

    public double getNB(){
        return this. nB = nB;
    }

    public void setNotaC(double nC) {
        if (nC >= 0 && nC <= 10){
            this.nC = nC;}
        else {
            this.nC = 0;
        }
    }

    public double getNC(){
        return this. nC = nC;
    }

    public double getMedia() {
        return media;
    }
    
    public String defineConceito(){
        if ( this.media >= 9){
            return "Ótimo";
        }else if (this.media >= 8 && this.media < 9){
            return "Bom";
        }else if (this.media >= 6 && this.media < 8){
            return "Satisfatório";
        }else {
            return "Insuficiente";
        }
        
    }

    public void exibiDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Nota A: " + getNA());
        System.out.println("Nota B: " + getNB());
        System.out.println("Nota C: " + getNC());
        System.out.println("Media: " + getMedia());
        System.out.println("Aprovado: "+ isAprovado());
        System.out.println("Data de Nascimento: " + getDataNascimento().obterDataPadrao());
    }

}
