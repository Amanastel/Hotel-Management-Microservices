package com.lcwd.hotel.service.Impl;

import com.lcwd.hotel.entities.Booking;
import com.lcwd.hotel.entities.Room;
import com.lcwd.hotel.entities.Status;
import com.lcwd.hotel.repository.BookingRepository;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.repository.RoomRepository;
import com.lcwd.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingImpl implements BookingService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Boolean bookRoom(Booking book) {

        Room room = roomRepository.findById(book.getRoomId()).orElseThrow( () -> new RuntimeException("Room not found with id: " + book.getRoomId() + ""));

        if(room.getStatus().equals("BOOKED")) {
            return false;
        }

        Booking booking = new Booking();
        booking.setHotel(book.getHotel());
        booking.setRoomId(book.getRoomId());
        booking.setBookingId(book.getBookingId());
        booking.setAmount(book.getAmount());
        booking.setPaymentStatus(book.getPaymentStatus());
        booking.setBookingDate(book.getBookingDate());
        booking.setCheckOutDate(book.getCheckOutDate());
        booking.setUserId(book.getUserId());

        room.setStatus(Status.BOOKED);
        bookingRepository.save(booking);
        return true;

    }
}
