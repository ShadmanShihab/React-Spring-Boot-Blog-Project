package com.app.demoproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Station {
    @Id
    private Integer id;

    private String name;

    private String district;

    private Integer rating;

    @OneToMany
    List<RouteDetails> routeDetails;
}
