package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;

import java.util.List;

public interface TravelRepository {

    public List<Travel> saveList(List<Travel> list);

}
