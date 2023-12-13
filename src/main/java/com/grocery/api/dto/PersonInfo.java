package com.grocery.api.dto;

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
    private long id;
    @Column(name = "additional_information")
    private String additionalInfo;
    @OneToOne
    @JoinColumn(name = "id")
    private Person person;

}
