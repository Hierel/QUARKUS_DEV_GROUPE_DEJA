package fr.isen.ticketapp.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import fr.isen.ticketapp.interfaces.models.DeviceModel;
import fr.isen.ticketapp.interfaces.services.Deviceservice;
import jakarta.inject.Inject;

@Path("/devices") // Définition de l'endpoint principal
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceResource {

    @Inject
    private Deviceservice deviceservice;

    @GET
    public List<DeviceModel> getAllDevices() {
        return deviceservice.getAllDevice();
    }

    @POST
    public DeviceModel addDevice(DeviceModel deviceModel) {
        return deviceservice.addDevice(deviceModel);
    }

    @PUT
    public void updateDevice(DeviceModel deviceModel) {
        deviceservice.updateDevice(deviceModel);
    }

    @DELETE
    @Path("/{id}")
    public void removeDevice(@PathParam("id") int id) {
        deviceservice.removeDevice(id);
    }

    @GET
    @Path("/{id}")
    public DeviceModel getOneDevice(@PathParam("id") int id) {
        return deviceservice.getOneDevice(id);
    }
}
