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

import backend.backend.database.RepositorioProfessor;
import backend.backend.entidade.Professor;

@RestController
@RequestMapping("/professor")
public class ProfessorREST {

	@Autowired
	private RepositorioProfessor repositorio;
	
	@GetMapping
	public List<Professor> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Professor professor) {
		repositorio.save(professor);
	}
	
	@PutMapping
	public void alterar(@RequestBody Professor professor) {
		if(professor.getId() > 0)
		repositorio.save(professor);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(@RequestParam Long id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping(value = "buscarporid")
	public Professor buscarPorId(@RequestParam(name="idprofessor") Long idprofessor){
		return repositorio.findById(idprofessor).get();
	}
	
	@GetMapping(value = "buscarpornome")
	public List<Professor> buscarPorNome(@RequestParam(name="nome") String nome){
		return repositorio.buscarPorNome(nome);
	}

}