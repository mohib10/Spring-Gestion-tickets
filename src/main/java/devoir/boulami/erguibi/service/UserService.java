package devoir.boulami.erguibi.service;

import java.util.List;

import devoir.boulami.erguibi.models.*;

public interface UserService {
	
	List<User> getUsers();

	List<User> getDevs();

	void ajouter(User user);
	
	void supprimer(int iduser);

	void modifier(User user);

	User getUser(int idUser);
	
	List<Bug> getBugs();
	
	Bug getBugById(int id);
	
	List<Ticket> getTickets(int idUser);
	
	void affecter(int idBug ,int idDev);
	
	
}
