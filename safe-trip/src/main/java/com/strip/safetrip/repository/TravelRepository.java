package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TravelRepository {

    <S extends Travel> List<S> saveAll(Iterable<S> entities);
    <S extends Travel> Page<S> findByInsideAndFieldNo(@Param("inside") boolean inside,
                                                       @Param("field_no") int fieldNo,
                                                       Pageable pageable);
}
