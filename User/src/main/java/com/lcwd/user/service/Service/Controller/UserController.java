package com.lcwd.user.service.Service.Controller;


import com.lcwd.user.service.Service.entities.User;
import com.lcwd.user.service.Service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

/*
   {    "name": "user 1",
        "email": "user1@mail",
         "about": "this is user 1"
     }

 */

    @PostMapping
    public ResponseEntity<User> addUserHandler(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    int retryCount = 0;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserByIdHandler(@PathVariable String userId){
        log.info("Retry count {}: ",retryCount);
        retryCount++;
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }


    //creating fall back method for circuitBreaker


    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
//        log.info("Fallback is executed because services is down : ", ex.getMessage());
        User user = new User();
        user.setEmail("dummy@mail.com");
        user.setName("dummy user");
        user.setUserId("dummy rating");
        user.setAbout("this user create dummy because some service is down :");
        return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/all")
    @RateLimiter(name = "userRateLimiterAllData", fallbackMethod = "ratingHotelFallbackAll")
    public ResponseEntity<List<User>> getAllUsersHandler(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    public ResponseEntity<List<User>> ratingHotelFallbackAll(Exception ex){
        log.info("Fallback is executed because services is down {}: ",retryCount);
        retryCount++;
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setEmail("dummy@mail.com");
        user.setName("dummy user");
        user.setUserId("dummy rating");
        user.setAbout("this user create dummy because some service is down :");
        userList.add(user);
        return new ResponseEntity<>(userList,HttpStatus.BAD_REQUEST);
    }
}
