import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaImpressao fila = new FilaImpressao(5);
        PilhaReimpressao pilha = new PilhaReimpressao(5);

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar documento à fila");
            System.out.println("2 - Imprimir próximo documento");
            System.out.println("3 - Remover documento da fila");
            System.out.println("4 - Consultar documento");
            System.out.println("5 - Mostrar fila");
            System.out.println("6 - Reimprimir último documento");
            System.out.println("7 - Mostrar pilha de reimpressão");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (fila.filaCheia()) {
                        System.out.println("A fila está cheia!");
                        break;
                    }
                    System.out.print("Nome do arquivo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Usuário: ");
                    String usuario = scanner.nextLine();
                    Documento doc = new Documento(nome, usuario);
                    fila.enfileira(doc);
                    System.out.println("Documento adicionado.");
                    break;
                case 2:
                    Documento impresso = fila.desenfileira();
                    if (impresso != null) {
                        impresso.registrarImpressao();
                        pilha.empilhar(impresso);
                        System.out.println("Imprimindo: " + impresso);
                        System.out.println("Tempo de espera: " + impresso.calcularTempoEspera() + " segundos");
                    }
                    break;
                case 3:
                    System.out.print("Nome do arquivo a remover: ");
                    String nomeRemover = scanner.nextLine();
                    if (fila.remover(nomeRemover)) {
                        System.out.println("Documento removido.");
                    } else {
                        System.out.println("Documento não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do arquivo a consultar: ");
                    String nomeConsulta = scanner.nextLine();
                    fila.consultarDocumento(nomeConsulta);
                    break;
                case 5:
                    fila.mostrarFila();
                    break;
                case 6:
                    try {
                        Documento reimp = pilha.desempilhar();
                        System.out.println("Reimprimindo: " + reimp);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    pilha.mostrarPilha();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
