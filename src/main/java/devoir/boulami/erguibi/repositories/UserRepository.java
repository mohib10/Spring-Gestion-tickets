package devoir.boulami.erguibi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import devoir.boulami.erguibi.models.Ticket;
import devoir.boulami.erguibi.models.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

	@Query("Select u from User u where u.role.nom = 'developer'")
	List<User> getDevs();
	
	User findByUsername(String name);
}
