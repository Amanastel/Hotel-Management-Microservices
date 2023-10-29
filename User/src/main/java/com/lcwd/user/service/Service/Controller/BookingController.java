package com.lcwd.user.service.Service.Controller;


import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.entities.Hotel;
import com.lcwd.user.service.Service.service.BookingService;
import com.lcwd.user.service.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class BookingController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;


    @PostMapping("/addBooking/{hotelId}/{userId}")
    public ResponseEntity<Booking> addBookingHandler(@PathVariable String hotelId, @PathVariable String userId){
        return ResponseEntity.ok(bookingService.bookRoom(userId,hotelId));
    }

    @GetMapping("/getBooking/{bookingId}")
    public ResponseEntity<Booking> getBookingByIdHandler(@PathVariable String bookingId){
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));

    }


    @PostMapping("/completeBooking/{bookingId}")
    public ResponseEntity<Booking> completeBookingHandler(@PathVariable String bookingId){
        return ResponseEntity.ok(bookingService.completeBooking(bookingId));
    }


    @DeleteMapping("/cancelBooking/{bookingId}")
    public ResponseEntity<String> cancelBookingHandler(@PathVariable String bookingId){
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }

    @GetMapping("/getAllBookings/{userId}")
    public ResponseEntity<List<Booking>> getAllBookingsHandler(@PathVariable String userId){
        return ResponseEntity.ok(bookingService.getAllBookings(userId));
    }

    @GetMapping("/getAllBookingsByHotelId/{hotelId}")
    public ResponseEntity<List<Booking>> getAllBookingsByHotelIdHandler(@PathVariable String hotelId){
        return ResponseEntity.ok(bookingService.getAllBookingsByHotelId(hotelId));
    }

    @GetMapping("/getHotelByLocation/{location}")
    public ResponseEntity<List<Hotel>> getHotelByLocationHandler(@PathVariable String location){
        return ResponseEntity.ok(bookingService.getHotelByLocation(location));
    }

    @GetMapping("/getHotelByName/{name}")
    public ResponseEntity<List<Hotel>> getHotelByNameHandler(@PathVariable String name){
        return ResponseEntity.ok(bookingService.getHotelByName(name));
    }

    @GetMapping("/availableHotels/{hotelId}")
    public ResponseEntity<List<Hotel>> availableHotelsHandler(@PathVariable String hotelId){
        return ResponseEntity.ok(bookingService.availableHotels(hotelId));
    }
}
