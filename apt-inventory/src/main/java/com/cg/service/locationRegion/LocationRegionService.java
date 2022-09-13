package com.cg.service.locationRegion;

import com.cg.model.LocationRegion;

import java.util.List;
import java.util.Optional;

public interface LocationRegionService {

    List<LocationRegion> findAll();

    Optional<LocationRegion> findById(Long id);

    LocationRegion getById(Long id);

    LocationRegion save(LocationRegion locationRegion);

    void remove(Long id);
}
