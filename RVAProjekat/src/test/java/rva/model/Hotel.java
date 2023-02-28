package rva.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Hotel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @SequenceGenerator(name = "HOTEL_ID_GENERATOR", sequenceName = "HOTEL_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_ID_GENERATOR")
    private long id;
	private String naziv;
	private boolean placeno;
	private Date datum_realizacije;
	
	
	@ManyToOne
	@JoinColumn(name = "destinacija")
	private Destinacija destinacija;
	
	@OneToMany(mappedBy = "hotel")
	private List <Aranzman> aranzman; 
	
	public Hotel() {
		
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
