package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
}
