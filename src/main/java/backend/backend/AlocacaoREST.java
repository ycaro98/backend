package backend.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.database.RepositorioAlocacao;
import backend.backend.entidade.Alocacao;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoREST {

	@Autowired
	private RepositorioAlocacao repositorio;
	
	@GetMapping
	public List<Alocacao> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Alocacao alocacao) {
		repositorio.save(alocacao);
	}
	
	@PutMapping
	public void alterar(@RequestBody Alocacao alocacao) {
		if(alocacao.getId() > 0)
		repositorio.save(alocacao);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(@RequestParam Long id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping(value = "buscarporid")
	public Alocacao buscarPorId(@RequestParam(name="idalocacao") Long idalocacao){
		return repositorio.findById(idalocacao).get();
	}
	
	@GetMapping(value = "buscarporano")
	public List<Alocacao> buscarPorAno(@RequestParam(name="ano") Integer ano){
		return repositorio.buscarPorAno(ano);
	}

}
