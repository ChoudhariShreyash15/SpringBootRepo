package com.example.SpringBootMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat {

    @Id
    @SequenceGenerator(name = "flat-seq", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "flat_seq")
    private int id;
    private Integer area;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;
}
