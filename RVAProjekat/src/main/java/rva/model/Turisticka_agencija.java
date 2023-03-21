package rva.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Turisticka_agencija implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "Turisticka_agencija_ID_GENERATOR", sequenceName = "Turisticka_agencija_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Turisticka_agencija_ID_GENERATOR")
	private long id;
    
	private String naziv;
	private String adresa;
	private String kontakt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agencija")
	private List <Aranzman> aranzman;  
	
	public  Turisticka_agencija() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
	
}
