package co.edu.uniquindio.gri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.gri.model.Grupo;

/**
 * Interface GrupoRepository.
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	/**
	 * Obtiene los grupos pertenecientes a un programa específico.
	 *
	 * @param programaId el id del programa
	 * @return los grupos del programa
	 */
	@Query("FROM co.edu.uniquindio.gri.model.Grupo g join g.programas p where p.id = :id")
	List<Grupo> getGruposPrograma(@Param(value="id") Long programaId);
	
	/**
	 * Obtiene los grupos pertenecientes a un centro específico.
	 *
	 * @param centroId el id del centro
	 * @return los grupos del centro
	 */
	@Query("FROM co.edu.uniquindio.gri.model.Grupo g where g.centro.id = :id")
	List<Grupo> getGruposCentro(@Param(value="id") Long centroId);
}
