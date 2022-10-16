package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Compra;
import modelo.Conexao;


	public class CompraDAO {
		Connection conn = null;
		PreparedStatement pstm = null;

		public void save(Compra compra) {

			// os ? são os parâmetros que nós vamos adicionar na base de dados

			String sql = "INSERT INTO compra(boleto,cartao,avista,dataDoCliente)" + " VALUES(?,?,?,?)";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, compra.getBoleto());
				// Adicionar o valor do segundo parâmetro da sql
				pstm.setInt(2, compra.getCartao());
				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, compra.getAvista());
				// Adiciona o valor do quarto parâmetro da sql
				pstm.setDate(4, new Date(compra.getDataDaCompra().getTime()));

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

			String sql = "DELETE FROM compra WHERE id = ?";

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

		public void update(Compra compra) {

			String sql = "UPDATE compra SET nome = ?, cpf = ?, endereco =, dataDaCompra = ?" + " WHERE id = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, compra.getBoleto());
				// Adicionar o valor do segundo parâmetro da sql
				pstm.setInt(2, compra.getCartao());
				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, compra.getAvista());
				// Adiciona o valor do quarto parâmetro da sql
				pstm.setDate(4, new Date(compra.getDataDaCompra().getTime()));

				pstm.setInt(5, compra.getId());

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

		public List<Compra> getCompras() {

			String sql = "SELECT * FROM compra";

			List<Compra> compras = new ArrayList<Compra>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça
				while (rset.next()) {

					Compra compra = new Compra();

					// Recupera o id do banco e atribui ele ao objeto
					compra.setId(rset.getInt("id"));

					// Recupera o boleto do banco e atribui ele ao objeto
					compra.setBoleto(rset.getInt("boleto"));

					// Recupera a cartao do banco e atribui ele ao objeto
					compra.setCartao(rset.getInt("cartao"));
					
					// Recupera a avista do banco e atribui ele ao objeto
					compra.setAvista(rset.getInt("avista"));

					// Recupera a data do banco e atribui ela ao objeto
					compra.setDataDaCompra(rset.getDate("dataDaCompra"));

					// Adiciono a compra recuperado, a lista de compras
					compras.add(compra);
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

			return compras;
		}


		public Compra getCompraById(int id) {

			String sql = "SELECT * FROM compra where id = ?";
			Compra compra = new Compra();

			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rset = pstm.executeQuery();

				rset.next();

				compra.setBoleto(rset.getInt("boleto"));
				compra.setCartao(rset.getInt("cartao"));
				compra.setAvista(rset.getInt("avista"));
				compra.setDataDaCompra(rset.getDate("dataDaCompra"));

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
			return compra;
		}
	}
