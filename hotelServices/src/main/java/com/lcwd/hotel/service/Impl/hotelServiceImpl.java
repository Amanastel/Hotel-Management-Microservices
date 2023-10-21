package com.lcwd.hotel.service.Impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.entities.Room;
import com.lcwd.hotel.entities.Status;
import com.lcwd.hotel.exception.NotFoundException;
import com.lcwd.hotel.repository.BookingRepository;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.repository.RoomRepository;
import com.lcwd.hotel.service.hotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
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

        log.info("Hotel: " + hotel);
//        room.setRoomId(UUID.randomUUID().toString());
        hotel.getRooms().add(room);
        room.setHotel(hotel);
        room.setStatus(Status.AVAILABLE);
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
        List<Room> availableRooms = new ArrayList<>();
        for(Room room: rooms) {
            if(room == null) {
                continue;
            }
            if(room.getStatus().equals(Status.AVAILABLE)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public List<Room> getAllBookedRoom(String hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        List<Room> rooms = hotel.getRooms();
        return rooms.stream().filter(r -> r.getStatus().equals(Status.BOOKED)).toList();
    }

    @Override
    public List<Room> getAllRooms(String hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        List<Room> rooms = hotel.getRooms();
        return rooms;
    }

    @Override
    public Room deleteRoomById(String roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow( () -> new NotFoundException("Room not found with id: " + roomId + ""));
        roomRepository.deleteById(roomId);
        return room;
    }

    @Override
    public List<Hotel> getHotelByLocation(String location) {
        List<Hotel> hotels = hotelRepository.findByLocation(location);
        if (hotels.isEmpty()) {
            throw new NotFoundException("Hotel not available with location: " + location + "");
        }
        return hotels;
    }

    @Override
    public Hotel getHotelByName(String name) {
        Hotel hotel = hotelRepository.findByName(name);
        if (hotel == null) {
            throw new NotFoundException("Hotel not available with name: " + name + "");
        }
        return hotel;
    }
}










