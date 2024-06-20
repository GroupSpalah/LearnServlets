package org.homeworks.anton.hw_16_06_24.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String lastName;

    int age;

    @Enumerated(EnumType.STRING)
    Qualification qualification;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Truck> trucks;
}
