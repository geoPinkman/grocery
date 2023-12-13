package com.grocery.api.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickname;
    private String phoneNumber;
    private String address;
    @ManyToMany
    private List<Domains> domains;

}
