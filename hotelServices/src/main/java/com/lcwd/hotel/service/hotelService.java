package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;

import java.util.List;

public interface hotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel getHotelById(String hotelId);
    public List<Hotel> getAllHotels();

    public Hotel deleteHotelById(String hotelId);
}
