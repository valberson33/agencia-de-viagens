package modelo;

import java.util.Date;

public class Promocao {

	private int id;
	private String soIda;
	private String idaVolta;
	private Date dataDaPromocao;
	
	public Promocao() {
		super();
	}

	public Promocao(int id, String soIda, String idaVolta, Date dataDaPromocao) {
		super();
		this.id = id;
		this.soIda = soIda;
		this.idaVolta = idaVolta;
		this.dataDaPromocao = dataDaPromocao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSoIda() {
		return soIda;
	}

	public void setSoIda(String soIda) {
		this.soIda = soIda;
	}

	public String getIdaVolta() {
		return idaVolta;
	}

	public void setIdaVolta(String idaVolta) {
		this.idaVolta = idaVolta;
	}

	public Date getDataDaPromocao() {
		return dataDaPromocao;
	}

	public void setDataDaPromocao(Date dataDaPromocao) {
		this.dataDaPromocao = dataDaPromocao;
	}

	@Override
	public String toString() {
		return "Promocao [id=" + id + ", soIda=" + soIda + ", idaVolta=" + idaVolta + ", dataDaPromocao="
				+ dataDaPromocao + "]";
	}
	
	
}
