package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import domain.smartDevice.SmartDevice;

@Entity
public class ElectronicDevices extends SmartDevice{
 
	private Person owner;

	
	public ElectronicDevices(Person p) {
		super();
		this.owner =p;
	}

	
	public ElectronicDevices() {
		super();
	}
	
	@ManyToOne
	public Person getPersonne() {
		return owner;
	}

	public void setPersonne(Person owner) {
		this.owner = owner;
	}
}
