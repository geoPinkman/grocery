package com.grocery.api.dom;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "person_info")
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "additional_information")
    private String additionalInfo;
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Person person;

}
