package devoir.boulami.erguibi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import devoir.boulami.erguibi.models.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Integer>{

	@Query("Select t from Ticket t where t.bug.id =:idBug")
	Ticket getByBug(@Param("idBug") int idBug);
	
	@Query("Select t from Ticket t where t.user.id =:idUser")
	List<Ticket> getByUser(@Param("idUser") int idUser);
}
