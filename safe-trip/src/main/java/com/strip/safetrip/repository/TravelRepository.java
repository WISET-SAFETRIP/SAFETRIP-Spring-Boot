package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;

import java.util.List;

public interface TravelRepository {

    <S extends Travel> List<S> saveAll(Iterable<S> entities);

}
