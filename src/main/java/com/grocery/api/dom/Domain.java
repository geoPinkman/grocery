package com.grocery.api.dom;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "domains")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "domain")
    private String domain;
    @ManyToMany(mappedBy = "domains")
    private List<Person> people;
}
