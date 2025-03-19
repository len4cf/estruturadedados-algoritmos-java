package estrutura_dados_vetor;

public class VetorObjetos {


    private Object[] elementos;
    private int tamanho;

    public VetorObjetos(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }


    public boolean adiciona(Object elemento) {

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
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // tamanho = 6, posicao = 1
    // 0 1 2 3 4 5
    // B A C E F G

    public boolean adiciona(int posicao, Object elemento) {
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

    // B C E F G -> posicao a ser removida é 2 (E)
    // B C F F G
    // B C F G G
    // 0 1 2 3 4 -> tamanho é 5
    // vetor[2] = vetor[3]
    // vetor[3] = vetor[4]

    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < this.elementos.length)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i=posicao; i<this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }


    public int tamanho() {
        return this.tamanho;
    }

    public Object busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        return this.elementos[posicao];
    }

    public int busca(Object elemento) {
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
