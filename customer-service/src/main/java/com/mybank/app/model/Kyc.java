package com.mybank.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kyc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String aadharCard;
    private String panCard;

    @OneToOne(mappedBy = "kyc")
    private Customer customer;


}
