package com.lcwd.user.service.Service.entities;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Room {
    private String roomId;
    private String roomType;
    private String roomNumber;
    private Integer roomPrice;
    private Status Status;
    private String roomDescription;
    private Hotel hotel;
}
