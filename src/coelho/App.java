package coelho;
import java.util.*;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    GerenciaCoelho.menuClientes();
                    break;
                case 2:
                	GerenciaCoelho.menuImoveis();
                    break;
                case 3:
                	GerenciaCoelho.menuFaturas();
                    break;
                case 4:
                	GerenciaCoelho.menuPagamentos();
                	break;
                case 5:
                	GerenciaCoelho.menuFalhas();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
	
	}
}
