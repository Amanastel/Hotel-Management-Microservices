package com.lcwd.user.service.Service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer walletId;


    @DecimalMin("0.0")
    @NotNull(message="Balance cannot be null")
    private Float balance;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="walletId")
    private List<Transactions> transactions = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private User user;

}
