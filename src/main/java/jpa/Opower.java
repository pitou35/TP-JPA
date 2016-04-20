package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import domain.ElectronicDevices;
import domain.Home;
import domain.Person;

public class Opower{
	
	EntityTransaction tx;
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	private static final ThreadLocal<EntityManager> tl = new ThreadLocal<EntityManager>();

	    public static EntityManager getEntityManager() {
	        EntityManager em = tl.get();

	        if (em == null) {
	            em = factory.createEntityManager();
	            tl.set(em);
	        }
	        return em;
	    }
	    
	    //permet de lister les individus, même code pour toutes les autres entités (home...)
	    public List<Person> ListOfPersonne(){
			CriteriaBuilder criteriaBuilder = Opower.getEntityManager().getCriteriaBuilder(); 
			CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
			Root<Person> personne = query.from(Person.class);
			query.select(personne);
			TypedQuery<Person> request = Opower.getEntityManager().createQuery(query);
			
			return (List<Person>)request.getResultList();
		}
	    
	    //permet d'ajouter une personne, même code pour les autres entités
	    public void AddPerson(String nom,ArrayList<Home> homes,ArrayList<ElectronicDevices> devices,ArrayList<Person> amis){
	    	Opower.getEntityManager().getTransaction().begin();
			Person p= new Person();
			p.setNom(nom);
			p.setElect(devices);
			p.setAmis(amis);
			p.setMaisons(homes);	
			Opower.getEntityManager().persist(p);
			Opower.getEntityManager().getTransaction().commit();
		}
}