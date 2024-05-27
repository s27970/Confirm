package com.confirm.confirm.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRec {
    private String eventName;
    private String location;
    private List<String> eventType;
    private int recruitmentCount;
    private String validDate;
    private String details;
}
