package br.com.agenciaViagen.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Compra {

	
	public Compra(int id, int boleto, int cartao, int avista, Date dataDaCompra, Instant now) {
		
	}
@Id
	private int id;
	private int boleto;
	private int cartao;
	private int avista;
	private Date dataDaCompra;
	
}
