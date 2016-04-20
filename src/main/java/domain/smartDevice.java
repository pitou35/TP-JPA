package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

public class smartDevice {
	
	@Entity
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	public class SmartDevice {

		private Long id; 
		
		private String nom; 
		
		private int conso; 

		public SmartDevice(Long id, String nom, int conso) {
			super();
			this.id = id;
			this.nom = nom;
			conso = conso;
		}

		
		public SmartDevice() {
			super();
		}
		
		
		@Id
	    @GeneratedValue
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getConso() {
			return conso;
		}

		public void setConso(int conso) {
			conso = conso;
		}
	}

}
