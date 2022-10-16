package CRUD;



		// TODO Auto-generated method stub
		import java.util.Date;
		import java.util.Scanner;

import DAO.ClienteDAO;
import modelo.Cliente;

public class CilenteCRUD {
			public static void main(String args[]) {

				ClienteDAO clienteDAO = new ClienteDAO();
				Cliente cliente = new Cliente();

				Scanner entrada = new Scanner(System.in);
				int opcao = 0;
				String nome = "";
				int cpf = 0;
				int endereco = 0;
				int codigo = 0;

				do {

					System.out.println("===== Agencia =====");
					System.out.println("1 - Cadastro de cliente");
					System.out.println("2 - Excluir cliente");
					System.out.println("3 - Atualizar cliente");
					System.out.println("4 - Mostrar clientes");
					System.out.println("5 - Buscar por ID");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					case 1: {
						System.out.println("Digite o nome do cliente: ");
						nome = entrada.next();
						cliente.setNome(nome);

						System.out.println("Digite o cpf do cliente: ");
						cpf = entrada.nextInt();
						cliente.setCpf(cpf);
						
						System.out.print("Digite o endereco do cliente");

						cliente.setEndereco(endereco);

						cliente.setDataDoCliente(new Date());

						clienteDAO.save(cliente);
						break;
					}
					case 2: {
						System.out.println("Digite o codigo do cliente para exclusao: ");
						try {
							codigo = entrada.nextInt();
							
							clienteDAO.removeById(codigo);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println(" Nenhum cliente para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o codigo do cliente para atualizar: ");
						codigo = entrada.nextInt();

						System.out.println("Digite o nome do cliente: ");
						nome = entrada.next();
						cliente.setNome(nome);

						System.out.println("Digite a cpf do cliente: ");
						cpf = entrada.nextInt();
						cliente.setCpf(cpf);
						
						//System.out.println("Digite a endereco do cliente: ");
						endereco = entrada.nextInt();
						cliente.setEndereco(endereco);

						cliente.setDataDoCliente(new Date());

		//				cliente.setId(codigo);
//
						clienteDAO.update(cliente);
		//				break;
					}
					case 4: {
						for (Cliente c : clienteDAO.getClientes()) {

							System.out.println("NOME: " + c.getNome());
							System.out.println("CPF: " + c.getCpf());
							System.out.println("ENDERECO: " + c.getEndereco());
							System.out.println("DATA CADASTRO: " + c.getDataDoCliente());

							System.out.println("----------------------------------- ");
						}
						break;
					}
					case 5: {

						System.out.print("Digite o ID para buscar: ");
						int id = entrada.nextInt();
						
						Cliente c = new Cliente();

						c = clienteDAO.getClienteById(id);

						System.out.println("NOME: " + c.getNome());
						System.out.println("CPF: " + c.getCpf());
						System.out.println("IDADE: " + c.getEndereco());
						System.out.println("DATA CADASTRO: " + c.getDataDoCliente());

						System.out.println("----------------------------------- ");
					}
						break;

					case 6: {
						//System.out.println(" === Obrigado por usar nossa Agencia === ");
						//break;
					}
					default:
						System.out.println("Opcao invalida: ");

					}
					;

				} while (opcao != 6);

				entrada.close();

			}
		}