package com.lcwd.hotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomId;
    private String roomType;
    private String roomNumber;
    private Integer roomPrice;
    private Status Status;
    private String roomDescription;
    @ManyToOne
    @JsonIgnore
    private Hotel hotel;

}
