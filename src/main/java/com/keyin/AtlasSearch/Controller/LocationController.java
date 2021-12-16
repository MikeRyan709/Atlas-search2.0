package com.keyin.AtlasSearch.Controller;

import com.keyin.AtlasSearch.Model.Location;
import com.keyin.AtlasSearch.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")


public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    //Get method for location
    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations(@RequestParam(required = false) String Location) {
        try {
            List<Location> location = new ArrayList<>();

            if (Location == null)
                locationRepository.findAll().forEach(location::add);
            else
                location.addAll(locationRepository.findByCountry(Location));

            if (location.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(location,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Post method for location
    @PostMapping("/location")
    public ResponseEntity<Location> postLocation(@RequestBody Location location) {
        try {
            Location _location = locationRepository
                    .save(new Location(location.getCity(), location.getCountry(), location.getZipcode(), location.getTimezone()));
            return new ResponseEntity<>(_location, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Update method for location
    @PutMapping("/location")
    public ResponseEntity<Location> updateLocation(@PathVariable(value = "id") long id, @RequestBody Location location){
        Optional<Location> locationInfo = locationRepository.findById(id);

        if(locationInfo.isPresent()) {
            Location _location = locationInfo.get();
            _location.setCity(location.getCity());
            _location.setCountry(location.getCountry());
            _location.setTimezone(location.getTimezone());
            _location.setZipcode(location.getZipcode());

            return new ResponseEntity<>(locationRepository.save(_location), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete Method for location
    @DeleteMapping("/location/{id}")
    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable(value = "id") long id) {
        try {
            locationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
