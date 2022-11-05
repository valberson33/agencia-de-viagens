package br.com.agenciaViagen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenciaViagen.model.Promocao;


public interface PromocaoRepositorio extends JpaRepository<Promocao, Long>{

}