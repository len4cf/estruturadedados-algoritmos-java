import estrutura_dados_vetor.Vetor;
import estrutura_dados_vetor.VetorObjetos;

public class Main {
    public static void main(String[] args) {

        VetorObjetos vetor = new VetorObjetos(3);

        vetor.adiciona(3);
        vetor.adiciona(2);
        vetor.adiciona(1);

        System.out.println("Tamanho = " + vetor.tamanho());

        System.out.println(vetor);


    }
}