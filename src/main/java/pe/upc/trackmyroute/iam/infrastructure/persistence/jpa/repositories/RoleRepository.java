package pe.upc.trackmyroute.iam.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.trackmyroute.iam.domain.model.entities.Role;
import pe.upc.trackmyroute.iam.domain.model.valueobjects.Roles;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
