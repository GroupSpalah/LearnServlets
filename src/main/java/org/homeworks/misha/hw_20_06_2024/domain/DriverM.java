package org.homeworks.misha.hw_20_06_2024.domain;

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
public class DriverM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String lastName;

    int age;

    @Enumerated(EnumType.STRING)
    Qualification qualification;

    @OneToMany(cascade = CascadeType.MERGE)
    List<TruckM> trucks;

}
