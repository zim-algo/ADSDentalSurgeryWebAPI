package CS489.miu.ads.repository;

import CS489.miu.ads.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    public abstract Optional<Role> findByName(String name);

}
