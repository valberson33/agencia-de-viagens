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
public class Promocao {
	

public Promocao(int id, String soIda, String idaVolta, Date dataDaPromocao,Instant now) {
		
	}
@Id
	private int id;
	private String soIda;
	private String idaVolta;
	private Date dataDaPromocao;
	
}
