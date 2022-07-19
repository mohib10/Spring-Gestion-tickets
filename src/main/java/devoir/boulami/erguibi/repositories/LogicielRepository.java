package devoir.boulami.erguibi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devoir.boulami.erguibi.models.Logiciel;

@Repository
public interface LogicielRepository  extends JpaRepository<Logiciel, Integer>{

}
