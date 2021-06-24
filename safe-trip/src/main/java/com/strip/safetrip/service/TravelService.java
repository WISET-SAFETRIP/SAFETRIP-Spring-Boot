package com.strip.safetrip.service;

import com.strip.safetrip.domain.Travel;
import com.strip.safetrip.repository.TravelRepository;
import com.strip.safetrip.tourApi.Requester;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public void add(int gu) throws Exception {
        Requester requester = new Requester();
        List<Travel> list = requester.getAreaBasedList("Y", "A", 14, gu);
        list.addAll(requester.getAreaBasedList("Y", "A", 38, gu));
        list.addAll(requester.getAreaBasedList("Y", "A", 39, gu));
        list.addAll(requester.getAreaBasedList("Y", "A", 12, gu));
        list.addAll(requester.getAreaBasedList("Y", "A", 28, gu));

        travelRepository.saveAll(list);
    }
}
