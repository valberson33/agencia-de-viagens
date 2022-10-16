package DAO;


	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

import modelo.Cliente;
import modelo.Conexao;

	
public class ClienteDAO {
		Connection conn = null;
		PreparedStatement pstm = null;

		public void save(Cliente cliente) {

			// os ? são os parâmetros que nós vamos adicionar na base de dados

			String sql = "INSERT INTO cliente(nome,cpf,endereco,dataDoCliente)" + " VALUES(?,?,?,?)";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, cliente.getNome());
				// Adicionar o valor do segundo parâmetro da sql
				pstm.setInt(2, cliente.getCpf());
				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, cliente.getEndereco());
				// Adiciona o valor do quarto parâmetro da sql
				pstm.setDate(4, new Date(cliente.getDataDoCliente().getTime()));

				// Executa a sql para inserção dos dados
				pstm.execute();

			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				// Fecha as conexões

				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

		public void removeById(int id) {

			String sql = "DELETE FROM cliente WHERE id = ?";

			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				pstm.execute();

			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

		public void update(Cliente cliente) {

			String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco =, dataDoCliente = ?" + " WHERE id = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, cliente.getNome());
				// Adicionar o valor do segundo parâmetro da sql
				pstm.setInt(2, cliente.getCpf());
				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, cliente.getEndereco());
				// Adiciona o valor do quarto parâmetro da sql
				pstm.setDate(4, new Date(cliente.getDataDoCliente().getTime()));

				pstm.setInt(5, cliente.getId());

				// Executa a sql para inserção dos dados
				pstm.execute();

			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				// Fecha as conexões

				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

		public List<Cliente> getClientes() {

			String sql = "SELECT * FROM cliente";

			List<Cliente> clientes = new ArrayList<Cliente>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça
				while (rset.next()) {

					Cliente cliente = new Cliente();

					// Recupera o id do banco e atribui ele ao objeto
					cliente.setId(rset.getInt("id"));

					// Recupera o nome do banco e atribui ele ao objeto
					cliente.setNome(rset.getString("nome"));

					// Recupera a cpf do banco e atribui ele ao objeto
					cliente.setCpf(rset.getInt("cpf"));
					
					// Recupera a endereco do banco e atribui ele ao objeto
					cliente.setEndereco(rset.getInt("endereco"));

					// Recupera a data do banco e atribui ela ao objeto
					cliente.setDataDoCliente(rset.getDate("dataDoCliente"));

					// Adiciono o contato recuperado, a lista de contatos
					clientes.add(cliente);
				}
			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				try {

					if (rset != null) {

						rset.close();
					}

					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			return clientes;
		}


		public Cliente getClienteById(int id) {

			String sql = "SELECT * FROM cliente where id = ?";
			Cliente cliente = new Cliente();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rset = pstm.executeQuery();

				rset.next();

				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getInt("cpf"));
				cliente.setEndereco(rset.getInt("endereco"));
				cliente.setDataDoCliente(rset.getDate("dataDoCliente"));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return cliente;
		}
	}

