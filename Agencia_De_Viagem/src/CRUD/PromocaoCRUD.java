package CRUD;



		// TODO Auto-generated method stub
		import java.util.Date;
		import java.util.Scanner;

import DAO.PromocaoDAO;
import modelo.Promocao;

		
public class PromocaoCRUD {
			public static void main(String args[]) {

				PromocaoDAO promocaoDAO = new PromocaoDAO();
				Promocao promocao = new Promocao();

				Scanner entrada = new Scanner(System.in);
				int opcao = 0;
				String soIda = "";
				String idaVolta = "";
				int codigo = 0;

				do {

					System.out.println("===== Agencia =====");
					System.out.println("1 - Cadastro de promocao");
					System.out.println("2 - Excluir promocao");
					System.out.println("3 - Atualizar promocao");
					System.out.println("4 - Mostrar promocaos");
					System.out.println("5 - Buscar por ID");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					case 1: {
						System.out.println("Digite o soIda do promocao: ");
						soIda = entrada.next();
						promocao.setSoIda(soIda);

						System.out.println("Digite a idaVolta do promocao: ");
						idaVolta = entrada.next();
						promocao.setIdaVolta(idaVolta);

						promocao.setDataDaPromocao(new Date());

						promocaoDAO.save(promocao);
						break;
					}
					case 2: {
						System.out.println("Digite o codigo do promocao para exclusao: ");
						try {
							codigo = entrada.nextInt();
							
							promocaoDAO.removeById(codigo);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println(" Nenhum promocao para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o codigo do promocao para atualizar: ");
						codigo = entrada.nextInt();

						System.out.println("Digite o soIda do promocao: ");
						soIda = entrada.next();
						promocao.setSoIda(soIda);

						System.out.println("Digite a idade do promocao: ");
						idaVolta = entrada.next();
						promocao.setIdaVolta(idaVolta);

						promocao.setDataDaPromocao(new Date());

						promocao.setId(codigo);

						promocaoDAO.update(promocao);
						break;
					}
					case 4: {
						for (Promocao c : promocaoDAO.getPromocaos()) {

							System.out.println("SOIDA: " + c.getSoIda());
							System.out.println("IDAVOLTA: " + c.getIdaVolta());
							System.out.println("DATA DA PROMOCAO: " + c.getDataDaPromocao());

							System.out.println("----------------------------------- ");
						}
						break;
					}
					case 5: {

						System.out.print("Digite o ID para buscar: ");
						int id = entrada.nextInt();
						
						Promocao c = new Promocao();

						c = promocaoDAO.getPromocaoById(id);

						System.out.println("SOIDA: " + c.getSoIda());
						System.out.println("IDAVOLTA: " + c.getIdaVolta());
						System.out.println("DATA CADASTRO: " + c.getDataDaPromocao());

						System.out.println("----------------------------------- ");
					}
						break;

					case 6: {
						System.out.println(" === Obrigado por usar nossaAagencia === ");
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

	

	


