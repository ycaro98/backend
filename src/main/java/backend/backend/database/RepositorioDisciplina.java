package backend.backend.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import backend.backend.entidade.Disciplina;

public interface RepositorioDisciplina extends JpaRepository<Disciplina, Long> {
	 
		@Query(value="select u from Disciplina u where upper(trim(u.nomeDisciplina)) like %?1%")
		List<Disciplina> buscarPorNomeDisciplina(String nomeDisciplina);

}

