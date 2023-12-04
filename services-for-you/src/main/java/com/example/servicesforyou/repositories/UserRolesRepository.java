package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
    @Query("SELECT ur FROM UserRolesEntity ur WHERE ur.userRole = :role")
    Optional<UserRolesEntity> findByRole(@RequestParam RolesEnum role);

}
