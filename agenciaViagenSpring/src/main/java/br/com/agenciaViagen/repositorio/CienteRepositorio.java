package br.com.agenciaViagen.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenciaViagen.model.Cliente;


public interface CienteRepositorio extends JpaRepository<Cliente, Long>{

}
