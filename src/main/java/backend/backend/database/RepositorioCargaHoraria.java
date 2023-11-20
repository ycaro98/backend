package backend.backend.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import backend.backend.entidade.CargaHoraria;

public interface RepositorioCargaHoraria extends JpaRepository<CargaHoraria, Long> {
	 
    	@Query(value = "select u from CargaHoraria u where u.disponibilidade = ?1")
		List<CargaHoraria> buscarPorDisponibilidade(Integer disponibilidade);

	}