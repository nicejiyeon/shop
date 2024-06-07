package com.apple.shop;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;
}
