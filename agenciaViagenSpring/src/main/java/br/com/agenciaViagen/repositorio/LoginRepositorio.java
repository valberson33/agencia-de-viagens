package br.com.agenciaViagen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenciaViagen.model.Login;


public interface LoginRepositorio extends JpaRepository<Login, Long>{

}