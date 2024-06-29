package com.app.demoproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Bus {
    @Id
    private Long id;

    String seatPlan;

    Double ticketFare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busOperatorId", nullable = false, referencedColumnName = "id")
    BusOperator busOperator;

    @OneToMany
    List<RouteDetails> routeDetails;
}
