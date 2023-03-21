package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
