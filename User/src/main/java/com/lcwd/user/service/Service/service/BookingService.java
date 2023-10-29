package com.lcwd.user.service.Service.service;

import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.entities.Hotel;

import java.util.List;

public interface BookingService {
    public Booking bookRoom(String userId, String hotelId);

    public String cancelBooking(String bookingId);

    public List<Booking> getAllBookings(String userId);

    public Booking getBookingById(String bookingId);
    public List<Booking> getAllBookingsByHotelId(String hotelId);

    public List<Hotel> getHotelByLocation(String location);

    public List<Hotel> getHotelByName(String name);

    public List<Hotel> availableHotels(String hotelId);

    public Booking completeBooking(String bookingId);

}
