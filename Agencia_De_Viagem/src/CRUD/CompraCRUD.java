package CRUD;



		// TODO Auto-generated method stub
		import java.util.Date;
		import java.util.Scanner;

import DAO.CompraDAO;
import modelo.Compra;

		
public class CompraCRUD {
			public static void main(String args[]) {

				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();

				Scanner entrada = new Scanner(System.in);
				int opcao = 0;
				int boleto = 0;
				int cartao = 0;
				int avista= 0;
				int codigo = 0;

				do {

					System.out.println("===== Agencia =====");
					System.out.println("1 - Cadastro de compra");
					System.out.println("2 - Excluir compra");
					System.out.println("3 - Atualizar compra");
					System.out.println("4 - Mostrar compras");
					System.out.println("5 - Buscar por ID");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					case 1: {
						System.out.println("Digite o boleto do compra: ");
						boleto = entrada.nextInt();
						compra.setBoleto(boleto);
						
						System.out.println("Digite o cartao do compra: ");
						cartao = entrada.nextInt();
						compra.setCartao(cartao);
						

						System.out.println("Digite a avista do compra: ");
						avista = entrada.nextInt();
						compra.setAvista(avista);

						compra.setDataDaCompra(new Date());

						compraDAO.save(compra);
						break;
					}
					case 2: {
						System.out.println("Digite o codigo do compra para exclusao: ");
						try {
							codigo = entrada.nextInt();
							
							compraDAO.removeById(codigo);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println(" Nenhum compra para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o codigo do compra para atualizar: ");
						codigo = entrada.nextInt();

						System.out.println("Digite o boleto do compra: ");
						boleto = entrada.nextInt();
						compra.setBoleto(boleto);

						System.out.println("Digite a cartao do compra: ");
						cartao = entrada.nextInt();
						compra.setCartao(cartao);

						System.out.println("Digite o avista do compra: ");
						avista = entrada.nextInt();
						compra.setAvista(avista);
						
						compra.setDataDaCompra(new Date());

						compra.setId(codigo);

						compraDAO.update(compra);
						break;
					}
					case 4: {
						for (Compra c : compraDAO.getCompras()) {

							System.out.println("BOLETO: " + c.getBoleto());
							System.out.println("CARTAO: " + c.getCartao());
							System.out.println("AVISTA: " + c.getAvista());
							System.out.println("DATA DA COMPRA: " + c.getDataDaCompra());

							System.out.println("----------------------------------- ");
						}
						break;
					}
					case 5: {

						System.out.print("Digite o ID para buscar: ");
						int id = entrada.nextInt();
						
						Compra c = new Compra();

						c = compraDAO.getCompraById(id);

						System.out.println("BOLETO: " + c.getBoleto());
						System.out.println("CARTAO: " + c.getCartao());
						System.out.println("AVISTA: " + c.getAvista());
						System.out.println("DATA DA COMPRA: " + c.getDataDaCompra());

						System.out.println("----------------------------------- ");
					}
						break;

					case 6: {
						System.out.println(" === Obrigado por usar nossa Agencia=== ");
						break;
					}
					default:
						System.out.println("Opcao invalida: ");

					}
					;

				} while (opcao != 6);

				entrada.close();

			}
		}

	