package kz.iitu.Security.repository;



import kz.iitu.Security.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
