package com.grocery.api.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "domains")
@NoArgsConstructor
@Getter
@Setter
public class Domains {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "domain")
    private String domain;
    @ManyToMany
    private List<Persons> persons;
}
