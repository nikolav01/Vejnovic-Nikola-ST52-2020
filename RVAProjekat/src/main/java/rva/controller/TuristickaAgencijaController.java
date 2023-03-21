package rva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Turisticka_agencija;
import rva.service.TuristickaAgencijaService;

@RestController
public class TuristickaAgencijaController {
	
	@Autowired
	private TuristickaAgencijaService service;
	
	
	@GetMapping("/hello")
	public String sayHello( ) {
		return "Hello there!";
	}
	
	@GetMapping("/turistickaAgencija")
	public List<Turisticka_agencija> findAllTuristickaAgencija() {
		return service.findAll();
	}
	
	@GetMapping ("/turistickaAgencija/{id}")
	public ResponseEntity<?> getTuristicka_agencijaById( @PathVariable long id ) {
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id));
		
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resource with requested ID: " + id + " does not exist");
		}
	}
	
	
	@GetMapping("/turistickaAgencija/naziv/{naziv}")
	public ResponseEntity<?> getTuristicka_agencijaByNaziv(@PathVariable String Naziv) {
		if(service.findByNaziv(Naziv).get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resource with requested STRING: " + Naziv + " does not exist");
		} else {
			return ResponseEntity.ok(service.findByNaziv(Naziv).get());
		}
	}

}
