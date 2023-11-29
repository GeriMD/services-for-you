package com.example.servicesforyou.services;

import com.example.servicesforyou.models.entity.CategoriesEntity;
import com.example.servicesforyou.models.enums.ServicesCategoryEnum;
import com.example.servicesforyou.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoriesService {

    private final CategoryRepository categoryRepository;

    public CategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {
        if (categoryRepository.count() != 0){
            return;
        }

            Arrays.stream(ServicesCategoryEnum.values()).forEach(
                    servicesCategoryEnum -> {
                        CategoriesEntity category = new CategoriesEntity();
                        category.setCategories(servicesCategoryEnum);

                        categoryRepository.save(category);
                    }
            );
    }
}
