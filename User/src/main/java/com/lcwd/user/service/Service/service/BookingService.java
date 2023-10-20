package com.lcwd.user.service.Service.service;

import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.entities.Hotel;

import java.util.List;

public interface BookingService {
    public Booking bookRoom(String userId, String hotelId);

    public String cancelBooking(String bookingId);

    public String cancelAllBookings(String userId);

    public List<Booking> getAllBookings(String userId);

    public Booking getBookingById(String bookingId);


}
