package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;

public class JpaTest {
	
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
				
			
			
			Home h1 = new Home();
			Home h2 = new Home();
			h1.setAdresse("rue du modeste");
			h2.setAdresse("rue du texas");
			
			
			Person p1= new Person();
			Person p2= new Person();
			p1.setNom("cohen");
			p1.setPrenom("patrick");
			p1.setEmail("cocoradio@jesaispas.fr");
			
			p2.setNom("bush");
			p2.setPrenom("georges");
			p2.setEmail("gag@dictacteur.mondomaine");
			
			
			Heater he1 = new Heater();
			Heater he2 = new Heater();
			
			
			he1.setNom("resistance de grille-pain");
			he1.setConso(3);
			he1.setHome(h1);
			manager.persist(he1);
			
			he2.setNom("centrale nucleaire");
			he2.setConso(999999999);
			he2.setHome(h2);
			manager.persist(he2);
			
			
			
			
			h1.setPersonne(p1);
			h1.getHeaters().add(he1); 
			manager.persist(h1);
			
			h2.setPersonne(p2);
			h2.getHeaters().add(he2);
			manager.persist(h2);
			
			
			
			ElectronicDevices ed1 = new ElectronicDevices();
			ElectronicDevices ed2 = new ElectronicDevices();
			
			
			ed1.setNom("nokia pourri");
			ed1.setConso(3);
			ed1.setPersonne(p1);
			manager.persist(ed1);
			
			ed2.setNom("compil iphono-samsungo 6S-G7");
			ed2.setConso(3000);
			ed2.setPersonne(p2);
			manager.persist(ed2);
			
			
			
			
			ArrayList<Home> homes= new ArrayList<Home>();
			ArrayList<ElectronicDevices> devices= new ArrayList<ElectronicDevices>();
			ArrayList<Person> amis= new ArrayList<Person>();
			
			homes.add(h1);
			devices.add(ed1);
			
			
			p1.setElect(devices);
			p1.setAmis(amis);
			p1.setMaisons(homes);
			manager.persist(p1);
			
			
			ArrayList<Home> homes2= new ArrayList<Home>();
			ArrayList<ElectronicDevices> devices2= new ArrayList<ElectronicDevices>();
			ArrayList<Person> amis2= new ArrayList<Person>();
			
			homes2.add(h2);
			
			devices2.add(ed2);
			
			amis2.add(p1);
			
			p2.setElect(devices2);
			p2.setAmis(amis2);
			p2.setMaisons(homes2);	
			manager.persist(p2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		
		
		
		
		manager.close();
		factory.close();
	}
	
	


	

}
