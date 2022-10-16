package modelo;

import java.util.Date;

public class Cliente {

	
	private int id;
	private String nome;
	private int cpf;
	private int endereco;
	private Date dataDoCliente;
	
	public Cliente() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public Date getDataDoCliente() {
		return dataDoCliente;
	}

	public void setDataDoCliente(Date dataDoCliente) {
		this.dataDoCliente = dataDoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", dataDoCliente="
				+ dataDoCliente + "]";
	}
	
	
	
	
}
