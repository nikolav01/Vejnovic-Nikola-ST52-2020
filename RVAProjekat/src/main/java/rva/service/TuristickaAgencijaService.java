package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Turisticka_agencija;
import rva.repository.TuristickaAgencijaRepository;

@Service
public class TuristickaAgencijaService {
	
	@Autowired
	private TuristickaAgencijaRepository repo;
	
	public List<Turisticka_agencija> findAll() {
		
		return repo.findAll();
	}
	
	public Optional<Turisticka_agencija> findById(long id) {
		return repo.findById(id);
	}
	
	public Optional<List<Turisticka_agencija>> findByNaziv (String naziv) {
		Optional<List<Turisticka_agencija>> lista = Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
		return lista;
	}
	
	public Turisticka_agencija save (Turisticka_agencija turistickaAgencija) {
		return repo.save(turistickaAgencija);
	}
		
	public boolean existsById(long id) {
		if(findById(id).isPresent()) {
			return true;
		} else {
			return false;
		}
			
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}

}
