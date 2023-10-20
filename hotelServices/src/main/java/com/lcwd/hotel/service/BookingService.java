package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Booking;

import java.util.List;

public interface BookingService {
    public String bookRoom(String hotelId, String userId,Booking booking);

    public Booking getBookingById(String bookingId);

    public List<Booking> getAllBooking();

    public String cancelBooking(String bookingId);

    public String completeBooking(String bookingId);

}
