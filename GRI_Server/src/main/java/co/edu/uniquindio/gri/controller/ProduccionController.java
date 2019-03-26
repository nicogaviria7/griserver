package co.edu.uniquindio.gri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.gri.dao.ProduccionDAO;

@RestController
@RequestMapping("/rest/service")
public class ProduccionController { 

	@Autowired
	ProduccionDAO produccionDAO;
	
	@GetMapping("/producciones/{type}/{id}/{tipo}")
	public List getProducciones(@PathVariable("type") String type, @PathVariable("id") Long entityId,@PathVariable("tipo") Long tipoId) {
		return produccionDAO.getProducciones(type, entityId, tipoId);
	}
}
