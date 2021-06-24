package com.strip.safetrip.service;

import com.strip.safetrip.domain.Travel;
import com.strip.safetrip.repository.TravelRepository;
import com.strip.safetrip.tourApi.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TravelService {

    private final TravelRepository travelRepository;

    private final Requester requester;

    public TravelService(TravelRepository travelRepository, Requester requester) {
        this.travelRepository = travelRepository;
        this.requester = requester;
    }

    public void add(int gu) throws Exception {
        Requester requester = new Requester();
        List<Travel> list = requester.getAreaBasedList("Y", "A", 14, gu);
        list.addAll(requester.getAreaBasedList("Y", "A", 38, gu));
        list.addAll(requester.getAreaBasedList("Y", "A", 39, gu));
        list.addAll(requester.getAreaBasedList("Y", "A", 12, gu));

        travelRepository.saveAll(list);
    }

    public List<Travel> listByInsideAndFieldNo(boolean inside, int fieldNo, Pageable pageable) {
        return travelRepository.findByInsideAndFieldNo(inside, fieldNo, pageable).getContent();
    }

    public String listDetail(Long travelNo, Integer contentTypeId) throws Exception {
        return requester.getDetail(travelNo, contentTypeId);
    }
}
