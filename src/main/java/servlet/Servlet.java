package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;
import jpa.Opower;


@WebServlet(name="opower",
urlPatterns={"/opower"})
public class Servlet extends HttpServlet{
	
	private Opower jpa;
	
	@Override
	public void init() throws ServletException {
		jpa= new Opower();
		super.init();
		
	}
	
	@Override
    public void destroy() {
    	super.destroy();
    }
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	
    	List<Person> persons =jpa.ListOfPersonne();
    	
    	
    	resp.setContentType("text/html");

    	PrintWriter out = resp.getWriter();
   
    	
	    out.println("<HTML>\n<BODY>\n <H1>Recapitulatif des informations</H1>\n");
	    
	    
	    out.println("Personnes\n");
	    for (Person p: persons){
	    	  out.println(""+p.getNom()+"\n");
	    	  
	    	  for (Person a: p.getAmis()){
	    		  out.println("<p>Amis: "+a.getNom()+"</p>\n");
	    	  }
	    	  out.println("<p>----------</p>\n");
	    	  
	    }
	    
	    out.println("</BODY></HTML>");
      
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	String name = req.getParameter("name"); 
    	
    	jpa.AddPerson(name, new ArrayList<Home>(), new ArrayList<ElectronicDevices>(),  new ArrayList<Person>());
      
    	
	    resp.sendRedirect("/opower");	    
    }
	
}