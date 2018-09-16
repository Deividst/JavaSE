package br.com.estruturasDados;

public class Teste {

    public static void main(String[] args) {

        Lista<String> v = new Lista<String>(10);

        v.adiciona("Ele 1");
        v.adiciona("Ele 2");
        v.adiciona("Ele 3", 0);
        System.out.println(v.toString());

        System.out.println(v.elementoExiste("Ele 3"));    }
}
