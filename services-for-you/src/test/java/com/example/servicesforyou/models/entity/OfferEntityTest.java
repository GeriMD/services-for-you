package com.example.servicesforyou.models.entity;

import com.example.servicesforyou.models.enums.ServicesCategoryEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OfferEntityTest {
    @Test
    public void testDescriptionGetterAndSetter() {
        OfferEntity offerEntity = new OfferEntity();
        String description = "Sample Description";
        offerEntity.setDescription(description);
        assertEquals(description, offerEntity.getDescription());
    }

    @Test
    public void testPriceGetterAndSetter() {
        OfferEntity offerEntity = new OfferEntity();
        BigDecimal price = BigDecimal.valueOf(100.0);
        offerEntity.setPrice(price);
        assertEquals(price, offerEntity.getPrice());
    }

    @Test
    public void testCategoryGetterAndSetter() {
        OfferEntity offerEntity = new OfferEntity();
        ServicesCategoryEnum category = ServicesCategoryEnum.CARE;
        offerEntity.setCategory(category);
        assertEquals(category, offerEntity.getCategory());
    }
}
