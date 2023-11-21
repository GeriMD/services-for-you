package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.TownsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<TownsEntity, Long> {
}
