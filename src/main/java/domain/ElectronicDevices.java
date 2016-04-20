package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ElectronicDevices extends SmartDevice{
 
	private Person personne;

	
	public ElectronicDevices(Person p) {
		super();
		this.personne =p;
	}

	
	public ElectronicDevices() {
		super();
	}
	
	@ManyToOne
	public Person getPersonne() {
		return personne;
	}

	public void setPersonne(Person personne) {
		this.personne = personne;
	}
}
