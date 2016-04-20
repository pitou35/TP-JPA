package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;



@Entity
@XmlRootElement
public class Heater extends SmartDevice{

	
	
	private Home home;
	
	public Heater(){}
	
	public Heater(Home home) {
		super();
		this.home = home;
	}

	
	
	
	@ManyToOne
	@JsonIgnore
	@XmlTransient
	public Home getHome(){
		return home;
	}
	
	public void setHome(Home home){
		this.home=home;
	}
	
}
