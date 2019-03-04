package com.foxminded.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum DayOfWeek {
    MONDAY("MONDAY"), TUESDAY("TUESDAY"), WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"), FRIDAY("FRIDAY"), SATURDAY("SATURDAY"), SUNDAY("SUNDAY");
    
     private DayOfWeek(String value) {
            this.value=value;
        }    
    private String value;
}
