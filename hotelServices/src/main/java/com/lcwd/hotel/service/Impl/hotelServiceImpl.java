package com.lcwd.hotel.service.Impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.entities.Room;
import com.lcwd.hotel.exception.NotFoundException;
import com.lcwd.hotel.repository.BookingRepository;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.repository.RoomRepository;
import com.lcwd.hotel.service.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class hotelServiceImpl implements hotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public Hotel addHotel(Hotel hotel) {
        String randomUserId = UUID.randomUUID().toString();
        hotel.setId(randomUserId);
        return hotelRepository.save(hotel);
    }


    @Override
    public Hotel getHotelById(String hotelId) {

        return hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel deleteHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));
    }

    @Override
    public Room addRoom(String hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        room.setRomeId(UUID.randomUUID().toString());
        hotel.getRooms().add(room);
        hotelRepository.save(hotel);
        return room;
    }

    @Override
    public Room getRoomById(String roomId) {
        return roomRepository.findById(roomId).orElseThrow( () -> new NotFoundException("Room not found with id: " + roomId + ""));
    }

    @Override
    public List<Room> getAllAvailableRoom(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        List<Room> rooms = hotel.getRooms();
        return rooms.stream().filter(r -> r.getStatus().equals("AVAILABLE")).toList();
    }

    @Override
    public List<Room> getAllBookedRoom(String hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        List<Room> rooms = hotel.getRooms();
        return rooms.stream().filter(r -> r.getStatus().equals("BOOKED")).toList();
    }
}










