package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.SellersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellersEntity, Long> {
}
