package br.com.estruturasDados;

import java.util.Arrays;

public class Lista<T> {

    private T[] elementos;
    private  int tamanho;

    public Lista(int capacidade) {
        this.elementos = (T[])new Object[capacidade];
        this.tamanho = 0;
    }




    public boolean adiciona(T elemento){
        this.aumentaCapacidade();
        if(this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }else{
            return false;
        }
    }

    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho; i++){
            s.append(elementos[i]);
            s.append(",");
        }

        s.append("]");

        return s.toString();

    }

    public Object busca(int pos){
        if(!(pos >= 0 && pos < this.tamanho)){
            throw new IllegalArgumentException("Posição invalida");
        }
        return this.elementos[pos];
    }

    public int elementoExiste(T elemento){
        for (int i = 0; i < tamanho; i ++){
            if(elemento.equals(elementos[i])){
                return i;
            }
        }
        return -1;
    }


    public boolean adiciona(T elemento, int pos) {

        if (!(pos  >= 0 && pos < tamanho)){
            throw new IllegalArgumentException("Posição invalida");
        }

        for (int i = this.tamanho-1; i >= pos; i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[pos] = elemento;
        this.tamanho++;
        return true;
    }

    public void aumentaCapacidade(){
        if(this.tamanho == elementos.length){
            T[] elementosNovos = (T[]) new Object[elementos.length * 2];
            for(int i = 0; i < this.tamanho; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void removerElemento(int pos){
        if (!(pos  >= 0 && pos < tamanho)){
            throw new IllegalArgumentException("Posição invalida");
        }

        for(int i = pos; i < this.tamanho-1; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }
}
