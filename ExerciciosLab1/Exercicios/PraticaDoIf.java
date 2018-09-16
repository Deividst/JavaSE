
public class PraticaDoIf{

    Teclado t = new Teclado();
    public int maiorNumero(int x, int y){
        if (x > y){
            return x;
        } else if(y > x){
            return y;
        }else { 
            return x;}
    }

    public void numeroRandomico(){
        int  x = (int)(Math.random() * 10+0);

        System.out.println(x);

        if( x % 2 == 0){
            System.out.println("Numero é par");
        }else {
            System.out.println("Numero é impar");}

    }

    public double menorNumero(double a, double b, double c){
        if (a < b && a < c){
            return a;
        }else if (b < a && b < c){
            return b;
        }else {
            return c;
        }

    }

    public int nomePessoa(){

        String nome = t.leString("Informe um nome:");

        int quantidade = nome.length();

        return quantidade;

    }

    public String maiorMedia(Aluno a1, Aluno a2){

        if ( a1.getMedia() > a2.getMedia()){
            return a1.getNome();
        } else if(a2.getMedia() > a1.getMedia()){
            return a2.getNome();
        } else {
            String msg = "Médias Iguais";
            return msg;
        }
    }

    public double menorMedia(Aluno a1){
        Aluno a2 = new Aluno(t.leString("Informe o nome:"),
                (double)t.leInt("informe a nota A"),
                (double)t.leInt("informe a nota B"),
                (double)t.leInt("Informe a nota C"));

        double menorNotaDoAlunoA = menorNumero(a1.getNA(),a1.getNB(),a1.getNC());
        double menorNotaDoAlunoB = menorNumero(a2.getNA(),a2.getNB(), a2.getNC()); 

        if (menorNotaDoAlunoA < menorNotaDoAlunoB){
            return menorNotaDoAlunoA;
        }else {
            return menorNotaDoAlunoB;
        }

        /**double menor1;
        double menor2;
        if (a1.getNA() < a1.getNB()){
        menor1 = a1.getNA();
        }else if (a1.getNA() < a1.getNC()){
        menor1 = a1.getNA();
        }else if (a1.getNB() < a1.getNC()){
        menor1 = a1.getNB();
        }else {
        menor1 = a1.getNC();
        }
        if (a2.getNA() < a2.getNB()){
        menor2 = a1.getNA();
        }else if (a2.getNA() < a2.getNC()){
        menor2 = a1.getNA();
        }else if (a2.getNB() < a2.getNC()){
        menor2 = a2.getNB();
        }else {
        menor2 = a2.getNC();
        }
        if ( menor1 < menor2){
        return menor1;
        }else {
        return menor2;
        }**/

    }

    public int retornaInteiro(byte numero1){
        int numero2 = (int)(Math.random() * 900 + 100);

        if (numero1 >= 0 && numero1 < 10){
            return (numero2 * 10) + numero1;
        }else if (numero1 >= 10 && numero1 < 100){
            return (numero2 * 100) + numero1;
        } else {
            return (numero2 * 1000) + numero1;
        }

    }

    public boolean contemNome(String nome, char letra){
        if (nome.indexOf(letra) != -1){
            return true;
        }else {
            return false;
        }

    }

    public String verificaNotas(float notaA, float notaB){

        float media = (notaA + notaB ) / 2;

        if (media >=6 ) {
            return "Aprovado";
        }else{
            float notaC = (float)t.leDouble("Informe a nota C:");
            if (notaA < notaB){
                notaA = notaC;
            }else {
                notaB = notaC;
            }
            media = (notaA + notaB) /2;
            if (media >=6){

                return "Aprovado com recuperação";
            } else {
                return "Reprovado";
            }

        }
    }
}

    // (a) método que recebe via parâmetros 2 números inteiros
    // retorna o valor do maior deles. Se forem iguais, retornar
    // qualquer um.
    // (b) método que sorteia um número inteiro randômico tirado do
    // intervalo [1,10] e imprime-o. A seguir, retorna uma mensagem
    // dizendo se ele é par ou ímpar.
    // (c) método recebe 3 números quaisquer e retorna o valor do
    // menor deles.
    // (d) método que lê do teclado um nome de pessoa e retorna a
    // quantidade de caracteres que o nome possui. (Consulte a classe
    // String na minibiblioteca de classes (MinibibliotecaJava.pdf))
    // (e) método que recebe via parâmetros dois objetos Aluno
    // e retorna o nome do aluno com maior média ou a mensagem “Médias
    // iguais”.
