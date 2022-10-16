package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Destino;
import modelo.Conexao;

public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO destino(estado,cidade,dataDoDestino)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getEstado());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, destino.getCidade());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(destino.getDataDoDestino().getTime()));
		
			

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

		String sql = "DELETE FROM destino WHERE id = ?";

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

	public void update(Destino destino) {

		String sql = "UPDATE destino SET estado = ?, cidade = ?, dataDoDestino = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
						pstm.setString(1, destino.getEstado());
						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(2, destino.getCidade());
						// Adiciona o valor do terceiro parâmetro da sql
						pstm.setDate(3, new Date(destino.getDataDoDestino().getTime()));
			
						pstm.setInt(5, destino.getId());

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

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino.setId(rset.getInt("id"));

				// Recupera o estado do banco e atribui ele ao objeto
				destino.setEstado(rset.getString("estado"));

				// Recupera a cidade do banco e atribui ele ao objeto
				destino.setCidade(rset.getString("cidade"));
				
				// Recupera a data do banco e atribui ela ao objeto
				destino.setDataDoDestino(rset.getDate("dataDoDestino"));

				// Adiciono o destino recuperado, a lista de destinos
				destinos.add(destino);
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

		return destinos;
	}


	public Destino getCompraById(int id) {

		String sql = "SELECT * FROM destino where id = ?";
		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			destino.setEstado(rset.getString("estado"));
			destino.setCidade(rset.getString("cidade"));
			destino.setDataDoDestino(rset.getDate("dataDoDestino"));

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
		return destino;
	}

	public Destino getDestinoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

