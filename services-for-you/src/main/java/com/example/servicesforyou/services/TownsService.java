package com.example.servicesforyou.services;

import com.example.servicesforyou.models.entity.TownsEntity;
import com.example.servicesforyou.models.entity.UserRolesEntity;
import com.example.servicesforyou.models.enums.RolesEnum;
import com.example.servicesforyou.models.enums.TownsEnum;
import com.example.servicesforyou.repositories.TownRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TownsService {
    private final TownRepository townRepository;

    public TownsService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }


    public void initTowns(){
        if (townRepository.count() != 0){
            return;
        }

        Arrays.stream(TownsEnum.values()).forEach(
                town -> {
                    TownsEntity currentTown = new TownsEntity();
                    currentTown.setTownName(town);

                    townRepository.save(currentTown);
                }
        );
    }
}
