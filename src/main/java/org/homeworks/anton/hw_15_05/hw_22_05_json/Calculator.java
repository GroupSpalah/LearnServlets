package org.homeworks.anton.hw_15_05.hw_22_05_json;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Calculator {
   double valueOne;
     double valueTwo;
    String operation;
}
