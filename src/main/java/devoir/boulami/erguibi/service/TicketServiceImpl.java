package devoir.boulami.erguibi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devoir.boulami.erguibi.models.Bug;
import devoir.boulami.erguibi.models.Ticket;
import devoir.boulami.erguibi.models.User;
import devoir.boulami.erguibi.repositories.*;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepo;
	@Autowired
	BugRepository bugRepo;
	
	@Override
	public void ajouter(Ticket ticket) {
		ticketRepo.save(ticket);		
	}

	@Override
	public void supprimer(int idTic) {
		ticketRepo.deleteById(idTic);
	}

	@Override
	public void modifier(Ticket ticket) {
		Ticket t = ticketRepo.getById(ticket.getId());
		if (t != null)
			ticketRepo.save(t);
	}

	@Override
	public Ticket getTicket(int idTic) {
		return ticketRepo.getById(idTic);
	}
	
	@Override
	public void changeStatue(int idTicket) {
		Ticket t= ticketRepo.getById(idTicket);
		
		if(t.getStatue().equals("new"))
			t.setStatue("en traitement");
		else if(t.getStatue().equals( "en traitement"))
			t.setStatue("résoulu");
		System.out.println(t.getId());
		ticketRepo.save(t);
	}

	@Override
	public List<Bug> getBugs() {
		
		return bugRepo.findAll();
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}

}
