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
public class Login {
	
	public Login(int id, String administrativo, String comum, Date dataDoLogin, Instant now) {
		
	}
	@Id
	private int id;
	private String administrativo;
	private String comum;
	private Date dataDoLogin;
	
	
}
