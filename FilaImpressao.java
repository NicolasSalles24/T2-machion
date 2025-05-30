public class FilaImpressao {
    private Documento[] fila;
    private int primeiro, ultimo, ocupacao;

    public FilaImpressao(int capacidade) {
        fila = new Documento[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }

    private int proxima(int pos) {
        return (pos + 1) % fila.length;
    }

    public boolean filaVazia() {
        return ocupacao == 0;
    }

    public boolean filaCheia() {
        return ocupacao == fila.length;
    }

    public void enfileira(Documento doc) {
        if (filaCheia()) throw new RuntimeException("Fila cheia");
        fila[ultimo] = doc;
        ultimo = proxima(ultimo);
        ocupacao++;
    }

    public Documento desenfileira() {
        if (filaVazia()) {
            System.out.println("Fila vazia. Nada para imprimir.");
            return null;
        }
        Documento doc = fila[primeiro];
        primeiro = proxima(primeiro);
        ocupacao--;
        return doc;
    }

    public boolean remover(String nome) {
        if (filaVazia()) return false;
        int i = primeiro, count = 0;
        Documento[] novaFila = new Documento[fila.length];
        int novoUltimo = 0;
        boolean removido = false;

        while (count < ocupacao) {
            Documento atual = fila[i];
            if (!atual.getNome().equalsIgnoreCase(nome)) {
                novaFila[novoUltimo++] = atual;
            } else {
                removido = true;
            }
            i = proxima(i);
            count++;
        }

        if (removido) {
            fila = novaFila;
            primeiro = 0;
            ultimo = novoUltimo;
            ocupacao = novoUltimo;
        }

        return removido;
    }

    public void consultarDocumento(String nome) {
        int i = primeiro, count = 0;
        while (count < ocupacao) {
            Documento doc = fila[i];
            if (doc.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Documento encontrado: " + doc + " | Posição na fila: " + (count + 1));
                return;
            }
            i = proxima(i);
            count++;
        }
        System.out.println("Documento não encontrado.");
    }

    public void mostrarFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("=== Documentos na Fila ===");
        int i = primeiro, count = 0;
        while (count < ocupacao) {
            System.out.println(fila[i]);
            i = proxima(i);
            count++;
        }
    }
}