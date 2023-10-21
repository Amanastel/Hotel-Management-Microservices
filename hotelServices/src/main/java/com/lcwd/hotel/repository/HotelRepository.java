package com.lcwd.hotel.repository;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    public List<Hotel> findByLocation(String location);
    public Hotel findByName(String name);
}
