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

import backend.backend.database.RepositorioCargaHoraria;
import backend.backend.entidade.CargaHoraria;

@RestController
@RequestMapping("/cargahoraria")
public class CargaHorariaREST {

	@Autowired
	private RepositorioCargaHoraria repositorio;
	
	@GetMapping
	public List<CargaHoraria> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody CargaHoraria cargahoraria) {
		repositorio.save(cargahoraria);
	}
	
	@PutMapping
	public void alterar(@RequestBody CargaHoraria cargahoraria) {
		if(cargahoraria.getId() > 0)
		repositorio.save(cargahoraria);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(@RequestParam Long id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping(value = "buscarporid")
	public CargaHoraria buscarPorId(@RequestParam(name="idcargahoraria") Long idcargahoraria){
		return repositorio.findById(idcargahoraria).get();
	}
	
	@GetMapping(value = "buscarpordisponibilidade")
	public List<CargaHoraria> buscarPorDisponibilidade(@RequestParam(name="disponibilidade") Integer disponibilidade){
		return repositorio.buscarPorDisponibilidade(disponibilidade);
	}

}
