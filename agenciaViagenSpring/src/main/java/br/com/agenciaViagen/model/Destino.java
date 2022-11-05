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
public class Destino {

	
	
	public Destino(int id, String estado, String cidade, Date dataDoDestino, Instant now) {
		
	}
	@Id
	private int id;
	private String estado;
	private String cidade;
	private Date dataDoDestino;
	
	
	
}
