package modelo;

import java.util.Date;

public class Login {

	private int id;
	private String administrativo;
	private String comum;
	private Date dataDoLogin;
	
	public Login() {
		super();
	}

	public Login(int id, String administrativo, String comum, Date dataDoLogin) {
		super();
		this.id = id;
		this.administrativo = administrativo;
		this.comum = comum;
		this.dataDoLogin = dataDoLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(String administrativo) {
		this.administrativo = administrativo;
	}

	public String getComum() {
		return comum;
	}

	public void setComum(String comum) {
		this.comum = comum;
	}

	public Date getDataDoLogin() {
		return dataDoLogin;
	}

	public void setDataDoLogin(Date dataDoLogin) {
		this.dataDoLogin = dataDoLogin;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", administrativo=" + administrativo + ", comum=" + comum + ", dataDoLogin="
				+ dataDoLogin + "]";
	}
	
	
}
