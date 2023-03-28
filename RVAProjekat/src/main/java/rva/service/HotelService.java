package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Destinacija;
import rva.model.Hotel;
import rva.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repo;
	
	
	public List<Hotel> getAll(){
		return repo.findAll();
	}
	
	public Optional<Hotel> findById(long id) {
		return repo.findById(id);
	}
	
	public Optional<List<Hotel>> getByBrojZvezdicaGreaterThan (int brojZvezdica) {
		return Optional.of(repo.findByBrojZvezdicaGreaterThanOrderById(brojZvezdica));
	}
	
	public Optional<List<Hotel>> getByDestinacija(Destinacija destinacija){
		return Optional.of(repo.findByDestinacija(destinacija));
	}
	
	public Hotel save(Hotel hotel) {
		return repo.save(hotel);
	}
	
	public boolean existsById(long id) {
		if(findById(id).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteById (long id) {
		repo.deleteById(id);
	}

}
