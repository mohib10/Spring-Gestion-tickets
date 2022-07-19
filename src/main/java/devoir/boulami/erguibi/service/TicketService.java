package devoir.boulami.erguibi.service;

import java.util.List;

import devoir.boulami.erguibi.models.*;

public interface TicketService {
	

	void ajouter(Ticket ticket);
	
	void supprimer(int idTic);

	void modifier(Ticket ticket);

	Ticket getTicket(int idTic);
	
	List<Ticket> getTickets();
	
	List<Bug> getBugs();
	
	void changeStatue(int idTicket);

}
