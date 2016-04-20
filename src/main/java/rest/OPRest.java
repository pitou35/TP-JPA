package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;
import jpa.Opower;

@Path("/test-opower")
public class OPRest {
	
	private Opower jpa= new Opower();
	
	@GET
    @Path("/data")
    @Produces(MediaType.TEXT_HTML)
	public String getList() {
    	
    	//Récuperer liste des heaters,homes,persons,devices
    	
    	List<Person> persons =jpa.ListOfPersonne();
    	
    	
    	String res=new String();
   
    	//Affichage d'un contenu html qui affiche toute les données)
    	res+="<HTML>\n<BODY>\n <H1>Affichage informations</H1>\n";
	    
	    for (Person p: persons){
	    	  res+=("<h2>"+p.getNom()+"</h2>\n");
	    	  res+=("<h3>amis</h3>\n");
	    	  for (Person a: p.getAmis()){
	    		  res+=("<p>Amis: "+a.getNom()+"</p>\n");
	    	  }
	    	  res+=("<p>----------</p>\n");
	    	  
	    }
	    
	    res+=("</BODY></HTML>");
	    return res;
   
    }

}
