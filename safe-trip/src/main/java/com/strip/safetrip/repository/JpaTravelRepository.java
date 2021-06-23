package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaTravelRepository implements TravelRepository {

    private final EntityManager em;
    public JpaTravelRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Travel> saveList(List<Travel> list) {
        for(Travel travel : list) {
            System.out.println(travel.getTravel_no());
            em.persist(travel);
        }
        return list;
    }
}
