package fr.isen.ticketapp.interfaces.services;

import fr.isen.ticketapp.interfaces.models.TicketModel;

import java.util.ArrayList;
import java.util.List;

public class TicketserviceImpl implements Ticketservice {


    //private Map<UUID, TicketModel> ticketMap = new HashMap<>();

    private List<TicketModel> tickets = new ArrayList<>();

    @Override
    public List<TicketModel> getAllTicket() {
        return new ArrayList<>(tickets);
    }


    @Override
    public TicketModel addTicket(TicketModel ticketModel) {

        if (ticketModel != null) {
            // Assurez-vous que le ticket n'est pas null, et on peut potentiellement vérifier si les données sont valides
            tickets.add(ticketModel);  // Ajoute le ticket à la liste
            return ticketModel;  // Retourne le ticket ajouté
        }
        else return null;  // Retourne null si le ticket est invalide

    }


    @Override
    public void updateTicket(TicketModel ticketModel) {

        if (ticketModel != null) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getId() == ticketModel.getId()) {
                    tickets.set(i, ticketModel);
                    break;
                }
            }
        }

    }


    @Override
    public void removeTicket(int id) {
        tickets.removeIf(ticket -> ticket.getId() == id);
    }


    @Override
    public TicketModel getOneTicket(int id) {

        for (TicketModel ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;  // Retourne le ticket trouvé
            }
        }
        return null;

    }
}
