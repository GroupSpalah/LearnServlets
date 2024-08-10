package org.homeworks.misha.hw_20_06_2024.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TruckM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String model;
    int date;

    @ManyToOne
    private DriverM driver;
}
