package com.lcwd.user.service.Service.Controller;


import com.lcwd.user.service.Service.entities.Booking;
import com.lcwd.user.service.Service.service.BookingService;
import com.lcwd.user.service.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class BookingController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;


    @RequestMapping("/addBooking/{hotelId}/{roomId}/{userId}")
    public ResponseEntity<Booking> addBookingHandler(String hotelId, String roomId, String userId){
        return ResponseEntity.ok(bookingService.bookRoom(userId,hotelId,roomId));
    }
}
