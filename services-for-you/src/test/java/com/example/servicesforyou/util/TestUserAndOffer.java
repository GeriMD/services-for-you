package com.example.servicesforyou.util;

import com.example.servicesforyou.models.entity.OfferEntity;
import com.example.servicesforyou.models.entity.SellersEntity;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.enums.ServicesCategoryEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.repositories.OffersRepository;
import com.example.servicesforyou.repositories.SellerRepository;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.repositories.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TestUserAndOffer {

    @Autowired
  private UserRepository userRepository;

    @Autowired
    private OffersRepository offersRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private UserRolesRepository rolesRepository;



    public OfferEntity createOffer(UserEntity user){
        return creatingOffer(user);
    }
    public UserEntity createUser(String email){
        return creatingUser(email);
    }

    private OfferEntity creatingOffer(UserEntity user){
        SellersEntity seller = new SellersEntity();
        seller.setAge(user.getAge());
        seller.setEmail(user.getEmail());
        seller.setPhoneNumber(user.getPhoneNumber());
        seller.setId(user.getId());
        seller.setFirstName(user.getFirstName());
        seller.setLastName(user.getLastName());
        sellerRepository.save(seller);


        OfferEntity offer = new OfferEntity();
        offer.setSeller(seller);
        offer.setDescription("test description");
        offer.setCategory(ServicesCategoryEnum.CLEANING);
        offer.setPrice(BigDecimal.TEN);


        return offersRepository.save(offer);

    }
    private UserEntity creatingUser(String username){
        String roleStringUser = "USER";
        RolesEnum userRole = RolesEnum.valueOf(roleStringUser);
        UserRolesEntity roleUser = rolesRepository.findByRole(userRole).orElseThrow();

        UserEntity user = new UserEntity();
        user.setTown(TownsEnum.VIDIN);
        user.setAge(18);
        user.setPassword("123456");
        user.setEmail(username);
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setPhoneNumber("0888888888");
        user.setUserRoles(List.of(roleUser));

        return userRepository.save(user);
    }

    public void cleanUp() {
        userRepository.deleteAll();
        offersRepository.deleteAll();
        sellerRepository.deleteAll();
    }
}
