package rva.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Destinacija;
import rva.model.Hotel;
import rva.service.DestinacijaService;
import rva.service.HotelService;

@RestController
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	private HotelService service;
	private DestinacijaService destinacijaService;
	
	
	@GetMapping
	private ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.ok(service.getAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getHotelById(@PathVariable long id) {
		if(service.findById(id).isPresent()) {
			return ResponseEntity.ok(service.findById(id).get());
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested id: " + id + " has not been found");
		}
		
	}
	
	
	@GetMapping("/brojZvezdica/{brojZvezdica}")
	public ResponseEntity<?> getHotelByBrojZvezdicaGretaerThan(@PathVariable int brojZvezdica){
		Optional<List<Hotel>> lista = service.getByBrojZvezdicaGreaterThan(brojZvezdica);
		if(!lista.get().isEmpty()) {
			return ResponseEntity.ok(lista.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with brojZvezdica greater than : " + brojZvezdica + " has not been found");
		}
	}
	
	
	@GetMapping("/destinacija/{id}")
	public ResponseEntity<?> getDestinacijaByHotel(@PathVariable long id){
    Optional<Destinacija> destinacija = destinacijaService.getById(id);
		if(destinacija.isPresent()) {
			List<Hotel> lista = service.getByDestinacija(destinacija.get()).get();
			if(!lista.isEmpty()) {
				return ResponseEntity.ok(lista);
			}
    	} else { 
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested foreign key destinacija :"
    				+ " " + id + " does not exist");
    		
			
		}  {
			
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destinacija with ID: " + id + "does not exist");
		}
	}
		
		
	
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel savedHotel;
		if(!service.existsById(hotel.getId())) {
			savedHotel = service.save(hotel);
		} else {
			List<Hotel> lista = service.getAll();
			long najvecaVrednost = 1;
			for (int i = 0; i < lista.size(); i++) {
				if(najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}
				
				if(i == lista.size() - 1) {
					najvecaVrednost++;
				}
			}
			
			hotel.setId(najvecaVrednost);
			savedHotel = service.save(hotel);
		}
		
		URI uri = URI.create("/hotel" + savedHotel.getId());
		return ResponseEntity.created(uri).body(savedHotel);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel, @PathVariable long id) {
		if(service.existsById(id)) {
			hotel.setId(id);
			return ResponseEntity.ok(hotel);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID:" + id + "has not been found");
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with ID:" + id + "has been deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource witrh ID:" +  id + "has not been found");
		}
	}
	
	
	
	
	
	
	

}
