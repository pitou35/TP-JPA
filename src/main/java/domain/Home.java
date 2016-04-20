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
	
	private Person owner;
	
	private String address;
	
	private List<Heater> chauffages=new ArrayList<Heater>();
	
	public Home(){
		super();
	}
	
	public Home(int id, int taille, int nbPieces, String address, List<Heater> chauffages){
		super();
		this.taille=taille;
		this.nbPieces=nbPieces;
		this.id=id;
		this.address=address;
		this.chauffages=chauffages;
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
	public Person getOwner(){
		return owner;
	}
	
	public void setOwner(Person owner){
		this.owner=owner;
	}
	
	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Heater> getChauffages(){
    	return chauffages;
    }
    
    public void setChauffages(List<Heater> chauffages){
    	this.chauffages=chauffages;
    }
    
    /*
    
    public void addChauffages(Heater heater){
    	chauffages.add(heater);
    }
    */
	
}
