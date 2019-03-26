package co.edu.uniquindio.gri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.gri.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	@Query("FROM co.edu.uniquindio.gri.model.Grupo g join g.programas p where p.id = :id")
	List<Grupo> getGruposPrograma(@Param(value="id") Long programaId);
	
	@Query("FROM co.edu.uniquindio.gri.model.Grupo g where g.centro.id = :id")
	List<Grupo> getGruposCentro(@Param(value="id") Long centroId);
}
