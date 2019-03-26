package co.edu.uniquindio.gri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.gri.dao.InvestigadorDAO;
import co.edu.uniquindio.gri.model.Investigador;

@RestController
@RequestMapping("/rest/service")
public class InvestigadorController {

	@Autowired
	InvestigadorDAO investigadorDAO;
	
	@GetMapping("/investigadores")
	public List<Investigador> getAllInvestigadores(){
		return investigadorDAO.findAll();
	}
	
	@GetMapping("/investigadores/{id}")
	public ResponseEntity<Investigador> getInvestigadorById(@PathVariable(value="id") Long invId){
		
		Investigador inv=investigadorDAO.findOne(invId);
		
		if(inv==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(inv);
		
	}
	
	@GetMapping("/integrantes/{type}/{id}")
	public List<Investigador> getIntegrantes(@PathVariable(value="type") String tipo, @PathVariable(value="id") Long id){	
		return investigadorDAO.getIntegrantes(tipo, id);
	}
	
}
