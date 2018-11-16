package fr.istic.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.chat.message.Message;
import fr.istic.chat.message.MessageList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("chat")
public class MessageResource {

	//En partant du principe que l'annotation Path sur la classe contient "messages"
	@Path("/after/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> getMessagesAfter(@PathParam("id") Long id){
	  System.out.println("message after" + id);
	  return MessageList.getInstance().getMessagesAfter(id);
	}
}
