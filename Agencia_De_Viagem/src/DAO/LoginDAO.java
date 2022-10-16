package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Login;
import modelo.Conexao;

public class LoginDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Login login) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO login(administrativo,comum,,dataDoClogin)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, login.getAdministrativo());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, login.getComum());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(login.getDataDoLogin().getTime()));
		
			

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

		String sql = "DELETE FROM login WHERE id = ?";

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

	public void update(Login login) {

		String sql = "UPDATE login SET administrativo = ?, comum = ?,dataDoLogin = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
						pstm.setString(1, login.getAdministrativo());
						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(2, login.getComum());
						// Adiciona o valor do terceiro parâmetro da sql
						pstm.setDate(3, new Date(login.getDataDoLogin().getTime()));

			pstm.setInt(5, login.getId());

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

	public List<Login> getLogins() {

		String sql = "SELECT * FROM longin";

		List<Login> logins = new ArrayList<Login>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Login login = new Login();

				// Recupera o id do banco e atribui ele ao objeto
				login.setId(rset.getInt("id"));

				// Recupera o administrativo do banco e atribui ele ao objeto
				login.setAdministrativo(rset.getString("administrativo"));

				// Recupera a comum do banco e atribui ele ao objeto
				login.setComum(rset.getString("comum"));

				// Recupera a data do banco e atribui ela ao objeto
				login.setDataDoLogin(rset.getDate("dataDoLogin"));

				// Adiciono o contato recuperado, a lista de contatos
				logins.add(login);
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

		return logins;
	}


	public Login getLoginById(int id) {

		String sql = "SELECT * FROM login where id = ?";
		Login login = new Login();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			login.setAdministrativo(rset.getString("administrativo"));
			login.setComum(rset.getString("comum"));
			login.setDataDoLogin(rset.getDate("dataDoLogin"));

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
		return login;
	}
}

