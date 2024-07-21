package org.homeworks.anton.hw_16_06_24.domain;

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
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String model;
    int date;
}
