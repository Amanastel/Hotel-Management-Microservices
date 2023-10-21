package com.lcwd.user.service.Service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;
    private List<Room> rooms;
    @JsonIgnore
    private List<Booking> bookings;

}
