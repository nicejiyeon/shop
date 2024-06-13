package com.apple.shop.board;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;

    @Temporal(TemporalType.TIMESTAMP)
    public Date date;
}
