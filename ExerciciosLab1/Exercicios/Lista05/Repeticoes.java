package Lista05;

public class Repeticoes{
    public void listaInteirosDe1aN(int numero){   
        for (int i = 1; i <= numero; i++){
            System.out.println("Numero: "+ i);
        }

    } 

    public void listaParesPositivosMenoresQue(int numero){
        if (numero > 0){

            for(int i = 0; i < numero; i++){
                if (i % 2 == 0){
                    System.out.println("Numero par positivo: " + i);
                }

            }
        }
    }

    public void calculaMediaIdades(int numero){
        Teclado t = new Teclado();
        int idade = 0;
        if ( numero > 0){

            for (int i = 1; i <= numero; i++){
                idade += t.leInt("Informe a idade de " + i);
            }
            double media = idade / numero;
            System.out.println("Media das idades: "+ media);
        }
    }

    public double achaMaior(int n){
        double numeroAleatorio = 0;
        if (n > 0){
            for (int i = 1; i <= n; i++){
                    double aux = (int)Math.random() * 1+ 30;
                if (aux > numeroAleatorio){
                    numeroAleatorio = aux;
                }
            }
        }
        return numeroAleatorio;

}
}
