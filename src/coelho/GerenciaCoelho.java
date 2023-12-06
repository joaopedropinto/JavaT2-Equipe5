package coelho;
import java.text.*;
import java.util.*;

public class GerenciaCoelho {
	
	private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static ArrayList<Fatura> faturas = new ArrayList<>();
    
    static Cliente buscarClienteCPF(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
    
    public static void menuClientes(){
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
	    Cliente cliente = buscarClienteCPF(cpfConsulta);
	    
	    if(cliente == null) {
	    	System.out.println("Cliente não encontrado.");
	    	return;
	    }
	  
  		System.out.println("Cliente encontrado:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        return;
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
	    Cliente cliente = buscarClienteCPF(cpfExcluir);
	    
	    if(cliente == null) {
	    	System.out.println("Cliente não encontrado.");
	    	return;
	    }
        clientes.remove(cliente);
        System.out.println("Cliente excluído com sucesso!");
        return;   
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
    	System.out.println("\n=== Incluindo imóvel ===");
    	System.out.println("Digite o CPF do cliente: ");
	    String cpfCliente = scanner.nextLine();
	    
	    Cliente cliente = buscarClienteCPF(cpfCliente);
	    if(cliente == null) {
	    	System.out.println("Cliente não encontrado!");
	    	return;
	    }
	    
    	System.out.println("Matricula do imóvel: ");
        String matricula = scanner.nextLine();
        
        System.out.println("Endereço do imóvel: ");
        String endereco = scanner.nextLine();

        System.out.println("Última leitura (em KWh): ");
        double ultimaLeitura = scanner.nextDouble();

        System.out.println("Penúltima leitura (em KWh): ");
        double penultimaLeitura = scanner.nextDouble();
        
        Imovel imovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
        cliente.adicionarImovel(imovel);
        System.out.println("Imóvel adicionado com sucesso!");
    }

    private static void consultarImovel(Scanner scanner) {
        System.out.println("Digite a matricula do imóvel: ");
        String matriculaConsulta = scanner.nextLine();
        
        for(Cliente cliente : clientes) {
        	for (Imovel imovel : cliente.getImoveis()) {
        		if (imovel.getMatricula().equalsIgnoreCase(matriculaConsulta)) {
        			System.out.println("Imóvel encontrado:");
        			System.out.println("Matricula: " + imovel.getMatricula());
        			System.out.println("Endereço: " + imovel.getEndereco());
        			System.out.println("Última Leitura: " + imovel.getUltimaLeitura() + " KWh");
        			System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura() + " KWh");
        			return;
        		}
        	}
        }

        System.out.println("Imóvel não encontrado.");
    }

    private static void listarImoveis() {
            System.out.println("Lista de Imóveis:");
            for(Cliente cliente : clientes) {
            	for (Imovel imovel : cliente.getImoveis()) {
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

        for(Cliente cliente : clientes) {
        	for (Imovel imovel : cliente.getImoveis()) {
        		if(imovel.getMatricula().equalsIgnoreCase(matriculaExcluir)) {
        			cliente.excluiImovel(imovel);
        			System.out.println("Imovel excluído com sucesso!");
        		}
        	}
    	}
        System.out.println("Imóvel não encontrado!");
    }

    private static void alterarImovel(Scanner scanner) {
        System.out.print("Digite a matricula do imóvel para alterar: ");
        String matriculaAlterar = scanner.nextLine();

        for(Cliente cliente : clientes) {
        	for (Imovel imovel : cliente.getImoveis()) {
        		
	            if (imovel.getMatricula().equalsIgnoreCase(matriculaAlterar)) {
	                System.out.print("Digite o novo endereço): ");
	                scanner.nextLine();
	                String novoEndereco = scanner.nextLine();
	                System.out.println("Digite a última leitura: ");
					double novaUltimaLeitura = scanner.nextDouble();
					System.out.println("Digite a penúltima leitura: ");
					double novaPenultimaLeitura = scanner.nextDouble();
	                imovel.setEndereco(novoEndereco);
	                imovel.setPenultimaLeitura(novaPenultimaLeitura);
	                imovel.setUltimaLeitura(novaUltimaLeitura);
	                System.out.println("Imovel alterado com sucesso!");
	                return;
	            }
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
                //Imovel imovelAchado = imovel;
                Fatura fatura = new Fatura(imovel.getUltimaLeitura(), imovel.getPenultimaLeitura());
                faturas.add(fatura);
                System.out.println("Fatura criada com sucesso!");
                System.out.print("Nova leitura atual (em KWh): ");
                double novaLeitura = scanner.nextDouble();
                imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
                imovel.setUltimaLeitura(novaLeitura);
                System.out.println("Leituras atualizadas com sucesso!");
            }else {
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
             System.out.println("1. Criar Pagamento");
             System.out.println("2. Listar Pagamentos");
             System.out.println("3. Listar Pagamentos por Faturas");
             System.out.println("0. Voltar ao Menu Principal");
             System.out.print("Escolha uma opção: ");

             int opcao = scanner.nextInt();
             scanner.nextLine(); 
             
             switch (opcao) {
             case 1:
                 criarPagamento(scanner);
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
    private static void criarPagamento(Scanner scanner) {
    	System.out.print("Insira o cpf do cliente para realizar o pagamento: ");
    	String cpfCliente = scanner.nextLine();
    	Cliente cliente = buscarClienteCPF(cpfCliente);
    	
    	if (cliente == null) {
    		System.out.println("Cliente não encontrado!");
    		return;
    	}
    	System.out.println("Digite a matrícula do imóvel que deseja pagar a fatura: ");
     	int matricula = scanner.nextInt();
    	
    	
    }
}


//System.out.print("Nova leitura atual (em KWh): ");
//double novaLeitura = scanner.nextDouble();
//imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
//imovel.setUltimaLeitura(novaLeitura);
//
//System.out.println("Leituras alteradas com sucesso!");
//return;

