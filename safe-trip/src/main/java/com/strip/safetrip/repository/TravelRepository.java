package com.strip.safetrip.repository;

import com.strip.safetrip.domain.Travel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TravelRepository {

    <S extends Travel> List<S> saveAll(Iterable<S> entities);

}

