package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@NamedQuery(name="Person.findAll", query="Select p from Person p")
@Entity
@XmlRootElement
public class Person {
	
	private int id;

	private String nom;
	
	private String prenom;
	
	private String email;
	
	private List<ElectronicDevices> devices=new ArrayList<ElectronicDevices>();
	
	private List<Home> maisons=new ArrayList<Home>();
	
	private List<Person> amis;
	
	public Person() {
		super();
	}
	
	public Person(int id, String nom, String prenom, String email, List<Home> maisons, List<ElectronicDevices> devices, List<Person> amis) {
		super();
		this.id = id;
		this.nom = nom;
		this.maisons = maisons;
		this.devices = devices;
		this.amis = amis;
	}

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Id
    @GeneratedValue
    public int getId() {
		return id;
	}
	
    public void setId(int id) {
		this.id = id;
	}
	
    @OneToMany(mappedBy="personne", cascade=CascadeType.PERSIST)
    @JsonIgnore
	@XmlTransient
    public List<Home> getMaisons(){
    	return maisons;
    }
    
    public void setMaisons(List<Home> maisons){
    	this.maisons=maisons;
    }
    
    /*
    public void addMaisons(Home maison){
    	maisons.add(maison);
    	maison.setOwner(this);
    }
    
    public void removeMaisons(Home maison){
    	maisons.remove(maison);
    }
    */
    
    @OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST)
	@JsonIgnore
	@XmlTransient
    public List<ElectronicDevices> getElect() {
		return devices;
	}

	public void setElect(List<ElectronicDevices> devices) {
		devices = devices;
	}

	/*
	public void addElec(ElectronicDevices elec){
    	Elect.add(elec);
    }
    
    public void removeElec(ElectronicDevices elec){
    	Elect.remove(elec);
    }
	
	*/
	
	/*
	@Override
	public String toString() {
		return "personne [id=" + Id + ", name=" + nom + ", prenom="+ prenom + ", email="+email+"]";
	}
	*/
	
	@JoinTable(name = "amis", joinColumns = { @JoinColumn(name = "friend", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
	@JoinColumn(name = "friendof", referencedColumnName = "id", nullable = false)})
	@ManyToMany
	@JsonIgnore
	@XmlTransient
	public List<Person> getAmis() {
		return amis;
	}
	
	public void setAmis(List<Person> amis) {
		this.amis = amis;
	}
	
	
    
}
