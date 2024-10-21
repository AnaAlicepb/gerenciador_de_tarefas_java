import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {

    // Lista de tarefas armazenada em memória
    private List<String> tarefas;

    // Construtor para inicializar a lista de tarefas
    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    // Método para exibir o menu e lidar com as opções
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n==== Gerenciador de Tarefas ====");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Adicionar tarefa");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número válido
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após o número

                switch (opcao) {
                    case 1:
                        listarTarefas();
                        break;
                    case 2:
                        adicionarTarefa(scanner);
                        break;
                    case 3:
                        removerTarefa(scanner);
                        break;
                    case 4:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                // Descartar entrada inválida e mostrar mensagem de erro
                System.out.println("Por favor, digite um número válido.");
                scanner.next(); // Descartar entrada não numérica
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Método para listar todas as tarefas
    private void listarTarefas() {
        System.out.println("\n==== Lista de Tarefas ====");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    // Método para adicionar uma nova tarefa com validação
    private void adicionarTarefa(Scanner scanner) {
        System.out.print("\nDigite a nova tarefa: ");
        String tarefa = scanner.nextLine(); // Aceitar entrada com texto e números

        // Verifica se a tarefa já existe na lista
        if (tarefas.contains(tarefa)) {
            System.out.println("A tarefa já existe! Por favor, insira uma tarefa diferente.");
        } else {
            tarefas.add(tarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        }
    }

    // Método para remover uma tarefa pelo índice
    private void removerTarefa(Scanner scanner) {
        System.out.print("\nDigite o número da tarefa a ser removida: ");
        
        // Verifica se a entrada é um número válido
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt() - 1; // Ajusta para índice da lista
            scanner.nextLine(); // Consumir a quebra de linha

            if (index >= 0 && index < tarefas.size()) {
                tarefas.remove(index);
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Índice inválido! Tente novamente.");
            }
        } else {
            System.out.println("Por favor, digite um número válido.");
            scanner.next(); // Descartar entrada inválida
        }
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        gerenciador.exibirMenu();
    }
}
