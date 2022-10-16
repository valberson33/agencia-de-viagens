package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Promocao;
import modelo.Conexao;

public class PromocaoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Promocao promocao) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO promocao(soIda,idaVolta,dataDaPromocao)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, promocao.getSoIda());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, promocao.getIdaVolta());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(promocao.getDataDaPromocao().getTime()));
		
			

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

		String sql = "DELETE FROM promocao WHERE id = ?";

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

	public void update(Promocao promocao) {

		String sql = "UPDATE promocao SET soIda = ?, idaVolta = ?, dataDaPromocao = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
						pstm.setString(1, promocao.getSoIda());
						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(2, promocao.getIdaVolta());
						// Adiciona o valor do terceiro parâmetro da sql
						pstm.setDate(3, new Date(promocao.getDataDaPromocao().getTime()));
					
			pstm.setInt(4, promocao.getId());

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

	public List<Promocao> getPromocaos() {

		String sql = "SELECT * FROM promocao";

		List<Promocao> promocaos = new ArrayList<Promocao>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Promocao promocao = new Promocao();

				// Recupera o id do banco e atribui ele ao objeto
				promocao.setId(rset.getInt("id"));

				// Recupera soIda do banco e atribui ele ao objeto
				promocao.setSoIda(rset.getString("soIda"));

				// Recupera idaVolta do banco e atribui ele ao objeto
				promocao.setIdaVolta(rset.getString("idaVolta"));
			
				// Recupera a data do banco e atribui ela ao objeto
				promocao.setDataDaPromocao(rset.getDate("dataDaPromocao"));

				// Adiciono a promocao recuperado, a lista de promocaos
				promocaos.add(promocao);
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

		return promocaos;
	}


	public Promocao getCompraById(int id) {

		String sql = "SELECT * FROM Promocao where id = ?";
		Promocao promocao = new Promocao();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			promocao.setSoIda(rset.getString("soIda"));
			promocao.setIdaVolta(rset.getString("idaVolta"));
			promocao.setDataDaPromocao(rset.getDate("dataDaPromocao"));

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
		return promocao;
	}

	public Promocao getPromocaoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

