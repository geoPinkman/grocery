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
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "nick_name")
    private String nickname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "domains_persons",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id", referencedColumnName = "id")
    )
    private List<Domain> domains;
    @OneToOne(optional = false, mappedBy = "person")
    private PersonInfo info;
}
