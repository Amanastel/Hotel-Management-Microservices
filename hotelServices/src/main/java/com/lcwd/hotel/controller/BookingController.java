package com.lcwd.hotel.controller;

import com.lcwd.hotel.entities.Booking;
import com.lcwd.hotel.service.BookingService;
import com.lcwd.hotel.service.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class BookingController {

    @Autowired
    private hotelService hotelService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/addBooking")
    public ResponseEntity<Boolean> addBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.bookRoom(booking));
    }
}
