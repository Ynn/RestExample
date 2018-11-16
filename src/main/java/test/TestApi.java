package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

public class TestApi {

    //TODO : Adapter l'URL en fonction de votre resource :
    public static final String URL = "http://localhost:8080/RestExample/rest";

    @XmlRootElement(name="message")
    public static class SomeMessage{
        public String name;
        public String greetings;
    }

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        System.setProperty("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
       
        //Get all the messages
        String mes = client.target(URL).path("hello/test").request(MediaType.APPLICATION_XML_TYPE).get(String.class);
        System.out.println(mes);
        
        SomeMessage mess = client.target(URL).path("hello/test").request(MediaType.APPLICATION_XML_TYPE).get(SomeMessage.class);
        System.out.println(mess.name);
         
    }
}