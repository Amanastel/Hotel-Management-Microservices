package com.lcwd.user.service.Service.service;

import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.entities.Hotel;

import java.util.List;

public interface BookingService {
    public Booking bookRoom(String userId, String hotelId, String roomId);

    public Booking cancelBooking(String userId, String roomId);

    public String cancelAllBookings(String userId);

    public List<Booking> getAllBookings(String userId);


}
