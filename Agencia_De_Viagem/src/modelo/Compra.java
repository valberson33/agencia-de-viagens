package modelo;

import java.util.Date;

public class Compra {

	private int id;
	private int boleto;
	private int cartao;
	private int avista;
	private Date dataDaCompra;
	
	public Compra() {
		super();
	}

	public Compra(int id, int boleto, int cartao, int avista, Date dataDaCompra) {
		super();
		this.id = id;
		this.boleto = boleto;
		this.cartao = cartao;
		this.avista = avista;
		this.dataDaCompra = dataDaCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoleto() {
		return boleto;
	}

	public void setBoleto(int boleto) {
		this.boleto = boleto;
	}

	public int getCartao() {
		return cartao;
	}

	public void setCartao(int cartao) {
		this.cartao = cartao;
	}

	public int getAvista() {
		return avista;
	}

	public void setAvista(int avista) {
		this.avista = avista;
	}

	public Date getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(Date dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", boleto=" + boleto + ", cartao=" + cartao + ", avita=" + avista + ", dataDaCompra="
				+ dataDaCompra + "]";
	}

	
	
}
