package modelo;

import java.util.Date;

public class Destino {

	private int id;
	private String estado;
	private String cidade;
	private Date dataDoDestino;
	
	public Destino() {
		super();
	}

	public Destino(int id, String estado, String cidade, Date dataDoDestino) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.dataDoDestino = dataDoDestino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataDoDestino() {
		return dataDoDestino;
	}

	public void setDataDoDestino(Date dataDoDestino) {
		this.dataDoDestino = dataDoDestino;
	}

	@Override
	public String toString() {
		return "Destino [id=" + id + ", estado=" + estado + ", cidade=" + cidade + ", dataDoDestino=" + dataDoDestino + "]";
	}
	
	
	
	
}
