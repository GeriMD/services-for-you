package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.SellersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellersEntity, Long> {
    Optional<SellersEntity> findByEmail(String username);

}
