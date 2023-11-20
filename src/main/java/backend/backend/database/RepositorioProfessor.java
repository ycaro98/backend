package backend.backend.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import backend.backend.entidade.Professor;

public interface RepositorioProfessor extends JpaRepository<Professor, Long> {
	 
		@Query(value="select u from Professor u where upper(trim(u.nome)) like %?1%")
		List<Professor> buscarPorNome(String nome);

}