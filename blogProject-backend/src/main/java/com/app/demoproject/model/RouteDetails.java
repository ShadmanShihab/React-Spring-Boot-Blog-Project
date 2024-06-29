package com.app.demoproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RouteDetails {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    BusSchedule busSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    Station station;

}
