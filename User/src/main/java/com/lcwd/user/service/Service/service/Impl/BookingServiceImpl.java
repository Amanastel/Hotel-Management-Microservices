package com.lcwd.user.service.Service.service.Impl;

import com.lcwd.user.service.Service.entities.*;
import com.lcwd.user.service.Service.exception.BookingException;
import com.lcwd.user.service.Service.exception.HotelException;
import com.lcwd.user.service.Service.exception.NotFoundException;
import com.lcwd.user.service.Service.exception.UserException;
import com.lcwd.user.service.Service.external.service.HotelService;
import com.lcwd.user.service.Service.repository.BookingRepository;
import com.lcwd.user.service.Service.repository.UserRepository;
import com.lcwd.user.service.Service.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
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
    public Booking bookRoom(String userId, String hotelId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));

        Hotel hotels = hotelService.getHotel(hotelId);
        if(hotels == null){
            throw new HotelException("Hotel not found");
        }

        List<Room> rooms = hotels.getRooms();
        Room room = rooms.stream().filter(r -> r.getStatus().equals(Status.AVAILABLE)).findFirst().orElseThrow(() -> new NotFoundException("Room not found"));
        log.info("Room: {}",room);


//        Room room = rooms.stream().filter(r -> r.getRoomId().equals(roomId)).findFirst().orElseThrow(() -> new HotelException("Room not found"));
//        log.info("Room: {}",room);
//        if(room.getStatus().equals(Status.BOOKED)){
//            throw new BookingException("Room already booked");
//        }


        Booking booking = new Booking();
        booking.setUser(user);
        booking.setHotelId(hotelId);
        booking.setRoomId(room.getRoomId());
        booking.setBookingId("BOOKING-" + System.currentTimeMillis());
        booking.setAmount(room.getRoomPrice());
        booking.setPaymentStatus(PaymentStatus.UNPAID);
        booking.setBookingDate(LocalDate.now());
        booking.setCheckOutDate(LocalDate.now().plusDays(1));
        booking.setBookingStatus(BookingStatus.BOOKED);
        room.setStatus(Status.BOOKED);



        log.info("Booking: line 66 {} ",booking);
        String isBookingAdded = restTemplate.postForObject("http://HOTELS-SERVICE/hotels/addBooking/"+hotelId+"/"+userId,booking,String.class);

        log.info("Boolean isBookingAdded {} ", isBookingAdded);
//        Rating[] forObj =  restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+u.getUserId(), Rating[].class);
//        log.info(" {} ", forObj);
//        System.out.println(forObj);
//        Boolean isBookingAdded = hotelService.addBookingFromHotel(booking);

        if(isBookingAdded.equals("BOOKED")){
            log.info("Booking added");
        }else{
            throw new BookingException("Booking not added");

        }
        bookingRepository.save(booking);


        return booking;

    }

    @Override
    public String cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow( () -> new BookingException("Booking not found with id: " + bookingId + ""));
        log.info("Booking: {}",booking);


        String cancelBooking = restTemplate.getForObject("http://HOTELS-SERVICE/hotels/cancelBooking/"+bookingId,String.class);
        log.info("Boolean 99 cancelBooking {} ", cancelBooking);
        if(cancelBooking.equals("CANCELLED")){
            booking.setBookingStatus(BookingStatus.CANCELLED);
            log.info("Booking cancelled");
        }else {
            throw new BookingException("Booking not cancelled "+cancelBooking+" Please try again");
        }
        bookingRepository.save(booking);
        return "Booking cancelled";
    }

    @Override
    public String cancelAllBookings(String userId) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings(String userId) {
        return null;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow( () -> new BookingException("Booking not found with id: " + bookingId + ""));
    }
}
