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

import br.com.agenciaViagen.model.Compra;
import br.com.agenciaViagen.repositorio.CompraRepositorio;



	@RestController
	@RequestMapping("/compra")
		public class CompraController {
		 @Autowired
		    private CompraRepositorio compraRepositorio;

		    @GetMapping
		    public List<Compra> listar() {
		        return compraRepositorio.findAll();
		    }

		    @PostMapping
		    public void incluir(@RequestBody Compra compra) {
		       compraRepositorio.save(compra);
		    }

		    @PutMapping
		    public void alterar(@RequestBody Compra compra){
		        compraRepositorio.save(compra);
		    }

		    @DeleteMapping("/{idcompra}")
		    public void deletar1(@PathVariable Long id){
		        compraRepositorio.deleteById(id);
		    }

		    @GetMapping("/{avista}")
		    public Optional<Compra> ler1(@PathVariable Long avista){
		        return compraRepositorio.findById(avista);
		    }

		    @DeleteMapping("/{boleto}")
		    public void deletar2(@PathVariable Long boleto){
		       compraRepositorio.deleteById(boleto);
		    }

		    @GetMapping("/{cartao}")
		    public Optional<Compra> ler3(@PathVariable Long cartao){
		        return compraRepositorio.findById(cartao);
		    }
		    @GetMapping("/{dataDestino}")
		    public Optional<Compra> ler2(@PathVariable Long dataDestino){
		        return compraRepositorio.findById(dataDestino);
		    


		    } 
	}

	

