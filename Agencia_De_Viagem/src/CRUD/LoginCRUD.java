package CRUD;


		// TODO Auto-generated method stub
		import java.util.Date;
		import java.util.Scanner;

import DAO.LoginDAO;
import modelo.Login;

		
public class LoginCRUD {
	
			public static void main(String args[]) {

				LoginDAO loginDAO = new LoginDAO();
				Login login = new Login();

				Scanner entrada = new Scanner(System.in);
				int opcao = 0;
				String administravo = "";
				String comum = "";
				
				int codigo = 0;

				do {

					System.out.println("===== Agenda =====");
					System.out.println("1 - Cadastro de login");
					System.out.println("2 - Excluir login");
					System.out.println("3 - Atualizar login");
					System.out.println("4 - Mostrar logins");
					System.out.println("5 - Buscar por ID");
					System.out.println("6 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					case 1: {
						System.out.println("Digite o login administraavo : ");
						administravo = entrada.next();
						login.setAdministrativo(administravo);

						System.out.println("Digite o login comum : ");
						comum = entrada.next();
						login.setComum(comum);

						login.setDataDoLogin(new Date());

						loginDAO.save(login);
						break;
					}
					case 2: {
						System.out.println("Digite o codigo do login para exclusao: ");
						try {
							codigo = entrada.nextInt();
							
							loginDAO.removeById(codigo);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println(" Nenhum login para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o codigo do login para atualizar: ");
						codigo = entrada.nextInt();

						System.out.println("Digite o login administrativo: ");
						administravo = entrada.next();
						login.setAdministrativo(administravo);

						System.out.println("Digite o login comum: ");
						comum = entrada.next();
						login.setComum(comum);

						login.setDataDoLogin(new Date());

						login.setId(codigo);

						loginDAO.update(login);
						break;
					}
					case 4: {
						for (Login c : loginDAO.getLogins()) {

							System.out.println("ADMINISTRATIVO: " + c.getAdministrativo());
							System.out.println("COMUM: " + c.getComum());
							System.out.println("DATA DO LOGIn: " + c.getDataDoLogin());

							System.out.println("----------------------------------- ");
						}
						break;
					}
					case 5: {

						System.out.print("Digite o ID para buscar: ");
						int id = entrada.nextInt();
						
						Login c = new Login();

						c = loginDAO.getLoginById(id);

						System.out.println("ADIMINISTRATIVO: " + c.getAdministrativo());
						System.out.println("COMUM: " + c.getComum());
						System.out.println("DATA CADASTRO: " + c.getDataDoLogin());

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

	


