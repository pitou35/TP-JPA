package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	private int id;

	private int taille;
	
	private int nbPieces;
	
	private Person personne;
	
	private String address;
	
	private List<Heater> heaters=new ArrayList<Heater>();
	
	public Home(){
		super();
	}
	
	public Home(int id, int taille, int nbPieces, String address, List<Heater> heaters){
		super();
		this.taille=taille;
		this.nbPieces=nbPieces;
		this.id=id;
		this.address=address;
		this.heaters=heaters;
	}
	
	public String getAdresse() {
		return address;
	}

	public void setAdresse(String address) {
		this.address = address;
	}

	
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
	
	@Id
    @GeneratedValue
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	public Person getPersonne(){
		return personne;
	}
	
	public void setPersonne(Person personne){
		this.personne=personne;
	}
	
	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public List<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}
	
    
    /*
    
    public void addChauffages(Heater heater){
    	chauffages.add(heater);
    }
    */
	
}
