package backend.backend.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CargaHoraria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer cargaHorariaTotal;
	private Integer disponibilidade;
	
			
	public CargaHoraria() {
		super();
	}

	public CargaHoraria(Long id, Integer cargaHorariaTotal, Integer disponibilidade) {
		super();
		this.id = id;
		this.cargaHorariaTotal = cargaHorariaTotal;
		this.disponibilidade = disponibilidade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	public Integer getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Integer disponibilidade) {
		this.disponibilidade = disponibilidade;
	}	

}
