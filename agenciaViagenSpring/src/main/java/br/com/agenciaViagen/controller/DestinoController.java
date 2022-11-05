package br.com.agenciaViagen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenciaViagen.model.Destino;
import br.com.agenciaViagen.repositorio.DestinoRepositorio;



	

	@RestController
	@RequestMapping("/Destino")
		public class DestinoController {
		 @Autowired
		    private DestinoRepositorio destinoRepositorio;

		    @GetMapping
		    public List<Destino> listar() {
		        return destinoRepositorio.findAll();
		    }

		    @PostMapping
		    public void incluir(@RequestBody Destino Destino) {
		       destinoRepositorio.save(Destino);
		    }

		    @PutMapping
		    public void alterar(@RequestBody Destino destino){
		        destinoRepositorio.save(destino);
		    }

		    @DeleteMapping("/{idDestino}")
		    public void deletar1(@PathVariable Long id){
		        destinoRepositorio.deleteById(id);
		    }

		    @GetMapping("/{cidade}")
		    public Optional<Destino> ler1(@PathVariable Long cidade){
		        return destinoRepositorio.findById(cidade);
		    }

		    @DeleteMapping("/{estado}")
		    public void deletar2(@PathVariable Long estado){
		        destinoRepositorio.deleteById(estado);
		    }

		    @GetMapping("/{dataDestino}")
		    public Optional<Destino> ler2(@PathVariable Long dataDestino){
		        return destinoRepositorio.findById(dataDestino);
		    


		    } 
	}



