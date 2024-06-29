package com.app.demoproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class BusSchedule {
    @Id
    private Long id;

    LocalDateTime departureTime;

    LocalDateTime arrivalTime;

    @OneToMany
    List<RouteDetails> routeDetails;
}
