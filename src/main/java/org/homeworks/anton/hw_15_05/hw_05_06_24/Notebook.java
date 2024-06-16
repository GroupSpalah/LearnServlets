package org.homeworks.anton.hw_15_05.hw_05_06_24;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Notebook {
    int id;
    String name;
}
