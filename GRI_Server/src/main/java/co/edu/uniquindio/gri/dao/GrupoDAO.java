package co.edu.uniquindio.gri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.gri.model.Grupo;
import co.edu.uniquindio.gri.repository.GrupoRepository;

/**
 * Class GrupoDAO.
 */
@Service
public class GrupoDAO {

	/** Repository para grupos. */
	@Autowired
	GrupoRepository grupoRepository;
	
	/**
	 * Obtiene todos los grupos de investigación.
	 *
	 * @return lista con todos los grupos de investigación
	 */
	public List<Grupo> findAll(){
		return grupoRepository.findAll();
	}
	
	/**
	 * Obtiene un grupo de investigación especificado por un id.
	 *
	 * @param grupoId el id del grupo de investigación
	 * @return el grupo de investigación por el id
	 */
	public Grupo findOne(Long grupoId) {
		return grupoRepository.findOne(grupoId);
	}
	
	/**
	 * Obtiene los grupos pertenecientes a un programa específico.
	 *
	 * @param programaId el id del programa
	 * @return los grupos del programa
	 */
	public List<Grupo> getGruposPrograma(Long programaId){
		return grupoRepository.getGruposPrograma(programaId);
	}
	
	/**
	 * Obtiene los grupos pertenecientes a un centro específico.
	 *
	 * @param centroId el id del centro
	 * @return los grupos del centro
	 */
	public List<Grupo> getGruposCentro(Long centroId){
		return grupoRepository.getGruposCentro(centroId);
	}
}
