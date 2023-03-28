package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.TuristickaAgencija;

public interface TuristickaAgencijaRepository extends JpaRepository<TuristickaAgencija, Long> {
	
	List<TuristickaAgencija> findByNazivContainingIgnoreCase(String naziv);

}
