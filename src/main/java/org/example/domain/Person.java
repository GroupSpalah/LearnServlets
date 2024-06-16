package org.example.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue
    int id;
    String name;
    int age;

    @OneToOne(cascade = CascadeType.PERSIST)
    Address address;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Phone> phones;
}
