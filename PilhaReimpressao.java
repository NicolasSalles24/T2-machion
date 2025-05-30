public class PilhaReimpressao {
    private Documento[] pilha;
    private int topo;

    public PilhaReimpressao(int capacidade) {
        pilha = new Documento[capacidade];
        topo = -1;
    }

    public boolean pilhaVazia() {
        return topo == -1;
    }

    public boolean pilhaCheia() {
        return topo == pilha.length - 1;
    }

    public void empilhar(Documento doc) {
        if (pilhaCheia()) throw new RuntimeException("Pilha cheia");
        pilha[++topo] = doc;
    }

    public Documento desempilhar() {
        if (pilhaVazia()) throw new RuntimeException("Pilha vazia");
        return pilha[topo--];
    }

    public void mostrarPilha() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia.");
            return;
        }
        System.out.println("=== Documentos na Pilha de Reimpressão ===");
        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }
}