package devoir.boulami.erguibi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devoir.boulami.erguibi.models.Urgence;


@Repository
public interface UrgenceRepository  extends JpaRepository<Urgence, Integer>{

}
