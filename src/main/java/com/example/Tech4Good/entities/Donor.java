package com.example.Tech4Good.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "donors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeProduct;
    private Boolean Status;
    private String address;
    @ManyToOne
    private User user;
}
