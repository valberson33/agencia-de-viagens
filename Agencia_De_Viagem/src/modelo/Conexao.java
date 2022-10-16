package modelo;

import java.sql.Connection;
import java.sql.DriverManager;


	public class Conexao {



		private static final String USUARIO = "root";

		private static final String SENHA ="valberson";

		private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/agencia";

		



		   public static Connection createConnectionMySQL() throws Exception {
		        // Faz com que a classe seja carregada pela JVM
		        Class.forName("com.mysql.cj.jdbc.Driver");



		       // Cria conexão com banco de dados ---------- com senha
		        Connection connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA);



		       return connection;
		    }



		   public static void main(String[] args) throws Exception {
		        // Recupera uma conexão com o banco de dados
		        Connection con = createConnectionMySQL();



		       // testar a conexão
		        if (con != null) {
		            System.out.println(con + "\n\n ****  Conexão obtida com sucesso!  ****");
		            con.close();
		        }
		   }
		   
	


	public static Connection creteConnectionToMysql() {
		// TODO Auto-generated method stub
		return null;
	}



	public static Connection creteConnectionToMySQL() {
		// TODO Auto-generated method stub
		return null;
	}
	}


