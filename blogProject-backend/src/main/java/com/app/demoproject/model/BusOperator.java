package com.app.demoproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.awt.*;
import java.util.List;

@Entity
public class BusOperator {
    @Id
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "busOperator")
    private List<Bus> busList;

    @OneToMany
    List<RouteDetails> routeDetails;
}
