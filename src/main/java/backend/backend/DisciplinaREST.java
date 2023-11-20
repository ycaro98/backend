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

import backend.backend.database.RepositorioDisciplina;
import backend.backend.entidade.Disciplina;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaREST {
	
	@Autowired
	private RepositorioDisciplina repositorio;
	
	@GetMapping
	public List<Disciplina> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Disciplina disciplina) {
		repositorio.save(disciplina);
	}
	
	@PutMapping
	public void alterar(@RequestBody Disciplina disciplina) {
		if(disciplina.getId() > 0)
		repositorio.save(disciplina);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(@RequestParam Long id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping(value = "buscarporid")
	public Disciplina buscarPorId(@RequestParam(name="iddisciplina") Long iddisciplina){
		return repositorio.findById(iddisciplina).get();
	}
	
	@GetMapping(value = "buscarpornomedisciplina")
	public List<Disciplina> buscarPorNomeDisciplina(@RequestParam(name="nomeDisciplina") String nomeDisciplina){
		return repositorio.buscarPorNomeDisciplina(nomeDisciplina);
	}

}

