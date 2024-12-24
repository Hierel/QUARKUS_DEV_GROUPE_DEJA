package fr.isen.ticketapp.resources;

import fr.isen.ticketapp.interfaces.models.TicketModel;
import fr.isen.ticketapp.interfaces.services.TicketserviceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tickets")  // Définit la route principale pour l'API
@Produces(MediaType.APPLICATION_JSON)  // Spécifie que les réponses seront au format JSON
@Consumes(MediaType.APPLICATION_JSON)  // Spécifie que les requêtes seront au format JSON
public class TicketResource {

    @Inject
    TicketserviceImpl ticketService;  // Injection du service d'implémentation

    // Route pour récupérer tous les tickets
    @GET
    public List<TicketModel> getAllTickets() {
        return ticketService.getAllTicket();
    }

    // Route pour ajouter un ticket
    @POST
    public Response addTicket(TicketModel ticketModel) {
        TicketModel createdTicket = ticketService.addTicket(ticketModel);
        return Response.status(Response.Status.CREATED).entity(createdTicket).build();
    }

    // Route pour mettre à jour un ticket
    @PUT
    public Response updateTicket(TicketModel ticketModel) {
        ticketService.updateTicket(ticketModel);
        return Response.ok().build();
    }

    // Route pour supprimer un ticket par ID
    @DELETE
    @Path("/{id}")
    public Response deleteTicket(@PathParam("id") int id) {
        ticketService.removeTicket(id);
        return Response.noContent().build();
    }

    // Route pour récupérer un ticket par ID
    @GET
    @Path("/{id}")
    public TicketModel getOneTicket(@PathParam("id") int id) {
        return ticketService.getOneTicket(id);
    }
}
