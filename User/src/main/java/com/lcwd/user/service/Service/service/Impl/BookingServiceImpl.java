package com.lcwd.user.service.Service.service.Impl;

import com.lcwd.user.service.Service.entities.*;
import com.lcwd.user.service.Service.exception.BookingException;
import com.lcwd.user.service.Service.exception.HotelException;
import com.lcwd.user.service.Service.exception.UserException;
import com.lcwd.user.service.Service.external.service.HotelService;
import com.lcwd.user.service.Service.repository.BookingRepository;
import com.lcwd.user.service.Service.repository.UserRepository;
import com.lcwd.user.service.Service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking bookRoom(String userId, String hotelId, String roomId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));

        Hotel hotels = hotelService.getHotel(hotelId);
        if(hotels == null){
            throw new HotelException("Hotel not found");
        }

        List<Room> rooms = hotels.getRooms();

        Room room = rooms.stream().filter(r -> r.getRoomId().equals(roomId)).findFirst().orElseThrow(() -> new HotelException("Room not found"));

        if(room.getStatus().equals(Status.BOOKED)){
            throw new BookingException("Room already booked");
        }


        Booking booking = new Booking();
        booking.setUser(user);
        booking.setHotelId(hotelId);
        booking.setRoomId(roomId);
        booking.setBookingId("BOOKING-" + System.currentTimeMillis());
        booking.setAmount(room.getRoomPrice());
        booking.setPaymentStatus(PaymentStatus.UNPAID);
        booking.setBookingDate(LocalDate.now());
        booking.setCheckOutDate(LocalDate.now().plusDays(1));
        room.setStatus(Status.BOOKED);


        Boolean isBookingAdded = hotelService.addBookingFromHotel(booking);
        if(!isBookingAdded){
            throw new BookingException("Booking failed");
        }
        bookingRepository.save(booking);


        return booking;

    }

    @Override
    public Booking cancelBooking(String userId, String roomId) {
        return null;
    }

    @Override
    public String cancelAllBookings(String userId) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings(String userId) {
        return null;
    }
}
