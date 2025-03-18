package estrutura_dados_vetor;

import java.util.Arrays;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }


    public boolean adiciona(String elemento) {

        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;

    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // tamanho = 6, posicao = 1
    // 0 1 2 3 4 5
    // B A C E F G

    public boolean adiciona(int posicao, String elemento) {
        if (!(posicao >= 0 && posicao < this.elementos.length)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        this.aumentaCapacidade();
        
        // mover todos os elementos
        for (int i = this.tamanho-1; i>= posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;

        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");
        return s.toString();
    }

    public void mostrarTamanho() {
        System.out.println("Tamanho: " + this.tamanho);
    }

}


