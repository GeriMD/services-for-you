package com.example.servicesforyou.repositories;

import com.example.servicesforyou.models.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Long> {
}
