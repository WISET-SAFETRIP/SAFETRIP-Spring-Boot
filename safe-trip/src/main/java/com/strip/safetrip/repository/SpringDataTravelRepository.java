package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataTravelRepository extends TravelRepository, JpaRepository<Travel, Long> {
    <S extends Travel> List<S> saveAll(Iterable<S> list);
    Page<Travel> findByInsideAndFieldNo(@Param("inside") boolean inside,
                                                       @Param("field_no") int fieldNo,
                                                       Pageable pageable);
}
