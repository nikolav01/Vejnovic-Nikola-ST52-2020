package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Turisticka_agencija;

public interface TuristickaAgencijaRepository extends JpaRepository<Turisticka_agencija, Long> {
	
	List<Turisticka_agencija> findByNazivContainingIgnoreCase(String naziv);

}
