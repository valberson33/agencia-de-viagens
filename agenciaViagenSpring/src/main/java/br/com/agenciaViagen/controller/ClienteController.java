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

import br.com.agenciaViagen.model.Cliente;
import br.com.agenciaViagen.repositorio.CienteRepositorio;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	 @Autowired
	    private CienteRepositorio clienteRepositorio;

	    @GetMapping
	    public List<Cliente> listar() {
	        return clienteRepositorio.findAll();
	    }

	    @PostMapping
	    public void incluir(@RequestBody Cliente cliente) {
	        clienteRepositorio.save(cliente);
	    }

	    @PutMapping
	    public void alterar(@RequestBody Cliente cliente){
	        clienteRepositorio.save(cliente);
	    }

	    @DeleteMapping("/{idCliente}")
	    public void deletar1(@PathVariable Long id){
	        clienteRepositorio.deleteById(id);
	    }

	    @GetMapping("/{nome}")
	    public Optional<Cliente> ler1(@PathVariable Long nome){
	        return clienteRepositorio.findById(nome);
	    }

	    @DeleteMapping("/{cpf}")
	    public void deletar2(@PathVariable Long cpf){
	        clienteRepositorio.deleteById(cpf);
	    }
	    @GetMapping("/{endereco}")
	    public Optional<Cliente> ler2(@PathVariable Long endereco){
	        return clienteRepositorio.findById(endereco);
	    }
	    
	    @GetMapping("/{dataDaCompra}")
	    public Optional<Cliente> ler3(@PathVariable Long dataDaCompra){
	        return clienteRepositorio.findById(dataDaCompra);
	    


	    } 
}

