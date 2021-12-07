package com.keyin.AtlasSearch.Repository;

import com.keyin.AtlasSearch.Model.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

     List<Location> findByZip(@Param("zipcode") String zipcode);
}
