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
public class Cliente {
@Id
	private int id;
	private String nome;
	private int cpf;
	private int endereco;
	private Date dataDoCliente;
	

	public Cliente(int id, String nome, int cpf, int endereco, Date dataDoCliente, Instant now) {
		
	}
	
}
