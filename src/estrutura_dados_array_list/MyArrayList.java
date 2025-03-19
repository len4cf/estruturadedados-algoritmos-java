package estrutura_dados_array_list;

public class MyArrayList {

    private Object[] data;
    private int capacity = 10;
    private int tamanho;

    public MyArrayList() {
        data = new Object[capacity];
        this.tamanho = 0;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        this.tamanho = 0;
    }

    public boolean add(Object elemento) {

        if (this.tamanho < this.data.length) {
            this.data[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }

        return false;

    }

    public boolean add(int posicao, Object elemento) {
        if (!(posicao >= 0 && posicao < this.data.length)) {
            throw new IllegalArgumentException("Posição Inválida");
        }

        for (int i = this.tamanho-1; i>= posicao; i--) {
            this.data[i+1] = this.data[i];
        }

        this.data[posicao] = elemento;
        this.tamanho++;

        return false;

    }

    // B C E F G -> posicao a ser removida é 2 (E)
    // B C F F G
    // B C F G
    // 0 1 2 3 4 -> tamanho é 5
    // vetor[2] = vetor[3]
    // vetor[3] = vetor[4]

    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < this.data.length)) {
            throw new IllegalArgumentException("Posição Inválida");
        }

        for (int i=posicao; i < this.tamanho - 1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.tamanho--;

    }

    public void remove(Object elemento) {
//        int indexRemove = 0;
//        for (int i = 0; i<this.tamanho; i++) {
//            if (this.data[i].equals(elemento)) {
//                indexRemove = i;
//            }
//        }

        int indexRemove = indexOf(elemento);


//        for (int i=indexRemove; i < this.tamanho - 1; i++) {
//            this.data[i] = this.data[i+1];
//        }
//        this.tamanho--;

        remove(indexRemove);


    }

    // B C D E -> posicao = 1 sera mudada para "A"
    // 0 1 2 3

    public void set(int posicao, Object elemento) {
        this.data[posicao] = elemento;
    }

    public Object get(int posicao) {
        return this.data[posicao];
    }

    public boolean contains(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.data[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }


    public int indexOf(Object elemento) {
        for (int i = 0; i<this.tamanho; i++) {
            if (this.data[i].equals(elemento)) {
                return i;
            }
        }
        return 0;
    }

    public String toArray() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.data[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.data[this.tamanho-1]);
        }

        s.append("]");
        return s.toString();
    }



}
