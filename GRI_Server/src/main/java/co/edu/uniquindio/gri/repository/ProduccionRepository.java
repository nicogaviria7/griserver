package co.edu.uniquindio.gri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.gri.model.Produccion;
import co.edu.uniquindio.gri.model.ProduccionB;
import co.edu.uniquindio.gri.model.ProduccionBGrupo;
import co.edu.uniquindio.gri.model.ProduccionGrupo;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Long> {
	
	//Investigadores
	@Query("FROM co.edu.uniquindio.gri.model.ProduccionB where investigador.id =:entityId and tipo.id =:tipoId ")
	public List<ProduccionB> getProduccionB(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	@Query("FROM co.edu.uniquindio.gri.model.Produccion where investigador.id =:entityId and (tipo.id = 1 or tipo.id = 41 or tipo.id = 42 or tipo.id = 43)")
	public List<Produccion> getTrabajosDirigidos(@Param("entityId") Long entityId);
	
	@Query("FROM co.edu.uniquindio.gri.model.Produccion where investigador.id =:entityId and tipo.id =:tipoId")
	public List<Produccion> getProduccion(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	//Grupos
	@Query("FROM co.edu.uniquindio.gri.model.ProduccionBGrupo where grupo.id =:entityId and tipo.id =:tipoId ")
	public List<ProduccionBGrupo> getProduccionBGrupo(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	@Query("FROM co.edu.uniquindio.gri.model.ProduccionGrupo where grupo.id =:entityId and (tipo.id = 1 or tipo.id = 41 or tipo.id = 42 or tipo.id = 43)")
	public List<ProduccionGrupo> getTrabajosDirigidosGrupo(@Param("entityId") Long entityId);
	
	@Query("FROM co.edu.uniquindio.gri.model.ProduccionGrupo where grupo.id =:entityId and tipo.id =:tipoId")
	public List<ProduccionGrupo> getProduccionGrupo(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	//Programas	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionBGrupo(pb.id, pb.identificador, pb.autores, pb.anio, pb.referencia)  from co.edu.uniquindio.gri.model.ProduccionBGrupo pb join pb.grupo g join g.programas p  where p.id =:entityId  and pb.tipo.id =:tipoId")
	public List<ProduccionBGrupo> getProduccionBPrograma(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p where p.id =:entityId and (pr.tipo.id = 1 or pr.tipo.id = 41 or pr.tipo.id = 42 or pr.tipo.id = 43)")
	public List<ProduccionGrupo> getTrabajosDirigidosPrograma(@Param("entityId") Long entityId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p where p.id =:entityId and pr.tipo.id =:tipoId ")
	public List<ProduccionGrupo> getProduccionPrograma(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	//Centros
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionBGrupo(pb.id, pb.identificador, pb.autores, pb.anio, pb.referencia)  from co.edu.uniquindio.gri.model.ProduccionBGrupo pb join pb.grupo g join g.centro c where c.id =:entityId and pb.tipo.id =:tipoId")
	public List<ProduccionBGrupo> getProduccionBCentro(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.centro c where c.id =:entityId  and (pr.tipo.id = 1 or pr.tipo.id = 41 or pr.tipo.id = 42 or pr.tipo.id = 43)")
	public List<ProduccionGrupo> getTrabajosDirigidosCentro(@Param("entityId") Long entityId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.centro c where c.id = :entityId and pr.tipo.id = :tipoId")
	public List<ProduccionGrupo> getProduccionCentro(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	//Facultades
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionBGrupo(pb.id, pb.identificador, pb.autores, pb.anio, pb.referencia)  from co.edu.uniquindio.gri.model.ProduccionBGrupo pb join pb.grupo g join g.programas p join p.facultad f where f.id =:entityId  and pb.tipo.id =:tipoId ")
	public List<ProduccionBGrupo> getProduccionBFacultadPrograma(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);

	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionBGrupo(pb.id, pb.identificador, pb.autores, pb.anio, pb.referencia)  from co.edu.uniquindio.gri.model.ProduccionBGrupo pb join pb.grupo g join g.centro c join c.facultad f where f.id =:entityId  and pb.tipo.id =:tipoId ")
	public List<ProduccionBGrupo> getProduccionBFacultadCentro(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p join p.facultad f where f.id =:entityId  and (pr.tipo.id =  1 or pr.tipo.id = 41 or pr.tipo.id = 42 or pr.tipo.id = 43)")
	public List<ProduccionGrupo> getTrabajosDirigidosFacultadPrograma(@Param("entityId") Long entityId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p join p.facultad f where f.id =:entityId  and (pr.tipo.id =  1 or pr.tipo.id = 41 or pr.tipo.id = 42 or pr.tipo.id = 43)")
	public List<ProduccionGrupo> getTrabajosDirigidosFacultadCentro(@Param("entityId") Long entityId);
	
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p join p.facultad f where f.id =:entityId  and pr.tipo.id =:tipoId ")
	public List<ProduccionGrupo> getProduccionFacultadPrograma(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(pr.id, pr.autores, pr.anio, pr.referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr join pr.grupo g join g.programas p join p.facultad f where f.id =:entityId  and pr.tipo.id =:tipoId")
	public List<ProduccionGrupo> getProduccionFacultadCentro(@Param("entityId") Long entityId, @Param("tipoId") Long tipoId);
	
	//General
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionBGrupo(id, identificador, autores, anio, referencia)  from co.edu.uniquindio.gri.model.ProduccionBGrupo where tipo.id =:tipoId")
	public List<ProduccionBGrupo> getProduccionBGeneral(@Param("tipoId") Long tipoId);
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(id, autores, anio, referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo pr where tipo.id = 1 or tipo.id = 41 or tipo.id = 42 or tipo.id = 43")
	public List<ProduccionGrupo> getTrabajosDirigidosGeneral();
	
	@Query("SELECT NEW co.edu.uniquindio.gri.model.ProduccionGrupo(id, autores, anio, referencia)  from co.edu.uniquindio.gri.model.ProduccionGrupo where tipo.id = :tipoId")
	public List<ProduccionGrupo> getProduccionGeneral (@Param("tipoId") Long tipoId);
}
