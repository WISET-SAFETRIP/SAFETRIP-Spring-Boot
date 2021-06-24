package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JpaTravelRepository implements TravelRepository {

    private final EntityManager em;
    public JpaTravelRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public <S extends Travel> List<S> saveAll(Iterable<S> entities) {
        for(Travel travel : entities) {
            System.out.println(travel.getTravelNo());
            em.persist(travel);
        }
        Iterator<S> iterator = entities.iterator();
        List<S> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }

    @Override
    public <S extends Travel> Page<S> findByInsideAndFieldNo(boolean inside, int fieldNo, Pageable pageable) {
        return null;
    }
}
