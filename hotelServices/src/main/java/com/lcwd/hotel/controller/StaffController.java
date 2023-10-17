package com.lcwd.hotel.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {


    @GetMapping("/all")
    public ResponseEntity<List<String >> getStaff(){
        List<String > list = Arrays.asList("ram","sita","rahul","kumar");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
