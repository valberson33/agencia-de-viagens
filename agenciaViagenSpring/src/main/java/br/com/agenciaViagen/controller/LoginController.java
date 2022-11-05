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

	import br.com.agenciaViagen.model.Login;
	import br.com.agenciaViagen.repositorio.LoginRepositorio;


	@RestController
	@RequestMapping("/Login")
	
public class LoginController {
		
		 @Autowired
		    private LoginRepositorio loginRepositorio;

		    @GetMapping
		    public List<Login> listar() {
		        return loginRepositorio.findAll();
		    }

		    @PostMapping
		    public void incluir(@RequestBody Login login) {
		        loginRepositorio.save(login);
		    }

		    @PutMapping
		    public void alterar(@RequestBody Login login){
		        loginRepositorio.save(login);
		    }

		    @DeleteMapping("/{idLogin}")
		    public void deletar1(@PathVariable Long id){
		        loginRepositorio.deleteById(id);
		    }

		    @GetMapping("/{adiministrador}")
		    public Optional<Login> ler1(@PathVariable Long adiministrador){
		        return loginRepositorio.findById(adiministrador);
		    }

		    @DeleteMapping("/{comum}")
		    public void deletar2(@PathVariable Long comum){
		        loginRepositorio.deleteById(comum);
		    }

		    @GetMapping("/{dataDLogin}")
		    public Optional<Login> ler2(@PathVariable Long dataDoLogin){
		        return loginRepositorio.findById(dataDoLogin);
		    


		    } 
	}

