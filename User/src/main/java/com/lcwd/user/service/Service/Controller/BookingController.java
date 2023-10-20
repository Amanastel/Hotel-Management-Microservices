package com.lcwd.user.service.Service.Controller;


import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.service.BookingService;
import com.lcwd.user.service.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/cancelBooking/{bookingId}")
    public ResponseEntity<String> cancelBookingHandler(@PathVariable String bookingId){
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }

}
