package devoir.boulami.erguibi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import devoir.boulami.erguibi.models.*;
import devoir.boulami.erguibi.repositories.*;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	BugRepository bugRepo;
	
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void ajouter(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void supprimer(int iduser) {
		userRepo.deleteById(iduser);
	}

	@Override
	public void modifier(User user) {
		User u = userRepo.getById(user.getId());
		if (u != null)
		userRepo.save(u);
	}

	@Override
	public User getUser(int idUser) {
		if(userRepo.existsById(idUser))
			return userRepo.getById(idUser);
		else
			return null;
	}

	@Override
	public List<Bug> getBugs() {
		return bugRepo.getBugsNA(false);
	}

	
	@Override
	public List<Ticket> getTickets(int idUser) {
		return ticketRepo.getByUser(idUser);
	}
	
	
	
	@Override
	public void affecter(int idBug, int idDev) {
		//Bug bug = bugRepo.getById(idBug);
		User dev = userRepo.getById(idDev);
		Ticket t = ticketRepo.getByBug(idBug);
		
		Ticket tic = new Ticket();
		tic.setDescription(t.getDescription());
		tic.setBug(t.getBug());
		tic.setNom(t.getNom());
		tic.setPriorite(t.getPriorite());
		tic.setStatue(t.getStatue());
		tic.setUser(dev);
		
		ticketRepo.save(tic);
	}

	

	@Override
	public Bug getBugById(int id) {
		return bugRepo.getById(id);
	}

	@Override
	public List<User> getDevs() {
		return userRepo.getDevs();
	}
	
	
	
	

}
