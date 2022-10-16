 package CRUD;



	// TODO Auto-generated method stub
		import java.util.Date;
		import java.util.Scanner;

import DAO.DestinoDAO;
import modelo.Destino;

		
public class DestinoCRUD {
			public static void main(String args[]) {

				DestinoDAO destinoDAO = new DestinoDAO();
				Destino destino = new Destino();

				Scanner entrada = new Scanner(System.in);
				int opcao = 0;
				String estado = "";
				String cidade = "";
				int codigo = 0;

				do {

					System.out.println("===== Agencia =====");
					System.out.println("1 - Cadastro de destino");
					System.out.println("2 - Excluir destino");
					System.out.println("3 - Atualizar destino");
					System.out.println("4 - Mostrar destinos");
					System.out.println("5 - Buscar por ID");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					case 1: {
						System.out.println("Digite o estado do destino: ");
						estado = entrada.next();
						destino.setEstado(estado);

						System.out.println("Digite a cidade do destino: ");
						cidade = entrada.next();
						destino.setCidade(cidade);

						destino.setDataDoDestino(new Date());

						destinoDAO.save(destino);
						break;
					}
					case 2: {
						System.out.println("Digite o codigo do destino para exclusao: ");
						try {
							codigo = entrada.nextInt();
							
							destinoDAO.removeById(codigo);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println(" Nenhum destino para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o codigo do destino para atualizar: ");
						codigo = entrada.nextInt();

						System.out.println("Digite o estado do destino: ");
						estado = entrada.next();
						destino.setEstado(estado);

						System.out.println("Digite a cidade do destino: ");
						cidade = entrada.next();
						destino.setCidade(cidade);

						destino.setDataDoDestino(new Date());

						destino.setId(codigo);

						destinoDAO.update(destino);
						break;
					}
					case 4: {
						for (Destino c : destinoDAO.getDestinos()) {

							System.out.println("ESTADO: " + c.getEstado());
							System.out.println("CIDADE: " + c.getCidade());
							System.out.println("DATA DO DESTINO: " + c.getDataDoDestino());

							System.out.println("----------------------------------- ");
						}
						break;
					}
					case 5: {

						System.out.print("Digite o ID para buscar: ");
						int id = entrada.nextInt();
						
						Destino c = new Destino();

						c = destinoDAO.getDestinoById(id);

						System.out.println("ESTADO: " + c.getEstado());
						System.out.println("CIDADE: " + c.getCidade());
						System.out.println("DATA DO DESTINO: " + c.getDataDoDestino());

						System.out.println("----------------------------------- ");
					}
						break;

					case 6: {
						System.out.println(" === Obrigado por usar nossa Agencia === ");
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

	
