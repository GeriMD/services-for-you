package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepository extends JpaRepository<OfferEntity, Long> {
}
