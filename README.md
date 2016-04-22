- Remplir la base (ici sous mysql):

lancer jpatest.java

- affichage récapitulatif de la BDD via tomcat:

http://localhost:8080/opower

- ajout d'une personne via formulaire HTML:

http://localhost:8080/addPerson.html


REST:
- liste JSON des personnes:
http://localhost:8080/rest/rest-opower/dataPerson

- ajout d'une personne, POST JSON:

{
  "nom":"test",
  "prenom":"test",
  "email":"test"
}

http://localhost:8080/rest/rest-opower/person
