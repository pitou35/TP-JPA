package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import domain.ElectronicDevices;
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
    	
    	
    	
    	List<Person> persons =jpa.ListOfPersonne();
    	
    	
    	String res=new String();
   
    	
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
	
	@GET
    @Path("/dataPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getListPerson() {
    	
    	List<Person> persons =jpa.ListOfPersonne();
	    return persons;
    }
	
	@POST
    @Path("/person")
    @Produces(MediaType.TEXT_HTML)
    public Response addPerson(@FormParam("name") String name ) throws URISyntaxException {
    	
    	jpa.AddPerson(name, new ArrayList<Home>(), new ArrayList<ElectronicDevices>(),  new ArrayList<Person>());
    	URI targetURIForRedirection = new URI("/opower/data");
    	
    	return Response.seeOther(targetURIForRedirection).build();	
	    
	  
    }
	
	@POST
    @Path("/personJSON")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON) 
    public Response addPersonJSON(String json ) throws URISyntaxException {
    	
    	try {
			JSONObject obj = new JSONObject(json); 
			String name= obj.getString("name"); 
			
	    	jpa.AddPerson(name, new ArrayList<Home>(), new ArrayList<ElectronicDevices>(),  new ArrayList<Person>());
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
    	URI targetURIForRedirection = new URI("/opower/data");
    	return Response.seeOther(targetURIForRedirection).build();	
	    
	  
    }
    

}
