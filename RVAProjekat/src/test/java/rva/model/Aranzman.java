package rva.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Aranzman implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @SequenceGenerator(name = "ARANZMAN_ID_GENERATOR", sequenceName = "ARANZMAN_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARANZMAN_ID_GENERATOR")

	private long id;
	private double ukupna_cena;
	private  boolean placeno;
	private Date  datum_realizacije;
	
	@ManyToOne
	@JoinColumn(name = "hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "agencija")
	private Turisticka_agencija agencija;
	
	
	public Aranzman() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getUkupna_cena() {
		return ukupna_cena;
	}


	public void setUkupna_cena(double ukupna_cena) {
		this.ukupna_cena = ukupna_cena;
	}


	public boolean isPlaceno() {
		return placeno;
	}


	public void setPlaceno(boolean placeno) {
		this.placeno = placeno;
	}


	public Date getDatum_realizacije() {
		return datum_realizacije;
	}


	public void setDatum_realizacije(Date datum_realizacije) {
		this.datum_realizacije = datum_realizacije;
	}
	
	
	

}
