package fr.isen.ticketapp.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import fr.isen.ticketapp.interfaces.models.UserModel;
import fr.isen.ticketapp.interfaces.services.Userservice;
import jakarta.inject.Inject;

@Path("/users") // Définition de l'endpoint principal
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private Userservice userservice;

    @GET
    public List<UserModel> getAllUsers() {
        return userservice.getAllUser();
    }

    @POST
    public UserModel addUser(UserModel userModel) {
        return userservice.addUser(userModel);
    }

    @PUT
    public void updateUser(UserModel userModel) {
        userservice.updateUser(userModel);
    }

    @DELETE
    @Path("/{id}")
    public void removeUser(@PathParam("id") int id) {
        userservice.removeUser(id);
    }

    @GET
    @Path("/{id}")
    public UserModel getOneUser(@PathParam("id") int id) {
        return userservice.getOneUser(id);
    }
}
