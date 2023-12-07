package coelho;

import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GerenciaCoelho {

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static ArrayList<Fatura> faturas = new ArrayList<>();
    private static ArrayList<Falha> listaFalhas = new ArrayList<>();

    public static void menuClientes() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Gestão de Clientes ===");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Alterar Cliente");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirCliente(scanner);
                    break;
                case 2:
                    consultarCliente(scanner);
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    excluirCliente(scanner);
                    break;
                case 5:
                    alterarCliente(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void incluirCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        clientes.add(new Cliente(cpf, nome));
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void consultarCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpfConsulta = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfConsulta)) {
                System.out.println("Cliente encontrado:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
            }
        }
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser excluído: ");
        String cpfExcluir = scanner.nextLine();

        clientes.removeIf(cliente -> cliente.getCpf().equals(cpfExcluir));
        System.out.println("Cliente excluído com sucesso!");
    }

    private static void alterarCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser alterado: ");
        String cpfAlterar = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfAlterar)) {
                System.out.print("Novo nome do cliente: ");
                String novoNome = scanner.nextLine();
                cliente.setNome(novoNome);

                System.out.println("Cliente alterado com sucesso!");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    public static void menuImoveis() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Gestão de Imóveis ===");
            System.out.println("1. Incluir Imóvel");
            System.out.println("2. Consultar Imóvel");
            System.out.println("3. Listar Imóveis");
            System.out.println("4. Excluir Imóvel");
            System.out.println("5. Alterar Leituras");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirImovel(scanner);
                    break;
                case 2:
                    consultarImovel(scanner);
                    break;
                case 3:
                    listarImoveis();
                    break;
                case 4:
                    excluirImovel(scanner);
                    break;
                case 5:
                    alterarImovel(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void incluirImovel(Scanner scanner) {
        System.out.print("Matricula do imóvel: ");
        String matricula = scanner.nextLine();

        System.out.print("Endereço do imóvel: ");
        String endereco = scanner.nextLine();

        System.out.print("Última leitura (em KWh): ");
        double ultimaLeitura = scanner.nextDouble();

        System.out.print("Penúltima leitura (em KWh): ");
        double penultimaLeitura = scanner.nextDouble();

        imoveis.add(new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura));
        System.out.println("Imóvel adicionado com sucesso!");
    }

    private static void consultarImovel(Scanner scanner) {
        System.out.print("Digite a matricula do imóvel: ");
        String matriculaConsulta = scanner.nextLine();

        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equalsIgnoreCase(matriculaConsulta)) {
                System.out.println("Imóvel encontrado:");
                System.out.println("Matricula: " + imovel.getMatricula());
                System.out.println("Endereço: " + imovel.getEndereco());
                System.out.println("Última Leitura: " + imovel.getUltimaLeitura() + " KWh");
                System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura() + " KWh");
                return;
            }
        }

        System.out.println("Imóvel não encontrado.");
    }

    private static void listarImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
        } else {
            System.out.println("Lista de Imóveis:");
            for (Imovel imovel : imoveis) {
                System.out.println("Matricula: " + imovel.getMatricula() +
                        ", Endereço: " + imovel.getEndereco() +
                        ", Última Leitura: " + imovel.getUltimaLeitura() +
                        ", Penúltima Leitura: " + imovel.getPenultimaLeitura());
            }
        }
    }

    private static void excluirImovel(Scanner scanner) {
        System.out.print("Digite a matricula do imóvel a ser excluído: ");
        String matriculaExcluir = scanner.nextLine();

        imoveis.removeIf(imovel -> imovel.getMatricula().equalsIgnoreCase(matriculaExcluir));
        System.out.println("Imóvel excluído com sucesso!");
    }

    private static void alterarImovel(Scanner scanner) {
        System.out.print("Digite a matricula do imóvel para alterar: ");
        String matriculaAlterar = scanner.nextLine();

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equalsIgnoreCase(matriculaAlterar)) {
                System.out.print("Digite o endereço): ");
                String novoEndereco = scanner.nextLine();
                imovel.setEndereco(novoEndereco);
                System.out.println("Endereço alterado com sucesso!");
                return;
            }
        }

        System.out.println("Imóvel não encontrado.");
    }

    public static void menuFaturas() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Faturas ===");
            System.out.println("1. Criar Fatura");
            System.out.println("2. Listar Todas as Faturas");
            System.out.println("3. Listar Faturas em Aberto");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarFatura(scanner);
                    break;
                case 2:
                    listarTodasFaturas();
                    break;
                case 3:
                    listarFaturasEmAberto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }

    private static void criarFatura(Scanner scanner) {
        System.out.print("Insira a matrícula do imóvel para criar a fatura: ");
        String matriculaImovel = scanner.nextLine();
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equalsIgnoreCase(matriculaImovel)) {
                // Imovel imovelAchado = imovel;
                Fatura fatura = new Fatura(imovel.getUltimaLeitura(), imovel.getPenultimaLeitura());
                faturas.add(fatura);
                System.out.println("Fatura criada com sucesso!");
                System.out.print("Nova leitura atual (em KWh): ");
                double novaLeitura = scanner.nextDouble();
                imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
                imovel.setUltimaLeitura(novaLeitura);
                System.out.println("Leituras atualizadas com sucesso!");
            } else {
                System.out.println("Imovel não encontrado!");

            }
        }
    }

    private static void listarTodasFaturas() {
        if (faturas.isEmpty()) {
            System.out.println("Nenhuma fatura cadastrada.");
        } else {
            System.out.println("Lista de Todas as Faturas:");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (Fatura fatura : faturas) {
                System.out.println("Data de Emissão: " + dateFormat.format(fatura.getDataEmissao()));
                System.out.println("Última Leitura: " + fatura.getUltimaLeitura() + " KWh");
                System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura() + " KWh");
                System.out.println("Valor: R$" + fatura.getValor());
                System.out.println("Quitada: " + (fatura.isQuitada() ? "Sim" : "Não"));
                System.out.println("-------------------------------");
            }
        }
    }

    private static void listarFaturasEmAberto() {
        if (faturas.isEmpty()) {
            System.out.println("Nenhuma fatura em aberto.");
        } else {
            System.out.println("Lista de Faturas em Aberto:");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (Fatura fatura : faturas) {
                if (!fatura.isQuitada()) {
                    System.out.println("Data de Emissão: " + dateFormat.format(fatura.getDataEmissao()));
                    System.out.println("Última Leitura: " + fatura.getUltimaLeitura() + " KWh");
                    System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura() + " KWh");
                    System.out.println("Valor: R$" + fatura.getValor());
                    System.out.println("Quitada: " + (fatura.isQuitada() ? "Sim" : "Não"));
                    System.out.println("-------------------------------");
                }
            }
        }
    }

    public static void menuPagamentos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Pagamentos ===");
            System.out.println("1. Criar Fatura");
            System.out.println("2. Listar Todas as Faturas");
            System.out.println("3. Listar Faturas em Aberto");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarFatura(scanner);
                    break;
                case 2:
                    listarTodasFaturas();
                    break;
                case 3:
                    listarFaturasEmAberto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }

    public static void menuFalhas() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("\n=== Menu de Falhas ===");
            System.out.println("1. Incluir Falhas");
            System.out.println("2. Listar Falhas");
            System.out.println("3. Encerrar Reparo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirFalha(scanner);
                    break;
                case 2:
                    listarFalhas();
                    break;
                case 3:
                    encerrarReparo(scanner);
                    break;
                case 0:
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void incluirFalha(Scanner scanner) {
        System.out.print("Tipo de Falha (Geração/Distribuição): ");
        String tipo = scanner.nextLine();

        System.out.print("Descrição da Falha: ");
        String descricao = scanner.nextLine();

        Date dataInicio = new Date(); // Obtém a data atual do sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataInicioString = dateFormat.format(dataInicio); // Converte a Date para String

        Falha novaFalha = new Falha(tipo, descricao, dataInicioString);

        listaFalhas.add(novaFalha);

        System.out.println("Falha adicionada com sucesso!");
    }

    private static void listarFalhas() {
        if (listaFalhas.isEmpty()) {
            System.out.println("Nenhuma falha cadastrada.");
        } else {
            System.out.println("Lista de Falhas:");
            int index = 1;
            for (Falha falha : listaFalhas) {
                System.out.println(index + ". Tipo: " + falha.getTipo() + ", Descrição: " + falha.getDescricao());
                index++;
            }
        }
    }

    private static void encerrarReparo(Scanner scanner) {
        listarFalhas(); // Mostra as falhas antes da exclusão
        System.out.print("Digite o número da falha a ser excluída: ");
        int numeroFalha = scanner.nextInt();
        scanner.nextLine();

        if (numeroFalha < 1 || numeroFalha > listaFalhas.size()) {
            System.out.println("Número de falha inválido.");
        } else {
            listaFalhas.remove(numeroFalha - 1); // Remove a falha pela posição na lista
            System.out.println("Falha excluída com sucesso!");
        }
    }
}

// System.out.print("Nova leitura atual (em KWh): ");
// double novaLeitura = scanner.nextDouble();
// imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
// imovel.setUltimaLeitura(novaLeitura);
//
// System.out.println("Leituras alteradas com sucesso!");
// return;
