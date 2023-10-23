package com.lcwd.user.service.Service.service.Impl;

import com.lcwd.user.service.Service.entities.Hotel;
import com.lcwd.user.service.Service.entities.Rating;
import com.lcwd.user.service.Service.entities.User;
import com.lcwd.user.service.Service.entities.Wallet;
import com.lcwd.user.service.Service.exception.NotFoundException;
import com.lcwd.user.service.Service.external.service.HotelService;
import com.lcwd.user.service.Service.repository.UserRepository;
import com.lcwd.user.service.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0f);
        wallet.setUser(user);
        user.setWallet(wallet);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<Rating> forObj =  restTemplate.getForObject("http://RATING-SERVICE/ratings/all", ArrayList.class);

        logger.info(" {} ", forObj);
//        List<User> users = userRepository.findAll();
//        for(User u: users){
//            u.setRatings(forObj);
//        }
        List<User> users = userRepository.findAll();
//        for(Rating r: forObj) {
//            for (User u : users) {
//                if (r.getUserId() == u.getUserId()) {
//                    u.setRatings(forObj);
//                }
//            }
//        }
        return users;
    }

    @Override
    public User getUserById(String userId) {

//       // http://localhost:8083/ratings/user/0619709d-c854-425c-a8de-2db02b2a7c1a
       User u = userRepository.findById(userId).orElseThrow( () -> new NotFoundException("User not found with id: " + userId));

        Rating[] forObj =  restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+u.getUserId(), Rating[].class);
        logger.info(" {} ", forObj);
        System.out.println(forObj);

        List<Rating> ratings = Arrays.stream(forObj).toList();


        List<Rating> ratingList = ratings.stream().map(rating -> {
//            //http://localhost:8082/hotels/f287f4d1-dd91-4bd6-9f36-a98baacb0ca3
//            ResponseEntity<Hotel> forE = restTemplate.getForEntity("http://HOTELS-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            Hotel hotels = hotelService.getHotel(rating.getHotelId());
//            log.info("{} response status code: ", forE.getStatusCode());
//            Hotel hotel = forE.getBody();
            rating.setHotel(hotels);

            return rating;
        }).collect(Collectors.toList());


        u.setRatings(ratingList);
        return u;


    }

    @Override
    public void deleteUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow( () -> new NotFoundException("User not found with id: " + userId));
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
