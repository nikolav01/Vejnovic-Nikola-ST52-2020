package rva.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import rva.model.Destinacija;
import rva.repository.DestinacijaRepository;

public class DestinacijaService {
	
	@Autowired
	private DestinacijaRepository repo;
	
	public Optional<Destinacija> getById(long id){
		return repo.findById(id);
	}

}
