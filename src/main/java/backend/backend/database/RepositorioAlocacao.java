package backend.backend.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import backend.backend.entidade.Alocacao;

public interface RepositorioAlocacao extends JpaRepository<Alocacao, Long> {
	 
		@Query(value = "select u from Alocacao u where u.ano = ?1")
		List<Alocacao> buscarPorAno(Integer ano);

}