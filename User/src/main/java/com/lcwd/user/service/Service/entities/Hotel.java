package com.lcwd.user.service.Service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;


}
