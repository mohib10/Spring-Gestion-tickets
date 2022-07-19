package devoir.boulami.erguibi.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devoir.boulami.erguibi.models.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
