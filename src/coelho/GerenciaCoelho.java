package coelho;
import java.text.*;
import java.util.*;

public class GerenciaCoelho {
	
	private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static ArrayList<Fatura> faturas = new ArrayList<>();
    private static ArrayList<Falha> listaFalhas = new ArrayList<>();
    private static ArrayList<Pagamento> pagamentos = new ArrayList<>();
    
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
		System.out.println("\n=== Adicionando Cliente ===");
        System.out.println("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("CPF do cliente: ");
        String cpf = scanner.nextLine();

        clientes.add(new Cliente(cpf, nome));
        System.out.println("Cliente adicionado com sucesso!");
    }
	
	private static void consultarCliente(Scanner scanner) {
		System.out.println("\n=== Consultando Cliente ===");
	    System.out.println("Digite o CPF do cliente: ");
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
			System.out.println("\n=== Lista de Clientes ===");
	        for (Cliente cliente : clientes) {
	            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
	        }
	    }
	}
	
	private static void excluirCliente(Scanner scanner) {
		System.out.println("\n=== Excluindo Cliente ===");
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
		System.out.println("\n=== Alterando Cliente ===");
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
    	System.out.println("\n=== Incluindo Imóvel ===");
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
    	System.out.println("\n=== Consultando Imóvel ===");
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
    	System.out.println("\n=== Lista de imóveis ===");
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
    	System.out.println("\n=== Excluindo Imóvel ===");
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
    	System.out.println("\n=== Alterando Imóvel ===");
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
    	System.out.println("\n=== Criando Fatura ===");

        System.out.print("Insira a matrícula do imóvel para criar a fatura: ");
        String matriculaImovel = scanner.nextLine();
        for(Cliente cliente : clientes) {    	
        	for (Imovel imovel :  cliente.getImoveis()) {
        		if (imovel.getMatricula().equalsIgnoreCase(matriculaImovel)) {
        			double ultimaLeitura = imovel.getUltimaLeitura();
        			double penultimaLeitura = imovel.getPenultimaLeitura();
        			
        			Fatura fatura = new Fatura(ultimaLeitura, penultimaLeitura, imovel);
        			faturas.add(fatura);
        			System.out.println("Fatura criada com sucesso!");
        			System.out.print("Nova leitura atual (em KWh): ");
        			double novaLeitura = scanner.nextDouble();
        			imovel.setPenultimaLeitura(ultimaLeitura);
        			imovel.setUltimaLeitura(novaLeitura);
        			System.out.println("Leituras atualizadas com sucesso!");
        			return;
        		}
        	}
        }
        
        System.out.println("Imovel não encontrado!");
    }
    
    private static void listarTodasFaturas() {
        if (faturas.isEmpty()) {
            System.out.println("Nenhuma fatura cadastrada.");
        } else {
        	System.out.println("\n=== Listando Faturas ===");
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
        	System.out.println("\n=== Listando Faturas em Aberto ===");
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
                 listarPagamentos();
                 break;
             case 3:
                 System.out.print("Digite a matrícula da fatura para listar os pagamentos: ");
                 String matriculaFatura = scanner.nextLine();
                 listarPagamentosPorFatura(matriculaFatura);
                 break;
             
             case 0:
                 return;
             default:
                 System.out.println("Opção inválida. Tente novamente.");
             }

    	 }
    }
    private static void criarPagamento(Scanner scanner) {
        System.out.println("\n=== Criando Pagamento ===");
    
        System.out.print("Insira o cpf do cliente para realizar o pagamento: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = buscarClienteCPF(cpfCliente);
    
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
    
        System.out.print("Digite a matrícula do imóvel que deseja pagar a fatura: ");
        String matriculaImovel = scanner.nextLine();
    
        for (Fatura fatura : faturas) {
            if (fatura.getImovel().getMatricula().equalsIgnoreCase(matriculaImovel) && !fatura.isQuitada()) {
                System.out.print("Digite o valor do pagamento: ");
                double valorPagamento = scanner.nextDouble();
    
                Pagamento pagamento = new Pagamento(fatura.getImovel().getMatricula(), valorPagamento);
                pagamentos.add(pagamento);
    
                fatura.setQuitada(true);
    
                System.out.println("Pagamento registrado com sucesso!");
                return;
            }
        }
    
        System.out.println("Fatura não encontrada ou já quitada!");
    }
    
    private static void listarPagamentos() {
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
        } else {
            System.out.println("\n=== Lista de Pagamentos ===");
            for (Pagamento pagamento : pagamentos) {
                System.out.println("Matrícula da Fatura: " + pagamento.getMatriculaFatura());
                System.out.println("Valor do Pagamento: R$" + pagamento.getValor());
                System.out.println("Data do Pagamento: " + pagamento.getData());
                System.out.println("Reembolso: " + (pagamento.isReembolso() ? "Sim" : "Não"));
                System.out.println("-------------------------------");
            }
        }
    }
    
    private static void listarPagamentosPorFatura(String matriculaFatura) {
        System.out.println("\n=== Lista de Pagamentos para a Fatura ===");
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getMatriculaFatura().equalsIgnoreCase(matriculaFatura)) {
                System.out.println("Matrícula da Fatura: " + pagamento.getMatriculaFatura());
                System.out.println("Valor do Pagamento: R$" + pagamento.getValor());
                System.out.println("Data do Pagamento: " + pagamento.getData());
                System.out.println("Reembolso: " + (pagamento.isReembolso() ? "Sim" : "Não"));
                System.out.println("-------------------------------");
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
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void incluirFalha(Scanner scanner) {
    	System.out.println("\n=== Criando Falha ===");
    	System.out.println("Informe a matrícula do imóvel: ");
    	String matriculaImovel = scanner.nextLine();
    	for(Cliente cliente: clientes) {
    		for(Imovel imovel: cliente.getImoveis()) {
    			if (imovel.getMatricula().equalsIgnoreCase(matriculaImovel)) {
    				System.out.print("Tipo de Falha (Geração/Distribuição): ");
    		        String tipo = scanner.nextLine();

    		        System.out.print("Descrição da Falha: ");
    		        String descricao = scanner.nextLine();

    		        Date dataInicio = new Date();
    		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		        String dataInicioString = dateFormat.format(dataInicio);

    		        Falha novaFalha = new Falha(imovel, tipo, descricao, dataInicioString);

    		        listaFalhas.add(novaFalha);

    		        System.out.println("Falha adicionada com sucesso!");
    		        return;
    			}
    			
    		}
    	}
    	System.out.println("Imovel não encontrado, não é possível incluir uma falha!");
    }

    private static void listarFalhas() {
        if (listaFalhas.isEmpty()) {
            System.out.println("Nenhuma falha cadastrada.");
        } else {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        	System.out.println("\n=== Lista de Falhas ===");
            int index = 1;
            for (Falha falha : listaFalhas) {
                System.out.println(index + ". Tipo: " + falha.getTipo() + ", Descrição: " + falha.getDescricao() + ", Data início: " + dateFormat.format(falha.getDataInicio()));
                index++;
            }
        }
    }

    private static void encerrarReparo(Scanner scanner) {
    	System.out.println("\n=== Encerrando Reparo ===");

        listarFalhas();
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


