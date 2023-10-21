package com.lcwd.user.service.Service.repository;

import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    public List<Booking> findByHotelId(String hotelId);
    public List<Booking> findByUser(User user);

}
