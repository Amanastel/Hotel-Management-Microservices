package com.lcwd.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    private String romeId;
    private String roomType;
    private String roomNumber;
    private Integer roomPrice;
    private Status Status;
    private String roomDescription;
    @ManyToOne
    private Hotel hotel;

}
