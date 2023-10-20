package com.lcwd.user.service.Service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private String hotelId;
    private String roomId;
    private LocalDate bookingDate;
    private LocalDate checkOutDate;
    private Integer amount;
    private PaymentStatus paymentStatus;

    private BookingStatus bookingStatus;
    @ManyToOne
    @JsonIgnore
    private User user;
}