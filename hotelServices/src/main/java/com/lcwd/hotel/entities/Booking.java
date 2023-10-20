package com.lcwd.hotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    private String bookingId;
    private String userId;
    private String roomId;
    private LocalDate bookingDate;
    private LocalDate checkOutDate;
    private Integer amount;
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JsonIgnore
    private Hotel hotel;
    @Transient
    @JsonIgnore
    private User user;

}
