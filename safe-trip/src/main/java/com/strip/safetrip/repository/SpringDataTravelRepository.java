package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataTravelRepository extends TravelRepository, JpaRepository<Travel, Long> {
    <S extends Travel> List<S> saveAll(Iterable<S> list);
}
