package com.example.SpringBootMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @SequenceGenerator(name = "person_seq", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_seq")
    private Integer id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Flat> flats;

    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;
}
