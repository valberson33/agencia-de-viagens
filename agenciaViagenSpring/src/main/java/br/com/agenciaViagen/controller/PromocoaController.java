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

import br.com.agenciaViagen.model.Promocao;
import br.com.agenciaViagen.repositorio.PromocaoRepositorio;


	@RestController
	@RequestMapping("/promocao")
public class PromocoaController {

		
		 @Autowired
		    private PromocaoRepositorio promocaoRepositorio;

		    @GetMapping
		    public List<Promocao> listar() {
		        return promocaoRepositorio.findAll();
		    }

		    @PostMapping
		    public void incluir(@RequestBody Promocao promocao) {
		        promocaoRepositorio.save(promocao);
		    }

		    @PutMapping
		    public void alterar(@RequestBody Promocao promocao){
		        promocaoRepositorio.save(promocao);
		    }

		    @DeleteMapping("/{idPromocao}")
		    public void deletar1(@PathVariable Long id){
		        promocaoRepositorio.deleteById(id);
		    }

		    @GetMapping("/{idaVolta}")
		    public Optional<Promocao> ler1(@PathVariable Long idaVolta){
		        return promocaoRepositorio.findById(idaVolta);
		    }

		    @DeleteMapping("/{siIda}")
		    public void deletar2(@PathVariable Long soIda){
		        promocaoRepositorio.deleteById(soIda);
		    }

		    @GetMapping("/{dataDaCompra}")
		    public Optional<Promocao> ler2(@PathVariable Long dataDaCompra){
		        return promocaoRepositorio.findById(dataDaCompra);
		    


		    } 
	}


