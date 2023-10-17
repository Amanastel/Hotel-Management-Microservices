package com.lcwd.user.service.Service.entities;

import lombok.Data;

@Data
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;

    private Hotel hotel;
}
